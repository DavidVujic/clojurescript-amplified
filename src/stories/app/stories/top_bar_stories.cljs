(ns app.stories.top-bar-stories
  (:require [app.components.top :as top]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A top bar Component"
                     :component top/bar}))

(defn ^:export top-bar []
  (reagent/as-element
   [top/bar "Hello World" (fn [e] (-> js/console (.log "Clicked" (.-target e))))]))
