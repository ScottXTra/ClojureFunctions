

; Counts the number of words in a sentnece
(require '[clojure.string :as str])
(defn countWordsInSentence [sentence]
    (count (str/split sentence #"\s+")))

; returns a new list that is the input sequence with 1 added to every element
(defn tripleEveryElement [sequence]
     (map inc sequence))

