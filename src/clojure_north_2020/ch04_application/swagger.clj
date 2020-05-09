(ns clojure-north-2020.ch04-application.swagger
  (:require [clojure-north-2020.ch02-datalog.x06-queries :as queries]
            [datahike.core :as d]
            [muuntaja.core :as m]
            [reitit.coercion.spec]
            [reitit.ring :as ring]
            [reitit.ring.coercion :as coercion]
            [reitit.ring.middleware.exception :as exception]
            [reitit.ring.middleware.multipart :as multipart]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [reitit.ring.middleware.parameters :as parameters]
            [reitit.swagger :as swagger]
            [reitit.swagger-ui :as swagger-ui]
            [ring.util.http-response
             :refer
             [bad-request content-type file-response header not-found ok]]))

(defn alignment-query-handler [{:keys [dh-conn] :as _request}]
  (ok
    (map
      (fn [[n a]] {:name n :alignment a})
      (d/q queries/alignment-query @dh-conn))))


(defn nemeses-query-handler [{:keys [dh-conn params] :as _request}]
  (let [{n "name"} params]
    (ok
      (d/q queries/nemeses-query @dh-conn n))))

(def handler
  (ring/ring-handler
    (ring/router
      [["/swagger.json"
        {:get {:no-doc  true
               :swagger {:info     {:title "my-api"}
                         :basePath "/"}
               :handler (swagger/create-swagger-handler)}}]
       ["/api"
        ["/alignments"
         {:get {:summary "Query"
                :handler alignment-query-handler}}]
        ["/nemeses"
         {:get {:summary "Get the nemeses of our hero"
                :handler nemeses-query-handler
                :parameters {:query {:name string?}}}}]]
       ["/math"
        {:swagger {:tags ["math"]}}

        ["/plus"
         {:get  {:summary    "plus with spec query parameters"
                 :parameters {:query {:x int?, :y int?}}
                 :responses  {200 {:body {:total int?}}}
                 :handler    (fn [{{{:keys [x y]} :query} :parameters}]
                               {:status 200
                                :body   {:total (+ x y)}})}
          :post {:summary    "plus with spec body parameters"
                 :parameters {:body {:x int?, :y int?}}
                 :responses  {200 {:body {:total int?}}}
                 :handler    (fn [{{{:keys [x y]} :body} :parameters}]
                               {:status 200
                                :body   {:total (+ x y)}})}}]]]

      {:data {:coercion   reitit.coercion.spec/coercion
              :muuntaja   m/instance
              :middleware [parameters/parameters-middleware
                           muuntaja/format-negotiate-middleware
                           muuntaja/format-response-middleware
                           exception/exception-middleware
                           muuntaja/format-request-middleware
                           coercion/coerce-response-middleware
                           coercion/coerce-request-middleware
                           multipart/multipart-middleware]}})
    (ring/routes
      (swagger-ui/create-swagger-ui-handler {:path "/"})
      (ring/create-default-handler))))