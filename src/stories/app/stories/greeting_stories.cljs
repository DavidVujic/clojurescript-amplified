(ns app.stories.greeting-stories
  (:require [app.core :as core]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (clj->js {:title     "The Greetings Component"
            :component (reagent/reactify-component core/greetings)
            :args      {:message "Storybook"}}))

(defn ^:export greetings [args]
  (reagent/as-element [core/greetings (-> args helper/->params :message)]))
