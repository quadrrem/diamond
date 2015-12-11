(ns diamond.core-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [diamond.core :refer :all]))

(facts test-lines
  (fact "Lines"
    (line \A) => "A"
    (line \B) => "BAB"
    (line \D) => "DCBABCD"))

(facts test-chars
  (fact "chars"
    (diamond-chars \A) => (list \A)
    (diamond-chars \B) => (list \A \B)
    (diamond-chars \D) => (list \A \B \C \D)))

(facts test-vertical
  (fact "vertical line"
    (vertical \A) => (list \A)
    (vertical \B) => (list \A \B \A)
    (vertical \D) => (list \A \B \C \D \C \B \A)))

(facts test-diamond-line
  (fact "diamond line"
    (diamond-line \A "A") => "A"
    (diamond-line \B "BAB") => "B_B"
    (diamond-line \D "DCBABCD") => "D_____D"))

(facts test-diamond
  (fact "diamond"
    (get-diamond \A) => ["A"]
    (get-diamond \B) => ["_A_"
                         "B_B"
                         "_A_"]
    (get-diamond \D) => ["___A___"
                         "__B_B__"
                         "_C___C_"
                         "D_____D"
                         "_C___C_"
                         "__B_B__"
                         "___A___"]))
