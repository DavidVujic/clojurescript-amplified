(ns app.components.button
  (:require [reagent-material-ui.components :refer [button]]))

(defn- styling [visible?]
  {:transition "visibility 0.3s, opacity 0.3s linear"
   :visible    (if visible? "visible" "hidden")
   :opacity    (if visible? 1 0)})

(defn save [visible?]
  [button {:variant "outlined"
           :size    "small"
           :style   (styling visible?)}
   
   "save"])
