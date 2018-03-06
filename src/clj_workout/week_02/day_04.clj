(ns clj-workout.week-02.day-04
  (:require [clj-workout.week-02.day-02 :as w2.d2]
            [clojure.set :as clj.set]))


;; Symmetric Difference
;;
;; Write a function which returns the symmetric difference of two sets.
;; The symmetric difference is the set of items belonging to one but
;; not both of the two sets.
(defn diff [s1 s2]
  (reduce #(if (contains? s2 %2) %1 (conj %1 %2)) #{} s1))

(defn sym-diff [s1 s2]
  (set (concat (diff s1 s2)
               (diff s2 s1))))

(defn sym-diff [s1 s2]
  (clj.set/union (clj.set/difference s1 s2)
                 (clj.set/difference s2 s1)))

(= (sym-diff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(= (sym-diff #{:a :b :c} #{}) #{:a :b :c})

(= (sym-diff #{} #{4 5 6}) #{4 5 6})

(= (sym-diff #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})


;; Least Common Multiple
;;
;; Write a function which calculates the least common multiple.
;; Your function should accept a variable number of positive
;; integers or rations.
(defn lcm [a b]
  (let [gcd (w2.d2/gcd a b)
        prod (* a b)]
    (/ prod gcd)))

(defn lcm
  ([a] a)
  ([a b]
   (let [gcd (w2.d2/gcd a b)
         prod (* a b)]
     (/ prod gcd)))
  ([a b & rest]
   (reduce lcm a (conj rest b))))

(== (lcm 2 3) 6)

(== (lcm 5 3 7) 105)

(== (lcm 1/3 2/5) 2)

(== (lcm 3/4 1/6) 3/2)

(== (lcm 7 5/7 2 3/5) 210)
