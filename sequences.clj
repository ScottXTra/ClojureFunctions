

; Calculate circumference
(defn circ [radius]
    (* radius 2 Math/PI))

(require '[clojure.string :as str])
(defn countWordsInSentence [sentence]
    (count (str/split sentence #"\s+")))