(ns diamond.core
  (:require [clojure.string :as s])
  (:gen-class))

(defn diamond-chars [c]
  (map #(char %)
       (range (int \A) (+ 1 (int c)))))

(defn line [cs]
  (apply str
       (concat (reverse (rest cs)) cs)))

(defn vertical [cs]
  (concat cs (rest (reverse cs))))

(defn diamond-line [c cs]
  (apply str (map #(if (= c %) % " ") cs)))

(defn get-diamond [c]
  (let [cs (diamond-chars c)
        l (line cs)]
    (reduce (fn [ls cr]
              (conj ls (diamond-line cr l)))
            []
            (vertical cs))))

(def alphabet (diamond-chars \Z))

(defn -main
  ([] (-main (rand-nth alphabet)))
  ([c]
   (let [car (first (s/upper-case c))]
    (if (some #{car} alphabet)
      (println (s/join "\n" (get-diamond car)))
      (-main)))))
