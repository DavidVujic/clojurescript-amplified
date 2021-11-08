(ns app.components.greetings
  (:require [reagent-mui.components :refer [avatar stack]]))

(defn welcome [name]
  [:p "Hello " [:strong name]])

(defn welcome-with-avatar [name image-path]
  [stack {:direction   "row"
          :spacing     2
          :align-items "center"}
   [avatar {:alt name
            :src image-path
            :sx  {:width  56
                  :height 56}}]
   [:strong name]])
