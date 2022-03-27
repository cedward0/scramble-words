(ns scramble-words.core
  (:require [scramble-words.handler :as handler]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn -main [& _]
  (println "Starting Jetty on port 3000")
  (run-jetty handler/app {:port 3000 :join? false}))
