;https://leetcode.com/problems/add-digits/
(defn digits [n]
  (->> n str (map (comp read-string str))))
(defn addDigits [num]
    (def dg (digits num))
    (if (> (count dg) 1) (addDigits (reduce + (conj dg))) dg )
)

;https://leetcode.com/problems/add-digits/
(defn addDigitsShort [num]
    (if (= num 0) 0 (+ 1 (mod (- num 1) 9))))



(def fibonacci(->> [0 1] 
    (iterate (fn [[a b]] [b (+ a b)]))(map first)))

(defn fib [n]
    (nth fibonacci n))

;; example of split-with
(defn splitter [seqi]
    (split-with #(< % 10) seqi)) 