(ns app.components.top
  (:require [reagent-material-ui.components :refer [app-bar box toolbar typography button]]))

(defn bar [{:keys [message logout-fn]}]
  [box {:sx {:flex-grow 1}}
   [app-bar {:position "static"
             :color    "transparent"}
    [toolbar
     [typography {:variant   "h6"
                  :component "div"
                  :sx        {:flex-grow 1}}
      message]
     [button {:color    "inherit"
              :on-click logout-fn} "Logout"]]]])
