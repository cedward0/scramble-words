(ns scramble-words.index-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [scramble-words.index :refer [api-scramble-url-path]]))

(deftest numbers-test
  (is (= 1 1)))

(deftest api-scramble-get-test
  (is (= {"result" :true}
         (cljs-http.client/get "http://localhost:3000/api/scramble?str1=aa&str2=aa"))))

(deftest api-scramble-url-path-test
  (testing "if the api path is consistent"
    (is (= "api/scramble" (api-scramble-url-path)))))
