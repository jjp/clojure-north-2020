# Clojure North 2020: Building Marvelous and Heroic Systems from the Ground Up

Clojure is a fantastically powerful, yet simple language. Despite this assertion,
it is not uncommon for those new to the language to have a hard time grasping
how to build complete applications from the basic building blocks of Clojure.

This workshop will bridge the gap from the basics of data literals all the way 
to building a complete, stateful web backend application. Participants will 
learn the following key takeaways:

 * Clojure is a data-centric language that frees developers to think about their
problems simply and clearly.
 * The core functions of Clojure can be thought of as a powerful data DSL that 
 is appropriate for working and thinking in any domain.
 * Clojure code is often developed in a bottom-up, functional style.
 * Powerful libraries exist beyond Clojure core that are also built on 
data-driven and functional concepts.
 * Stateful applications can be developed and organized in a functional manner 
 by pushing state to the edges of their applications and isolating stateful 
components.

## The Project
For our project we are going to build a really fun and cool application using 
data about hundreds of superheroes. 

Specific activities we will do are:

 1. Model our domain as data.
 2. Parse existing data files into a usable format.
 3. Learn about and use a very powerful family of databases 
(including Datascript & Datahike).
 4. Build a stateful backend web application around our superhero database, 
including a simple Swagger UI.

By the end of the session, you should be able to easily adapt this application 
and lessons learned to your specific domains.

## Target Audience
This tutorial is aimed at the following audiences:
 
 * Beginning to intermediate Clojure developers who are still trying to figure
 out a good workflow to build complete Clojure applications.
 * Anyone interested in fact-oriented databases
 (Datascript, Datahike, Datomic, Crux).
 * People who like superheroes.

## Prerequisites
Prior to this workshop, you must:
 1. Have [Clojure](https://clojure.org/guides/getting_started) installed on your 
 computer.
 1. Have [Leiningen](https://leiningen.org/) installed on your computer.
 1. Install a Clojure IDE (I will be using 
 [IntelliJ IDEA](https://www.jetbrains.com/idea/) + 
 [Cursive](https://cursive-ide.com/)).
 1. Clone this project, located [here](https://github.com/markbastian/clojure-north-2020).
 1. Load the project into your IDE with a running REPL.

## Format
All namespaces are sorted, starting with ch01/x01 through ch04/x04. You can follow along with the tutorial or move ahead if anything seems too slow. All exercises have solutions in an accompanying namespace ending with _solutions. If, at any point, you feel like you are falling behind, that's ok. The whole project is documented so you can revisit it at any time and solutions are wired in at future points so that everything works.

You may also find the [Marginalia documentation](https://markbastian.github.io/clojure-north-2020/docs/uberdoc.html) useful.

## License

Copyright © 2020 Mark Bastian

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
