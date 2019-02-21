(ns cljsjs-moment-test.core-test
  (:require [cljs.test :refer [deftest is]]
            [cljsjs-moment-test.core :as sut]))

(deftest hello-test
  (is (= "ALLO" (sut/hello))))
