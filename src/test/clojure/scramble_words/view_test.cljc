(ns scramble-words.view-test
  (:require [clojure.test :refer :all]
            [scramble-words.view :refer :all]))

(deftest content-page-test
  (testing "negative"
    (is (= [:body {:class "body"}
            [:h1 "Scramble exercise"] [:br]
            [:section
             [:form {:id "form" :method "POST" :name "form"}
              [:label {:for "str1"} "First string: "] [:input {:id "str1" :name "str1" :type "text"}] [:br]
              [:label {:for "str2"} "Second string: "] [:input {:id "str2" :name "str2" :type "text"}] [:br] [:br]
              [:button {:type "button" :onclick "scramble_words.index.scramble()"} "Scramble"]] [:br]
             [:div [:p {:id "message" :name "message"} [:strong ""]]]]]
           (content-page "")))))

(deftest not-found-page-test
  (testing "negative"
    (is (= [:body {:class "body"} [:h1 "Page NOT found"]]
           (not-found-page)))))
