(ns app.core-with-amplify
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [app.views :as views]
            [reagent.dom :as rdom]
            [app.auth :as auth]))

(def root-element (-> js/document (.getElementById "root")))

(defn app []
  [:> (-> views/panels
          auth/with-auth)])

(defn start []
  (rdom/render [app] root-element))

(defn init []
  (-> js/console (.log "Initializing app with AWS Amplify"))
  (-> Amplify (.configure aws-exports))
  (start))
