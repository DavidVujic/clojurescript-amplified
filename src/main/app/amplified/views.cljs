(ns app.amplified.views
  (:require [app.amplified.auth :as auth]
            [app.amplified.subs]
            [app.components.user :as user]
            [app.components.top :as top]
            [re-frame.core :as rf]
            [reagent-material-ui.components :refer [stack]]))

(def subscribe (comp deref rf/subscribe))

(defn on-summary-change [^js e]
  (rf/dispatch [:app/user-summary (-> e .-target .-value)]))

(defn panels []
  [stack {:spacing 2}
   [top/bar {:message   "Clojure. Amplified."
             :logout-fn #(auth/sign-out)}]
   [user/card {:name    (subscribe [:app/user-name])
               :image   (subscribe [:app/user-image])
               :summary (subscribe [:app/user-summary])}
    {:on-summary-change on-summary-change}]])
