(ns clj-workout.week-02.day-05)


;; Pascal's Triangle
;;
;; Pascal's triangle is a triangle of numbers compueted using
;; the following rules:
;;   - The first row is 1.
;;   - Each successive row is computed by adding together
;;     adjacent numbers in the row above, and adding a 1
;;     to the beginning and end of the row.
;;
;; Write a function which returns the nth row of Pascal's Triangle.
(defn nth-row [n]
  (if (= n 1)
    (list 1)
    (loop [row (list 1 1) n n]
      (if (= n 2)
        row
        (let [row' (reduce (fn [acc [a b]] (conj acc (+ a b)))
                            []
                            (partition 2 1 row))]
          (recur (cons 1 (conj row' 1)) (dec n)))))))

(defn nth-row [n]
  (loop [row [1] n n]
    (if (<= n 1)
      row
      (recur
        (concat [1] (map #(apply + %) (partition 2 1 row)) [1])
        (dec n)))))

;; From http://rosettacode.org/wiki/Pascal%27s_triangle#Clojure
(def pascal
  (iterate #(concat [1] (map + % (rest %)) [1]) '(1)))

(take 5 pascal)
(nth pascal 5)

(= (nth-row 1) [1])

(= (map nth-row (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])

(= (nth-row 11)
   [1 10 45 120 210 252 210 120 45 10 1])
