(ns clj-workout.week-03.day-02)


;; Flipping out
;;
;; Write a higher-order function which flips the order of the arguments
;; of an input function.
(defn flip [f]
  (fn [a b] (f b a)))

(= 3 ((flip nth) 2 [1 2 3 4 5]))

(= true ((flip >) 7 8))

(= 4 ((flip quot) 2 8))

(= [1 2 3] ((flip take) [1 2 3 4 5] 3))


;; Rotate a sequence
;;
;; Write a function which can rotate a sequence in either direction
(defn rotate [direction coll]
  (let [len (count coll)
        dir (rem direction len)
        n (if (neg? dir) (+ len dir) dir)]
    (concat (drop n coll) (take n coll))))

(defn rotate [n coll]
  (let [n (mod n (count coll))]
    (concat (drop n coll) (take n coll))))

(= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2))

(= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3))

(= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1))

(= (rotate 1 '(:a :b :c)) '(:b :c :a))

(= (rotate -4 '(:a :b :c)) '(:c :a :b))
