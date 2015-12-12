(ns diamond.core-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [diamond.core :refer :all]))

(facts test-lines
  (fact "Lines"
    (line '(\A)) => "A"
    (line '(\A \B)) => "BAB"
    (line '(\A \B \C \D)) => "DCBABCD"))

(facts test-chars
  (fact "chars"
    (diamond-chars \A) => '(\A)
    (diamond-chars \B) => '(\A \B)
    (diamond-chars \D) => '(\A \B \C \D)))

(facts test-vertical
  (fact "vertical line"
    (vertical '(\A)) => '(\A)
    (vertical '(\A \B)) => '(\A \B \A)
    (vertical '(\A \B \C \D)) => '(\A \B \C \D \C \B \A)))

(facts test-diamond-line
  (fact "diamond line"
    (diamond-line \A "A") => "A"
    (diamond-line \B "BAB") => "B B"
    (diamond-line \D "DCBABCD") => "D     D"))

(facts test-diamond
  (fact "diamond"
    (get-diamond \A) => ["A"]
    (get-diamond \B) => [" A "
                         "B B"
                         " A "]
    (get-diamond \D) => ["   A   "
                         "  B B  "
                         " C   C "
                         "D     D"
                         " C   C "
                         "  B B  "
                         "   A   "]))
