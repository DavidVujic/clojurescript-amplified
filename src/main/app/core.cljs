(ns app.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [reagent.dom :as rdom]))

(defn header []
  [:h2 "Clojure. Amplified."])

(defn greetings [name]
  [:p "Hello " [:strong name]])

(defn app []
  [:<>
   [header]
   [greetings "ClojureScript developer"]])

(defn ^:export main []
  (-> Amplify (.configure aws-exports))
  (rdom/render [app] (-> js/document (.getElementById "root"))))
