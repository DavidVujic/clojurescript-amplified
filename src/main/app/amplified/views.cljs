(ns app.amplified.views
  (:require [app.amplified.auth :as auth]
            [app.amplified.subs]
            [app.components.user :as user]
            [app.components.top :as top]
            [re-frame.core :as rf]
            [app.amplified.api.fetch :as fetch]
            [reagent-material-ui.components :refer [stack]]))

(def subscribe (comp deref rf/subscribe))

(defn on-summary-change [^js e]
  (rf/dispatch [:app/user-summary (-> e .-target .-value)]))

(defn on-save [^js e]
  (println "save"))

(defn panels []
  [stack {:spacing 2}
   [top/bar {:message   "Clojure. Amplified."
             :logout-fn #(auth/sign-out)}]

   (when (subscribe [:app/ready?])
     [user/card
      {:name    (subscribe [:app/user-name])
       :image   (subscribe [:app/user-image])
       :summary (subscribe [:app/user-summary])}
      {:on-summary-change on-summary-change
       :on-save           on-save}])])
