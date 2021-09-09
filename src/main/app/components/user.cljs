(ns app.components.user
  (:require [app.components.greetings :as greetings]
            [reagent-material-ui.components :refer [box]]))

(defn card [{:keys [name image]}]
  [box {:sx {:p 4 :border "1px dashed grey"}}
   [greetings/welcome-with-avatar name image]])
