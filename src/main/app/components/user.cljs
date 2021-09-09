(ns app.components.user
  (:require [app.components.greetings :as greetings]
            [reagent-material-ui.components :refer [box]]))

(defn card [{:keys [name image]}]
  [box {:sx {:p             4
             :border        "1px solid #efefef"
             :border-radius 2
             :box-shadow    "2px 2px 2px grey"}}
   [greetings/welcome-with-avatar name image]])
