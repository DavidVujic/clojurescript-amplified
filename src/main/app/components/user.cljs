(ns app.components.user
  (:require [app.components.greetings :as greetings]
            [reagent-material-ui.components :refer [box stack text-field]]))

(defn card [{:keys [name image summary]} {:keys [on-about-change]}]
  [box {:sx {:p             4
             :border        "1px solid #efefef"
             :border-radius 2
             :box-shadow    "2px 2px 2px grey"}}
   [stack {:direction "row"
           :spacing   3}
    [greetings/welcome-with-avatar name image]
    [text-field {:multiline true
                 :max-rows  6
                 :rows      3
                 :label     "About"
                 :on-change on-about-change
                 :value     summary}]]])
