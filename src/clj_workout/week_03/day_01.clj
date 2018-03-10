(ns clj-workout.week-03.day-01)


;; To Tree, or not to Tree
;;
;; Write a predicate which checks whether or not a given sequence
;; represents a binary tree. Each node in the tree must have a 
;; value, a left child, and a right child.
(defn btree? [node]
  (if (nil? node)
    true
    (and (sequential? node)
         (= (count node) 3)
         (btree? (nth node 1))
         (btree? (nth node 2)))))

(defn btree? [node]
  (or (nil? node)
      (and (sequential? node)
           (= (count node) 3)
           (every? btree? (rest node)))))

(= (btree? '(:a (:b nil nil) nil))
   true)

(= (btree? '(:a (:b nil nil)))
   false)

(= (btree? [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)

(= (btree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)

(= (btree? [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)

(= (btree? [1 [2 [3 [4 false nil] nil] nil] nil])
   false)

(= (btree? '(:a nil ()))
   false)


;; Beauty is Symmetry
;;
;; Let us define a binary tree as "symmetric" if the left  half of
;; the tree is the mirror image of the right half of the tree.
;; Write a predicate to determine whether or not a given binary 
;; tree is symmetric. (see To Tree, or not to Tree for a reminder 
;; on the tree representation we're using).
(defn flip [node]
  (if (nil? node)
    nil
    (let [[value left right] node]
      [value (flip right) (flip left)])))

(defn symmetric-btree? [node]
  (and (btree? node)
       (= (nth node 1)
          (flip (nth node 2)))))

(defn flip [node]
  (when (sequential? node)
    (list (first node) (flip (nth node 2)) (flip (second node)))))

(defn symmetric-btree? [node]
  (and (btree? node)
       (= node (flip node))))

(= (symmetric-btree? '(:a (:b nil nil) (:b nil nil))) true)

(= (symmetric-btree? '(:a (:b nil nil) nil)) false)

(= (symmetric-btree? '(:a (:b nil nil) (:c nil nil))) false)

(= (symmetric-btree?
     [1
      [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
      [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)

(= (symmetric-btree?
     [1
      [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
      [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)

(= (symmetric-btree?
     [1
      [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
      [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)
