# Scramble exercise

A web application to check if 2 strings can be scrambled one from the other.

The frontend is written in ClojureScript with two inputs for strings and a scramble button. When the button is fired it should call the scramble API and display a result.

The backend is written in Clojure exposing an API that accepts two strings in a request and applies a function that returns true if a portion of first string characters can be rearranged to match second string, otherwise returns false. 


## Usage

For starting the app on local environment use command `lein figwheel` and check for running application on http://localhost:3000/

Testing can be made running `lein test`, running api-scramble-test.http or running separate test files for clj, cljc and cljs.
