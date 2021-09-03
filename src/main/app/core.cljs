(ns app.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [app.components.song :as song]
            [reagent.dom :as rdom]))

(defn header []
  [:h2 "Clojure. Amplified."])

(defn greetings [name]
  [:p "Hello " [:strong name]])

(defn app []
  [:div {:style {:max-width "350px"}}
   [header]
   [greetings "ClojureScript developer"]
   [song/song-card]])

(defn ^:export main []
  (-> Amplify (.configure aws-exports))
  (rdom/render [app] (-> js/document (.getElementById "root"))))
