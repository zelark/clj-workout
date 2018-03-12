(ns clj-workout.week-03.day-03)


;; Reverse Interleave
;;
;; Write a function which reverses the interleave process into x number of
;; subsequences.
(defn rinterleave [coll n]
  (vals (group-by #(mod % n) coll)))

;; Norman's solution http://www.4clojure.com/user/norman
(defn rleave [items n]
  (apply map list (partition n items)))

(= (rinterleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

(= (rinterleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

(= (rinterleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))


;; Split by Type
;;
;; Write a function which takes a sequence consisting of items with different
;; types and splits them up into a set of homogeneous sub-sequences. The
;; internal order of each sub-sequence should be maintained, but the
;; sub-sequences themselves can be returned in any order (this is why set is
;; used in the test cases).
(defn split-by-type [coll]
  (vals (group-by type coll)))

(= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set (split-by-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})

