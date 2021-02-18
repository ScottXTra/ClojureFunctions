

; Counts the number of words in a sentnece
(require '[clojure.string :as str])
(defn countWordsInSentence [sentence]
    (count (str/split sentence #"\s+")))

; returns a new list that is the input sequence with 1 added to every element
(defn tripleEveryElement [sequence]
     (map inc sequence))

; returns a list of n random numbers between a and b
(defn getNRandomNumbersBetween [a b n]
    (take n (repeatedly #(int (+ a (rand (- b a))))))
)

(defn commaDelimit [seqOfStrings]
    (interpose "," seqOfStrings))


(def english-alphabet
  (seq "abcdefghijklmnopqrstuvwxyz"))
  
(defn rot13 [alphabet text]
  (let [cipher (->> (cycle alphabet)(drop 13)(take 26)(zipmap alphabet))]
    (apply str (replace cipher text))))



; apperently some interveiwers use this as a challange to check if you can code

(defn fizzbuzz []
(doseq [x (range 1 101)] 
      (def word (str (when (zero? (mod x 3)) "fizz") (when (zero? (mod x 5)) "buzz")))
      (println (if (empty? word) x word ))
))


  