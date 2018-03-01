(ns clj-workout.week-01.day-02)


;; Sequences: rest
;;
;; The rest function will return all the items of a sequence except the first.
(= [20 30 40] (rest [10 20 30 40]))


;; Intro to Functions
(= 8 ((fn add-five [x] (+ x 5)) 3))

(= 8 ((fn [x] (+ x 5)) 3))

(= 8 (#(+ % 5) 3))

(= 8 ((partial + 5) 3))


;; Double Down
;;
;; Write a function which doubles a number.
(defn dd [x]
  (* x 2))

(= (dd 2) 4)

(= (dd 3) 6)	

(= (dd 11) 22)	

(= (dd 7) 14)


;; Hello World
;;
;; Write a function which returns a personalized greeting.
(defn greet [name]
  (str "Hello, " name "!"));

(= (greet "Dave") "Hello, Dave!")

(= (greet "Jenn") "Hello, Jenn!")

(= (greet "Rhea") "Hello, Rhea!")


;; Sequences: Maps
;;
;; The map function takes two arguments: a function (f) and a sequence (s).
;; Map returns a new sequence consisting of the result of applying f to each item of s.
;; Do not confuse the map function with the map data structure.
(= [6 7 8] (map #(+ % 5) '(1 2 3)))


;; Sequences: filter
;;
;; The filter function takes two arguments: a predicate function (f) and a sequence (s).
;; Filter returns a new sequence consisting of all the items of s for which (f item) 
;; returns true.
(= [6 7] (filter #(> % 5) '(3 4 5 6 7)))


;; Local bindings
;;
;; Clojure lets you give local names to values using the special let-form.
(= 7 (let [x 5] (+ 2 x)))

(= 7 (let [x 3, y 10] (- y x)))

(= 7 (let [x 21] (let [y 3] (/ x y))))


;; Let it Be
;;
;; Can you bind x, y, and z so that these are all true?
(= 10 (let [x 7, y 3] (+ x y)))

(= 4 (let [y 3, z 1] (+ y z)))

(= 1 (let [z 1] z))
