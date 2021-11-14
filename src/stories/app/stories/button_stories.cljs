(ns app.stories.button-stories
  (:require [app.components.button :as button]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]
            ["@storybook/addon-docs" :refer [Title
                                             Subtitle
                                             Description
                                             Primary]]))

(defn button-component-custom-docs []
  [:<>
   [:> Title]
   [:> Subtitle "This is a custom subtitle"]
   [:> Description {:type "INFO"} "Some details about the component"]
   [:> Primary]])

(def ^:export default
  (helper/->default {:title      "A Save Button Component"
                     :component  button/save
                     :args       {:visible? true}
                     :argTypes   {:on-click {:action "clicked!"}}
                     :parameters {:docs {:page button-component-custom-docs}}}))

(defn ^:export save-button [args]
  (let [params   (-> args helper/->params)
        visible? (:visible? params)
        on-click (:on-click params)]
    (reagent/as-element
     [button/save visible? on-click])))
