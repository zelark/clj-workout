(ns clj-workout.week-02.day-02)


;; Advanced Destructuring
;;
;; Here is an example of some more sophisticated destructuring.
(= [1 2 [3 4 5] [1 2 3 4 5]]
   (let [[a b & c :as d] [1 2 3 4 5]]
     [a b c d]))


;; A Half-Truth
;; 
;; Write a function which takes a variable number of booleans.
;; Your function should return true if some of the parameters are true,
;; but not all of the parameters are true. Otherwise your function
;; should return false.
(defn half-true? [& xs]
  (true? (and (some false? xs) (some true? xs))))

(= false (half-true? false false))

(= true (half-true? true false))

(= false (half-true? true))

(= true (half-true? false true false))

(= false (half-true? true true true))

(= true (half-true? true true true false))


;; Greatest Common Divisor
;;
;; Given two integers, write a function which returns
;; the greatest common divisor.
(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(= (gcd 2 4) 2)

(= (gcd 10 5) 5)

(= (gcd 5 7) 1)

(= (gcd 858 1023) 33)
