(ns app.stories.button-stories
  (:require [app.components.button :as button]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Save Button Component"
                     :component button/save
                     :args      {:visible? true}}))

(defn click-fn [_e]
  (println "clicked"))

(defn ^:export save-button [args]
  (let [params    (-> args helper/->params)
        visible?   (:visible? params)]
    (reagent/as-element
     [button/save visible? click-fn])))
