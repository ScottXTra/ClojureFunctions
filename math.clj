

; Calculate circumference
(defn circ [radius]
    (* radius 2 Math/PI))

; pow() equivilant
(defn exp [x n]
  (reduce * (repeat n x)))

; Should be accurate from 0 -> PI
(defn taylorSin [radian]
   (format "%.3f" (- (+ (- (+ (- radian (/ (exp radian 3) 6)) (/ (exp radian 5) 120)) (/ (exp radian 7) 5040)) (/ (exp radian 9) 362880) )  (/ (exp radian 11) 39916800) )))

; Quadratic formula (Format: ax^2 + bx + c)
(defn quadRoots [a b c]
  (let [
        undersqrroot    (Math/sqrt (- (* b b) (* 4 a c)))
        negb            (- b)
        bottom          (/ 1 (* 2 a))
        ]
    [(* bottom (+ negb undersqrroot)) (* bottom (- negb undersqrroot))]))

; Calculate volume of a cube with a given side legth
(defn calcCubeVolume [sideLegth]
    (* sideLegth sideLegth sideLegth))

; Calculate area of a square with a given side legth
(defn calcSquareArea [sideLegth]
    (* sideLegth sideLegth))

; Calculate volume of a sphere with a given radius
(defn calcSphereVolume [radius]
    (* (/ 4 3) Math/PI (exp radius 3)))

; Convert meters to freedom units
(defn metersToFeet [meters]
    (* meters 3.28084))

; Calculate the intersections of lines in the y = mx + b format
(defn lineIntersect [m1 b1 m2 b2]
    (if (= m1 m2 ) "Lines are parallel" (let [
        m2-m1 (- m2 m1)
        b1-b2 (- b1 b2)
        devided (/ b1-b2 m2-m1)
        ] [devided])))

; Used to find delta between 0-360 angles
(defn angleDifference [a1 a2]
    (- 180 (Math/abs (- (Math/abs (- a1 a2)) 180))))
    
; Check if a number is prime
(defn isPrime? [n]
    (if (>= n 1)
    (empty? (filter #(= 0 (mod n %)) (range 2 n)))
    false))

; SUPPORT (USING DIVISION)
(defn test-prime [x]
  (loop [iter 5 top (Math/sqrt x)]
    (cond
      (> iter top) true
      (or (zero? (mod x iter))
          (zero? (mod x (+ 2 iter)))) false
      :else (recur (+ 6 iter) top))))

; SUPPORT (USING DIVISION)
(defn is-prime [x]
  (cond
    (<= x 3) (< 1 x)
    (or (zero? (mod x 2))
        (zero? (mod x 3))) false
    :else (test-prime x)))


; degToRad
(defn radians [degree]
    (* Math/PI (/ degree 180 )))
; radToDeg   
(defn degrees [degree]
    (* 180 (/ degree Math/PI)))

; find bearing between 2 earth coordinants
(defn bearing [lat lon lat2 lon2]
    (let [
        teta1 (radians lat)
        teta2 (radians lat2)
        delta1 (radians (- lat2 lat))                    
        delta2 (radians (- lon2 lon))
        y (* (Math/sin delta2) (Math/cos teta2))
        x (-(* (Math/cos teta1) (Math/sin teta2)) (* (Math/sin teta1) (Math/cos teta2) (Math/cos delta2)))
        ][(degrees (Math/atan2 y x))]))