(ns app.views
  (:require [app.components.song :as song]
            [app.components.greetings :as greetings]))

(defn header []
  [:h2 "Clojure. Amplified."])

(defn panels []
  [:div {:style {:max-width "350px"}}
   [header]
   [greetings/welcome "ClojureScript developer"]
   [song/song-card]])
