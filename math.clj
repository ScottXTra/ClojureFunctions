

; Calculate circumference
(defn circ [radius]
    (* radius 2 3.14159265359))

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
(defn calcCubeVolume [sideLegth]
    (* sideLegth sideLegth))

; Calculate volume of a sphere with a given radius
(defn calcSphereVolume [radius]
    (* (/ 4 3) 3.14159265359 (exp radius 3)))

; Convert meters to freedom units
(defn metersToFeet [meters]
    (* meters 3.28084))