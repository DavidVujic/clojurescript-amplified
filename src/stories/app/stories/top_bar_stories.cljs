(ns app.stories.top-bar-stories
  (:require [app.components.top :as top]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Top Bar Component"
                     :component top/bar}))

(defn logout-fn [^js e]
  (-> js/console (.log "Clicked" (.-target e))))

(defn ^:export top-bar []
  (reagent/as-element
   [top/bar {:message   "Hello World"
             :logout-fn logout-fn}]))
