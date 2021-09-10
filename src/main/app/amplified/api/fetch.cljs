(ns app.amplified.api.fetch
  (:require ["/graphql/queries" :refer [^js listUserSettings]]
            ["aws-amplify" :refer [API graphqlOperation]]))

;; TODO: a Real world example should have things like retries and error messages in the UI.
(defn- failed [e]
  (-> js/console (.error e)))

(defn- settings-data [^js data]
  (-> data
      (js->clj :keywordize-keys true)
      :data
      :listUserSettings
      :items
      first))

(defn settings! [success-fn]
  (-> API
      (.graphql (graphqlOperation listUserSettings))
      (.then #(-> % settings-data success-fn))
      (.catch failed)))
