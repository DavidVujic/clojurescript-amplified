(ns app.auth
  (:require [reagent.core :as reagent]
            ["aws-amplify" :refer [Auth]]
            ["@aws-amplify/ui-react" :refer [withAuthenticator]]))

(defn- on-signed-out [_]
  (-> js/window .-location (.reload)))

(defn- on-failed-sign-out [e]
  (-> js/console (.error e)))

(defn sign-out []
  (-> Auth
      .signOut
      (.then on-signed-out)
      (.catch on-failed-sign-out)))

(defn with-auth [component]
  (-> component
      reagent/reactify-component
      withAuthenticator))
