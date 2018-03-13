(ns clj-workout.week-03.day-04)


;; Prime Numbers
;;
;; Write a function which returns the first x number of prime numbers.
(defn prime? [n]
  (or (= n 2)
      (= n 3)
      (and (> n 1)
           (odd? n)
           (not-any? #(zero? (mod n %))
                     (range 3 (inc (Math/sqrt n)) 2)))))

(defn primes [x]
  (->> (range)
       (filter prime?)
       (take x)))

(primes 100)

(= (primes 2) [2 3])

(= (primes 5) [2 3 5 7 11])

(= (last (primes 100)) 541)
