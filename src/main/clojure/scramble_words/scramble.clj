(ns scramble-words.scramble)

(defn- lowercase-letters?
  [str1 str2]
  (if-let [validation (reduce #(if %2 (if %1 (str %1 " and " %2) %2) %1)
                              (map #(if (not (re-matches #"^[a-z]+$" %))
                                      (str "[" % "] does not have only lower case letters"))
                                   [str1 str2]))]
    (throw (IllegalArgumentException. validation))
    true))

(defn- lowercase-letters?-safe
  [str1 str2]
  (try
    (lowercase-letters? str1 str2)
    (catch IllegalArgumentException e
      (do (println (.getMessage e)) false))))

(defn can-be-scrambled?-frequencies
  [str1 str2]
  (reduce #(and %1 %2)
          (map (fn [[str2-char str2-count]]
                 (>= (if-let [str2-char-count-str1 (get (frequencies (seq str1)) str2-char)] str2-char-count-str1 0) str2-count))
               (frequencies (seq str2)))))

(defn can-be-scrambled?-regex
  [str1 str2]
  (reduce #(and %1 %2)
          (map (fn [str1-char]
                 (let [str2-char-count-in-str2 (count (re-seq (re-pattern (str str1-char)) str2))
                       str1-char-count-in-str1 (count (re-seq (re-pattern (str str1-char)) str1))]
                   (>= str1-char-count-in-str1 str2-char-count-in-str2)))
               (seq str2))))

(defn- count-map-pair
  [str-seq]
  (fn [current]
    (vector current (reduce (fn [acc val] (if (= val current) (inc acc) acc)) 0 str-seq))))

(defn- count-map
  [str-seq]
  (into {} (map (count-map-pair str-seq) str-seq)))

(defn can-be-scrambled?-count-map
  [str1 str2]
  (reduce #(and %1 %2)
          (map (fn [[str2-char str2-count]]
                 (>= (if-let [str2-char-count-str1 (get (count-map (seq str1)) str2-char)] str2-char-count-str1 0) str2-count))
               (count-map (seq str2)))))

(defn scramble?
  "Returns true if a portion of str1 characters can be rearranged to match str2
  Returns false if a portion of str1 characters cannot be rearranged to match str2"
  [can-be-scrambled?-fn str1 str2]
  (if (and (not (empty? str1))
           (not (empty? str2))
           (lowercase-letters?-safe str1 str2)
           (can-be-scrambled?-fn str1 str2))
    true
    false))

(defn scramble?-with-message
  "Check if the inputs can be scrambled returning a map with result and a message if result is false"
  [str1 str2]
  (cond
    (and (empty? str1) (empty? str2))
    {:result false :message "Both strings are empty"}

    (empty? str1)
    {:result false :message "First string is empty"}

    (empty? str2)
    {:result false :message "Second string is empty"}

    (not (lowercase-letters?-safe str1 str2))
    (try (lowercase-letters? str1 str2)
         (catch IllegalArgumentException e {:result false :message (.getMessage e)}))

    ;(can-be-scrambled?-regex str1 str2)
    ;(can-be-scrambled?-count-map str1 str2)
    (can-be-scrambled?-frequencies str1 str2)
    {:result true}

    :else
    {:result false :message "The second string cannot be scrambled from the first string"}))
