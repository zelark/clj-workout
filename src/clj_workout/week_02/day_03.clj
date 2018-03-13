(ns clj-workout.week-02.day-03)


;; Simple closures
;;
;; Lexical scope and first-class functions are two of the most
;; basic building blocks of a functional language like Clojure.
;; When you combine the two together, you get something very
;; powerful colled lexical closures. With these, you can exercise
;; a great deal of control over the lifetime of your local bindings,
;; saving their values for use later, long after the code you're
;; running now has finished. 
;;
;; It can be hard to follow in the abstract, so let's build
;; a simple closure. Given a positive integer n, ruturn
;; a function f(x) which computes x raised to the power n (x^n).
;; Observe that effect of this is to preserve the value of n for
;; use outside the scope in which it is defined.
(defn pow-n [n]
  (fn [x] (apply * (repeat n x))))

(= 256 ((pow-n 2) 16) ((pow-n 8) 2))

(= [1 8 27 64] (map (pow-n 3) [1 2 3 4]))

(= [1 2 4 8 16] (map #((pow-n %) 2) [0 1 2 3 4]))


;; Cartesian Product
;; 
;; Write a function which calculates the Cartesian product
;; of two sets.
(defn cart-product [xs ys]
  (set (for [x xs y ys] [x y])))

(= (cart-product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= (cart-product #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (cart-product (into #{} (range 10))
                            (into #{} (range 30)))))