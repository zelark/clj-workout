(ns clj-workout.week-01.day-01)


;; Intro to Strings
;;
;; Clojure strings are Java strings. This means that you can use any of the Java string
;; mehods on Clojure strings.
(= "HELLO WORLD" (.toUpperCase "hello world"))


;; Intro to Lists
;;
;; Lists can be constructed with either a function or a quoted form.
(= (list :a :b :c) '(:a :b :c))


;; Lists: conj
;;
;; When operating on a list, the conj function will return
;; a new list with one or more items "added" to the front.
(= '(1 2 3 4) (conj '(2 3 4) 1))

(= '(1 2 3 4) (conj '(3 4) 2 1))


;; Intro to Vectors
;;
;; Vectors can be constructed several ways. You can compare them with lists.
(= [:a :b :c]
   (list :a :b :c)
   (vec '(:a :b :c))
   (vector :a :b :c))


;; Vectors: conj
;;
;; When operating on a Vector, the conj function will return
;; a new vector with one or more items "added" to the end.
(= '(1 2 3 4) (conj [1 2 3] 4))

(= '(1 2 3 4) (conj [1 2] 3 4))


;; Intro to Sets
;;
;; Sets are collections of unique values.
(= #{:d :c :b :a} (set '(:a :a :b :c :c :c :c :d :d)))

(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

(= #{:a} (clojure.set/difference #{:a :b :c :lol} #{:b :c :d} #{:lol}))


;; Sets: conj
;;
;; When operating on a set, the conj function returns
;; a new set with one or more keys "added".
(= #{1 2 3 4} (conj #{1 4 3} 2))


;; Intro to Maps
;;
;; Maps store key-value pairs. Both maps and keywords
;; can be used as lookup functions. Commas can be used to make
;; maps more readable, but they are not required.
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))

(= 20 (:b {:a 10, :b 20, :c 30}))


;; Maps: conj
;;
;; When operating on a map, the conj function returns
;; a new map with one or more key-value pairs "added".
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

;; Intro to Sequences
;;
;; All Clojure collections support sequencing. You can operate
;; on sequences with functions like  rest, second, and last.
(= 3 (first '(3 2 1)))

(= 3 (second [2 3 4]))

(= 3 (last (list 1 2 3)))
