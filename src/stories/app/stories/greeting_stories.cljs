(ns app.stories.greeting-stories
  (:require [app.components.greetings :as greetings]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Greetings Component"
                     :component greetings/welcome
                     :args      {:message   "Storybook"
                                 :image-url "https://www.gravatar.com/avatar/49e43b90a0eb475326df9e8b6dfbabcd"}}))

(defn ^:export welcome [args]
  (reagent/as-element
   [greetings/welcome (-> args helper/->params :message)]))

(defn ^:export welcome-with-avatar [args]
  (let [params    (-> args helper/->params)
        message   (:message params)
        image-url (:image-url params)]
    (reagent/as-element
     [greetings/welcome-with-avatar message image-url])))
