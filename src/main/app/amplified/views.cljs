(ns app.amplified.views
  (:require [app.components.greetings :as greetings]
            [app.components.song :as song]
            [re-frame.core :as rf]))

(defn header []
  [:h2 "Clojure. Amplified."])

(defn panels []
  [:div {:style {:max-width "350px"}}
   [header]
   [greetings/welcome @(rf/subscribe [:app/username])]
   [song/song-card]])
