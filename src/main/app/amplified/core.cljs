(ns app.amplified.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [app.amplified.auth :as auth]
            [app.amplified.events]
            [app.amplified.subs]
            [app.amplified.views :as views]
            [re-frame.core :as rf]
            [reagent.dom :as rdom]))

(def root-element (-> js/document (.getElementById "root")))

(defn app []
  [:> (-> views/panels
          auth/with-auth)])

(defn start []
  (rdom/render [app] root-element))

(defn init []
  (-> js/console (.log "Initializing app with AWS Amplify"))
  (-> Amplify (.configure aws-exports))
  (rf/dispatch-sync [:app/init])
  (start))
