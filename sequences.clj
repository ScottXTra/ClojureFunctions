

; Counts the number of words in a sentnece
(require '[clojure.string :as str])
(defn countWordsInSentence [sentence]
    (count (str/split sentence #"\s+")))