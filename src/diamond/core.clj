(ns diamond.core
  (:require [clojure.string :as s])
  (:gen-class))

(defn diamond-chars [c]
  (map #(char %)
       (range (int \A) (+ 1 (int c)))))

(defn line [c]
  (apply str
     (let [r (diamond-chars c)]
       (concat (reverse (rest r)) r))))

(defn vertical [c]
  (let [cs (diamond-chars c)]
      (concat cs (rest (reverse cs)))))

(defn diamond-line [c cs]
  (apply str (map #(if (= c %) % \_) cs)))

(defn get-diamond [c]
  (let [l (line c)]
    (reduce (fn [ls cr]
              (conj ls (diamond-line cr l)))
            []
            (vertical c))))

(def alphabet (diamond-chars \Z))

(defn -main
  ([] (-main (rand-nth alphabet)))
  ([c]
   (let [car (first (s/upper-case c))]
    (if (some #{car} alphabet)
      (println (s/join "\n" (get-diamond car)))
      (-main)))))
