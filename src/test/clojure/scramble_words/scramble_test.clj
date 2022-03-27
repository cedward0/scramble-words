(ns scramble-words.scramble-test
  (:require [clojure.test :refer :all]
            [scramble-words.scramble :refer :all]))

(deftest can-be-scrambled?-frequencies-test
  (testing "timing scramble frequencies function"
    (time (can-be-scrambled?-frequencies "a" "a"))
    (time (can-be-scrambled?-frequencies "xx" "xx"))
    (time (can-be-scrambled?-frequencies "zzz" "zzz"))
    (time (can-be-scrambled?-frequencies
            "qwerqwrtwetyerwytruyertuytuiyuoupyoiasdfadfgdsgdfhfhjghlgjhkhmnbcmbnvxvbnxzcvzbxcbxzcvzxcvzxcvzxcbxzczfdwra"
            "poiuytrewqlkjhgfdsamnbvcxzqazwsxedcrfvtgbyhnujmikolpmlpnkonjibhuvgycftxdrzseawqlikjihogiofgnghnmcbnvhdhsaef"))
    (time (can-be-scrambled?-frequencies
            (str "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
            (str "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww")))
    (time (can-be-scrambled?-frequencies
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")))))

(deftest can-be-scrambled?-regex-test
  (testing "timing scramble regex function"
    (time (can-be-scrambled?-regex "a" "a"))
    (time (can-be-scrambled?-regex "xx" "xx"))
    (time (can-be-scrambled?-regex "zzz" "zzz"))
    (time (can-be-scrambled?-regex
            "qwerqwrtwetyerwytruyertuytuiyuoupyoiasdfadfgdsgdfhfhjghlgjhkhmnbcmbnvxvbnxzcvzbxcbxzcvzxcvzxcvzxcbxzczfdwra"
            "poiuytrewqlkjhgfdsamnbvcxzqazwsxedcrfvtgbyhnujmikolpmlpnkonjibhuvgycftxdrzseawqlikjihogiofgnghnmcbnvhdhsaef"))
    (time (can-be-scrambled?-regex
            (str "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
            (str "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww")))
    (time (can-be-scrambled?-regex
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")))))

(deftest can-be-scrambled?-count-map-test
  (testing "timing scramble count-map function"
    (time (can-be-scrambled?-count-map "a" "a"))
    (time (can-be-scrambled?-count-map "xx" "xx"))
    (time (can-be-scrambled?-count-map "zzz" "zzz"))
    (time (can-be-scrambled?-count-map
            "qwerqwrtwetyerwytruyertuytuiyuoupyoiasdfadfgdsgdfhfhjghlgjhkhmnbcmbnvxvbnxzcvzbxcbxzcvzxcvzxcvzxcbxzczfdwra"
            "poiuytrewqlkjhgfdsamnbvcxzqazwsxedcrfvtgbyhnujmikolpmlpnkonjibhuvgycftxdrzseawqlikjihogiofgnghnmcbnvhdhsaef"))
    (time (can-be-scrambled?-count-map
            (str "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                 "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
            (str "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
                 "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww")))
    (time (can-be-scrambled?-count-map
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            (str "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
                 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")))))

(deftest scramble?-frequencies-test
  (testing "frequencies negative"
    (are [str1 str2] (false? (scramble? can-be-scrambled?-frequencies str1 str2))
                     "katas" "steak"
                     "" ""
                     "1" "q"
                     "a" "_"
                     "\\/" "vv"
                     "" "aaaaaaaaa"
                     "sfavdava" ""
                     "123123123" "2351523"
                     "ASDWCAsdasd" "PVLXV"
                     "aaaaa" "aaaaaaaaa"
                     "rekqodlw" "worlda"
                     " -213sda0/.A" "28s 0)3^=s;OKS"))
  (testing "frequencies positive"
    (are [str1 str2] (true? (scramble? can-be-scrambled?-frequencies str1 str2))
                     "rekqodlw" "world"
                     "abcdefghijklmnopqrstwxyz" "zyxwtsrqponmlkjihgfedcba"
                     "cedewaraaossoqqyt" "codewars"
                     "helloworld" "world"
                     "listen" "silent"
                     "ccccccccccfffffffffkkkkkkkklllllll" "cffkkkllll"
                     "cfccccfccffffffllkkkkffkkfkklllcccll" "cffkkkllll"
                     "cfcckkccfccffcffffllkkffkkfkklllccll" "cfkllllkkf"
                     "todayisthebestdayofmylife" "fomo"
                     "qwertyuiopasdfghjklzxcvbnm" "qwertyuiopasdfghjklzxcvbnm")))

(deftest scramble?-regex-test
  (testing "regex negative"
    (are [str1 str2] (false? (scramble? can-be-scrambled?-regex str1 str2))
                     "katas" "steak"
                     "" ""
                     "1" "q"
                     "a" "_"
                     "\\/" "vv"
                     "" "aaaaaaaaa"
                     "sfavdava" ""
                     "123123123" "2351523"
                     "ASDWCAsdasd" "PVLXV"
                     "aaaaa" "aaaaaaaaa"
                     "rekqodlw" "worlda"
                     " -213sda0/.A" "28s 0)3^=s;OKS"))
  (testing "regex positive"
    (are [str1 str2] (true? (scramble? can-be-scrambled?-regex str1 str2))
                     "rekqodlw" "world"
                     "abcdefghijklmnopqrstwxyz" "zyxwtsrqponmlkjihgfedcba"
                     "cedewaraaossoqqyt" "codewars"
                     "helloworld" "world"
                     "listen" "silent"
                     "ccccccccccfffffffffkkkkkkkklllllll" "cffkkkllll"
                     "cfccccfccffffffllkkkkffkkfkklllcccll" "cffkkkllll"
                     "cfcckkccfccffcffffllkkffkkfkklllccll" "cfkllllkkf"
                     "todayisthebestdayofmylife" "fomo"
                     "qwertyuiopasdfghjklzxcvbnm" "qwertyuiopasdfghjklzxcvbnm")))

(deftest scramble?-count-map-test
  (testing "count-map negative"
    (are [str1 str2] (false? (scramble? can-be-scrambled?-count-map str1 str2))
                     "katas" "steak"
                     "" ""
                     "1" "q"
                     "a" "_"
                     "\\/" "vv"
                     "" "aaaaaaaaa"
                     "sfavdava" ""
                     "123123123" "2351523"
                     "ASDWCAsdasd" "PVLXV"
                     "aaaaa" "aaaaaaaaa"
                     "rekqodlw" "worlda"
                     " -213sda0/.A" "28s 0)3^=s;OKS"))
  (testing "count-map positive"
    (are [str1 str2] (true? (scramble? can-be-scrambled?-count-map str1 str2))
                     "rekqodlw" "world"
                     "abcdefghijklmnopqrstwxyz" "zyxwtsrqponmlkjihgfedcba"
                     "cedewaraaossoqqyt" "codewars"
                     "helloworld" "world"
                     "listen" "silent"
                     "ccccccccccfffffffffkkkkkkkklllllll" "cffkkkllll"
                     "cfccccfccffffffllkkkkffkkfkklllcccll" "cffkkkllll"
                     "cfcckkccfccffcffffllkkffkkfkklllccll" "cfkllllkkf"
                     "todayisthebestdayofmylife" "fomo"
                     "qwertyuiopasdfghjklzxcvbnm" "qwertyuiopasdfghjklzxcvbnm")))

(deftest scramble?-with-message-test
  (testing "negative"
    (are [expected str1 str2]
      (= expected (scramble?-with-message str1 str2))
      {:message "The second string cannot be scrambled from the first string" :result false} "katas" "steak"
      {:message "Both strings are empty" :result false} "" ""
      {:message "[1] does not have only lower case letters" :result false} "1" "q"
      {:message "[_] does not have only lower case letters" :result false} "a" "_"
      {:message "[\\/] does not have only lower case letters" :result false} "\\/" "vv"
      {:message "[V] does not have only lower case letters" :result false} "w" "V"
      {:message "First string is empty" :result false} "" "aaaaaaaaa"
      {:message "Second string is empty" :result false} "sfavdava" ""
      {:message "[123123123] does not have only lower case letters and [2351523] does not have only lower case letters" :result false} "123123123" "2351523"
      {:message "[ASDWCAsdasd] does not have only lower case letters and [PVLXV] does not have only lower case letters" :result false} "ASDWCAsdasd" "PVLXV"
      {:message "The second string cannot be scrambled from the first string" :result false} "aaaaa" "aaaaaaaaa"
      {:message "[ -213sda0/.A] does not have only lower case letters and [28s 0)3^=s;OKS] does not have only lower case letters" :result false} " -213sda0/.A" "28s 0)3^=s;OKS"))
  (testing "positive"
    (are [expected str1 str2]
      (= expected (scramble?-with-message str1 str2))
      {:result true} "rekqodlw" "world"
      {:result true} "abcdefghijklmnopqrstwxyz" "zyxwtsrqponmlkjihgfedcba"
      {:result true} "cedewaraaossoqqyt" "codewars"
      {:result true} "helloworld" "world"
      {:result true} "listen" "silent"
      {:result true} "ccccccccccfffffffffkkkkkkkklllllll" "cffkkkllll"
      {:result true} "cfccccfccffffffllkkkkffkkfkklllcccll" "cffkkkllll"
      {:result true} "cfcckkccfccffcffffllkkffkkfkklllccll" "cfkllllkkf"
      {:result true} "todayisthebestdayofmylife" "fomo"
      {:result true} "qwertyuiopasdfghjklzxcvbnm" "qwertyuiopasdfghjklzxcvbnm")))
