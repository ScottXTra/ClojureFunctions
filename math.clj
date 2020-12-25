

(defn circ [radius]
    (* radius 2 3.14159))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn taylorSin [radian]
    (+(-radian(/(exp radian 3)6))(/(exp radian 5) 120)))  
