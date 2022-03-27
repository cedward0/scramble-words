(ns scramble-words.index
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [clojure.browser.dom :as dom])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn- update-message
  "Updates the message element in page with the given text"
  [message]
  (set! (.-innerHTML (dom/get-element "message")) message))

(defn api-scramble-url-path
  "Computes the API path"
  []
  "api/scramble")

(defn- api-scramble-call-message
  "Connects to API scramble to get the result of scrambling and displaying it"
  [str1 str2]
  (go (let [response (<! (http/post (api-scramble-url-path) {:form-params {:str1 str1 :str2 str2}}))
            body (:body response)
            result (:result body)
            text (str "Scrambling result for [" str1 "] and [" str2 "] is: " result
                      (if (not result) (str "<br/>" (:message body))))]
        (update-message text)
        (if (not result)
          (js/alert (:message body))))))


(defn scramble
  "Calls API scramble and show the result"
  []
  (api-scramble-call-message (dom/get-value (dom/get-element "str1"))
                             (dom/get-value (dom/get-element "str2"))))


(update-message "Hello!")
