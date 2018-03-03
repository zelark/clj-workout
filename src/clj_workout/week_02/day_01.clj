(ns clj-workout.week-02.day-01)


;; Fibonacci Sequence
;;
;; Write a function which returns the first X Fibonacci numbers.
(defn fibs [n]
   (->> '(1 1)
        (iterate (fn [[a b :as res]] (conj res (+ a b))))
        (take (dec n))
        last
        reverse))

;; From https://rosettacode.org/wiki/Fibonacci_sequence#Clojure
(defn fibs [n]
  (take n
    (map first         ; throw away the "metadata" (see below) to view just the fib numbers
      (iterate         ; create an infinite sequence of [prev, curr] pairs
        (fn [[a b]]    ; to produce the next pair, call this function on the current pair
          [b (+ a b)]) ; new prev is old curr, new curr is sum of both previous numbers
        [1 1]))))      ; recursive base case: prev 1, curr 1

(= (fibs 3) '(1 1 2))

(= (fibs 6) '(1 1 2 3 5 8))

(= (fibs 8) '(1 1 2 3 5 8 13 21))


;; Get the Caps
;;
;; Write a function which takes a string and returns
;; a new string containing only the capital letters.
(defn only-caps [s]
  (->> s
       (filter #(Character/isUpperCase %))
       (apply str)))

(= (only-caps "HeLlO, WoRlD!") "HLOWRD")

(empty? (only-caps "nothing"))

(= (only-caps "$#A(*&987Zf") "AZ")


;; Intro to some
;;
;; The some function takese a predicate function and a collection.
;; It returns the first logical true value of (predicate x)
;; where x is an item in the collection.
(= 6 (some #{2 7 6} [5 6 7 8]))

(= 6 (some #(when (even? %) %) [5 6 7 8]))


;; Factorial Fun
;;
;; Write a function which calculates factorials.
(defn factorial [n]
  (loop [n n
         acc 1]
    (if (< n 2)
      acc
      (recur (dec n) (* acc n)))))

;; From https://rosettacode.org/wiki/Factorial#Clojure
(defn factorial [x]
  (apply * (range 2 (inc x))))

(= (factorial 1) 1)

(= (factorial 3) 6)

(= (factorial 5) 120)

(= (factorial 8) 40320)


;; Intro to Destructuring
;;
;; Let bindings and function parameter lists support destructuring.
(= [2 4] (let [[a b c d e f g] (range)] [c e]))
