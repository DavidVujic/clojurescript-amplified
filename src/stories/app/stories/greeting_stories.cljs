(ns app.stories.greeting-stories
  (:require [app.components.greetings :as greetings]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Greetings Component"
                     :component greetings/welcome
                     :args      {:message "Storybook"}}))

(defn ^:export welcome [args]
  (reagent/as-element
   [greetings/welcome (-> args helper/->params :message)]))
