(ns app.amplified.auth
  (:require ["@aws-amplify/ui-react" :refer [withAuthenticator]]
            ["aws-amplify" :refer [Auth Hub]]
            [clojure.walk :as walk]
            [reagent.core :as reagent]))

(defn- on-signed-out [_]
  (-> js/window .-location (.reload)))

(defn- on-failed-sign-out [e]
  (-> js/console (.error e)))

(defn sign-out []
  (-> Auth
      .signOut
      (.then on-signed-out)
      (.catch on-failed-sign-out)))

(defn ->attributes [^js data]
  (-> data
      .-attributes
      js->clj
      walk/keywordize-keys))

(defn- ->user-data [^js data]
  (assoc (->attributes data) :username (-> data .-username)))

(defn user! [success-fn fail-fn]
  (-> Auth
      .currentAuthenticatedUser
      (.then (fn [^js data] (-> data ->user-data success-fn)))
      (.catch fail-fn)))

(defn listen-to-auth-events [on-event]
  (-> Hub
      (.listen "auth" (fn [^js data]
                        (on-event (-> data .-payload .-event keyword))))))

(defn with-auth [component]
  (-> component
      reagent/reactify-component
      withAuthenticator))

(comment
 (sign-out)
)
