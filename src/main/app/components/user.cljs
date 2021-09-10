(ns app.components.user
  (:require [app.components.greetings :as greetings]
            [reagent-material-ui.components :refer [box button stack text-field]]
            [reagent.core :as r]))

(def focused? (r/atom false))

(defn card [{:keys [name image summary]} {:keys [on-summary-change]}]
  [box {:sx {:p             4
             :border        "1px solid #efefef"
             :border-radius 2
             :box-shadow    "2px 2px 2px grey"}}
   [stack {:direction   "row"
           :spacing     3
           :align-items "flex-start"}
    [greetings/welcome-with-avatar name image]
    [stack {:direction   "column"
            :align-items "flex-end"
            :spacing     2}
     [text-field {:multiline true
                  :max-rows  6
                  :rows      3
                  :label     "About"
                  :on-change on-summary-change
                  :on-blur   #(reset! focused? false)
                  :on-focus  #(reset! focused? true)
                  :value     summary}]
     [button (cond-> {:variant "outlined"
                      :size    "small"}
               (not @focused?) (assoc :style {:visibility "hidden"
                                              :opacity    0
                                              :transition "visibility 0.3s, opacity 0.3s linear"}))
      "done"]]]])
