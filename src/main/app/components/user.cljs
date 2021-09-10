(ns app.components.user
  (:require [app.components.greetings :as greetings]
            [app.components.button :as button-component]
            [reagent-material-ui.components :refer [box stack text-field]]
            [reagent.core :as r]))

(def focused? (r/atom false))

(defn card [{:keys [name image summary]} {:keys [on-summary-change on-save]}]
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
                  ;:on-blur   #(reset! focused? false)
                  :on-focus  #(reset! focused? true)
                  :value     summary}]
     [button-component/save @focused? on-save]]]])
