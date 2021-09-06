(ns app.core
  (:require [app.views :as views]
            [reagent.dom :as rdom]))

(def root-element (-> js/document (.getElementById "root")))

(defn start []
  (rdom/render [views/panels] root-element))

(defn init []
  (-> js/console (.log "Initializing app"))
  (start))
