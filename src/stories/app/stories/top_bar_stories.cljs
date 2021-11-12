(ns app.stories.top-bar-stories
  (:require [app.components.top :as top]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Top Bar Component"
                     :component top/bar}))

(defn logout-fn [^js e]
  (-> js/console (.log "Clicked" (.-target e))))


;; A "Templating" example, as an alternative to the JavaScript bind syntax explained in the Storybook docs
(defn template [args]
  (reagent/as-element
   [top/bar (merge {:logout-fn logout-fn } args)]))

(defn ^:export top-bar-one []
  (template {:message "Hello World"}))

(defn ^:export top-bar-two []
  (template {:message "Hello Storybook"}))
