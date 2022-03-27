(ns scramble-words.handler
  (:require [scramble-words.scramble :as scramble]
            [scramble-words.view :as view]
            [compojure.core :refer [GET POST defroutes]]
            [compojure.route :refer [not-found]]
            [hiccup.page :refer [include-js html5]]
            [ring.util.response :as response]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]))

(defroutes routes
           (GET "/" []
             (html5
               (conj (view/content-page "ClojureScript is not loaded")
                     (include-js "/js/main.js"))))
           (POST "/api/scramble" [str1 str2]
             (response/content-type
               (do (println (str "Calling API scramble? with [" str1 "] and [" str2 "]"))
                   (response/response (scramble/scramble?-with-message str1 str2)))
               "application/json"))
           (GET "/api/scramble" [str1 str2]
             (response/content-type
               (do (println (str "Calling API scramble? with [" str1 "] and [" str2 "]"))
                   (response/response (scramble/scramble?-with-message str1 str2)))
               "application/json"))
           (not-found
             (html5
               (view/not-found-page))))

(def app (-> #'routes
             (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))
             wrap-json-response
             wrap-json-body
             wrap-reload))
