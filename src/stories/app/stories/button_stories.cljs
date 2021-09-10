(ns app.stories.button-stories
  (:require [app.components.button :as button]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Save Button Component"
                     :component button/save
                     :args      {:visible? true}
                     :argTypes {:on-click {:action "clicked!"}}}))

(defn ^:export save-button [args]
  (let [params   (-> args helper/->params)
        visible? (:visible? params)
        on-click (:on-click params)]
    (reagent/as-element
     [button/save visible? on-click])))
