(ns clj-workout.week-01.day05)


;; Compress a Sequence
;;
;; Write a function which removes consecutive duplicates from a sequence.
(defn del-cons-dups [coll]
  (reduce #(if (= (last %1) %2) %1 (conj %1 %2)) [] coll))

(defn del-cons-dups [coll]
  (->> coll
       (partition-by identity)
       (map distinct)
       (apply concat)))

(= (apply str (del-cons-dups "Leeeeeerrroyyy")) "Leroy")

(= (del-cons-dups [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))

(= (del-cons-dups [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))


;; Pack a Sequence
;;
;; Write a function which packs consecutive duplicates into sub-lists.
(defn pack-cons-dups [coll]
  (partition-by identity coll))

(= (pack-cons-dups [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))

(= (pack-cons-dups [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))

(= (pack-cons-dups [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))


;; Drop Every Nth Item
;; Write a function which drops every Nth item from a sequence.
(defn drop-nth [coll n]
  (let [len (count coll)]
    (reduce (fn [acc idx]
              (if (not= (mod idx n) 0)
                (conj acc (nth coll (dec idx)))
                acc))
            []
            (range 1 (inc len)))))

(= (drop-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])

(= (drop-nth [:a :b :c :d :e :f] 2) [:a :c :e])

(= (drop-nth [1 2 3 4 5 6] 4) [1 2 3 5 6])


;; Intro to Iterate
;;
;; The iterate function can be used to produce an infnite lazy sequence.
(= [1 4 7 10 13] (take 5 (iterate #(+ 3 %) 1)))


;; Replicate a Sequence
;;
;; Write a function which replicates each element of a sequence
;; a variable number of times.
(defn rep-n-times [coll n]
  (apply concat (map #(repeat n %) coll)))

(= (rep-n-times [1 2 3] 2) '(1 1 2 2 3 3))

(= (rep-n-times [:a :b] 4) '(:a :a :a :a :b :b :b :b))

(= (rep-n-times [4 5 6] 1) '(4 5 6))

(= (rep-n-times [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))

(= (rep-n-times [4 4 3 3] 2) [4 4 4 4 3 3 3 3])
