(ns app.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [app.views :as views]
            [reagent.dom :as rdom]
            [app.auth :as auth]))

(defn app []
  [:> (-> views/panels
          auth/with-auth)])

(defn ^:export main []
  (-> Amplify (.configure aws-exports))
  (rdom/render [app] (-> js/document (.getElementById "root"))))
