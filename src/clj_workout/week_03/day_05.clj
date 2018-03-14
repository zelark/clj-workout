(ns clj-workout.week-03.day-05)


;; Anagram Finder
;;
;; Write a function which finds all the anagrams in a vector of words. A word
;; x is an anagram of word y if all the letters in x can be rearranged in a
;; different order to form y. Your function should return a set of sets, where
;; each sub-set is a group of words which are anagrams of each other. Each
;; sub-set should have at least two words. Words without any anagrams should
;; not be included in the result. 
(defn anagram [coll]
  (->> coll
       (group-by set)
       vals
       (filter #(> (count %) 1))
       (map set)
       set))

(= (anagram ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= (anagram ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})
   