(ns clj-workout.week-01.day-04)


;; Penultimate Element
;;
;; Write a function which returns the second to last element from a sequence.
(defn second-to-last [coll]
  (let [pen-idx (- (count coll) 2)]
    (->> coll
         (drop pen-idx)
         first)))

(defn second-to-last [coll]
  (second (reverse coll)))

(= (second-to-last (list 1 2 3 4 5 )) 4)

(= (second-to-last ["a" "b" "c"]) "b")

(= (second-to-last [[1 2] [3 4]]) [1 2])


;; Sum It All Up
;;
;; Write a function which returns the sum of a sequence of numbers.
(defn sum [coll]
  (reduce + coll))

(= (sum [1 2 3]) 6)

(= (sum (list 0 -2 5 5)) 8)

(= (sum #{4 2 1}) 7)

(= (sum '(0 0 -1)) -1)

(= (sum '(1 10 3)) 14)


;; Find the odd numbers
;;
;; Write a function which returns only the odd numbers from a sequence.
(defn only-odds [coll]
  (filter odd? coll))

(= (only-odds #{1 2 3 4 5}) '(1 3 5))

(= (only-odds [4 2 1 6]) '(1))

(= (only-odds [2 2 4 6]) '())

(= (only-odds [1 1 1 3]) '(1 1 1 3))


;; Palindrome Detector
;; 
;; Write a function which returns true if the given sequence is a palindrome.
;; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
(defn palindrome? [coll]
  (if (> (count coll) 1)
    (let [fst (first coll)
          lst (last coll)]
      (if (= fst lst)
        (palindrome? (rest (butlast coll)))
        false))
    true))

(defn palindrome? [coll]
  (if (> (count coll) 1)
    (if (= (first coll) (last coll))
      (recur (rest (butlast coll)))
      false)
    true))

(defn palindrome? [s]
  (if (> (count s) 1)
    (and (= (first s) (last s))
         (recur (rest (butlast coll))))
    true))

(defn palindrome? [s]
  (= (seq s) (reverse s)))

(false? (palindrome? '(1 2 3 4 5)))

(true? (palindrome? "racecar"))

(true? (palindrome? [:foo :bar :foo]))

(true? (palindrome? '(1 1 3 3 1 1)))

(false? (palindrome? '(:a :b :c)))


;; Duplicate a Sequence
;;
;; Write a function which duplicates each element of a sequence.
(defn dup-seq [coll]
  (reduce #(conj %1 %2 %2) [] coll))

(= (dup-seq [1 2 3]) '(1 1 2 2 3 3))

(= (dup-seq [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))

(= (dup-seq [[1 2] [3 4]]) '([1 2][1 2][3 4][3 4]))

(= (dup-seq [[1 2] [3 4]]) '([1 2][1 2][3 4][3 4]))
