(ns app.stories.message-stories
  (:require [app.components.message :as message]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Message Component"
                     :component message/editable
                     :args      {:message ""}
                     :argTypes  {:on-save   {:action "clicked on save!"}
                                 :on-change {:action "change"}}}))

(defn ^:export editable-message [args]
  (let [params    (-> args helper/->params)
        message   (:message params)
        on-change (:on-change params)
        on-save   (:on-save params)]
    (reagent/as-element
     [message/editable message on-change on-save])))
