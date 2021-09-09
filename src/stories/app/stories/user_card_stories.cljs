(ns app.stories.user-card-stories
  (:require [app.components.user :as user]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A User Card"
                     :component user/card
                     :args      {:user-name "David"
                                 :image-url "https://www.gravatar.com/avatar/49e43b90a0eb475326df9e8b6dfbabcd"}}))

(def about (reagent/atom "This is a placeholder text"))

(defn on-change [^js e]
  (reset! about (-> e .-target .-value)))

(defn user-card-component
  "It is possible to handle state within a story, by using an atom.
   The user/card component is extracted to a separate function to
   be able to deref the atom"
  [{:keys [user-name image-url]}]
  [user/card
   {:name    user-name
    :image   image-url
    :summary @about}
   {:on-summary-change on-change}])

(defn ^:export user-card [args]
  (let [params (-> args helper/->params)]
    (reagent/as-element
     [user-card-component params])))
