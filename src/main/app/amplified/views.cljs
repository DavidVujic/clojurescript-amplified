(ns app.amplified.views
  (:require [app.amplified.subs]
            [app.components.greetings :as greetings]
            [re-frame.core :as rf]))

(defn header []
  [:h2 "Clojure. Amplified."])

(defn panels []
  [:div {:style {:max-width "350px"}}
   [header]
   [greetings/welcome-with-avatar @(rf/subscribe [:app/username]) nil]])
