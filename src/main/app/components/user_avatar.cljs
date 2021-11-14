(ns app.components.user-avatar
  (:require [reagent-mui.components :refer [avatar stack]]))

(defn user-avatar [name image-path]
  [stack {:direction   "row"
          :spacing     2
          :align-items "center"}
   [avatar {:alt name
            :src image-path
            :sx  {:width  56
                  :height 56}}]
   [:strong name]])
