(ns app.components.user
  (:require [app.components.user-avatar :as user-avatar]
            [app.components.message :as message]
            [reagent-mui.components :refer [box stack]]
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
    [user-avatar/user-avatar name image]
    [message/editable summary on-summary-change on-save]]])
