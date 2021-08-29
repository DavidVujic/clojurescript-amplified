(ns app.core
  (:require ["/aws-exports" :default ^js aws-exports]
            ["aws-amplify" :default Amplify]
            [reagent.dom :as rdom]))

(defn app []
  [:div "Hello World"])

(defn ^:export main []
  (-> Amplify (.configure aws-exports))
  (rdom/render [app] (-> js/document (.getElementById "root"))))
