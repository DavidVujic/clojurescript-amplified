(ns app.components.message
  (:require [app.components.button :as button-component]
            [reagent-mui.components :refer [stack text-field]]
            [reagent.core :as r]))

(def focused? (r/atom false))

(defn editable [summary on-summary-change on-save]
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
   [button-component/save @focused? on-save]])
