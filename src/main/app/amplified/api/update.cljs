(ns app.amplified.api.update
  (:require ["/graphql/mutations" :refer [^js updateUserSettings]]
            ["aws-amplify" :refer [API]]))

;; TODO: a Real world example should have things like retries and error messages in the UI.
(defn- failed [e]
  (-> js/console (.error e)))

(defn- settings-js-obj [{:keys [id summary]}]
  (clj->js {:query     updateUserSettings
            :variables {:input {:id      id
                                :summary summary}}}))

(defn settings! [data success-fn]
  (-> API
      (.graphql (settings-js-obj data))
      (.then success-fn)
      (.catch failed)))
