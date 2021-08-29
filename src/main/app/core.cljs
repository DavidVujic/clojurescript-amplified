(ns app.core
  (:require [reagent.dom :as rdom]))

(defn app []
  [:div "Hello World"])

(defn ^:export main []
  (rdom/render [app] (-> js/document (.getElementById "root"))))
