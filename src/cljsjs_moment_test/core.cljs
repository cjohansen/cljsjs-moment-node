(ns cljsjs-moment-test.core
  (:require cljsjs.moment))

(defn hello []
  (js/moment "2018-01-02"))

(defn -main []
  (println "=>" (hello)))

(set! *main-cli-fn* -main)
