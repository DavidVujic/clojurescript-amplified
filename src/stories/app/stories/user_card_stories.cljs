(ns app.stories.user-card-stories
  (:require [app.components.user :as user]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A User Card"
                     :component user/card
                     :args      {:user-name "David"
                                 :image-url "https://www.gravatar.com/avatar/49e43b90a0eb475326df9e8b6dfbabcd"}}))

(defn ^:export user-card [args]
  (let [params (-> args helper/->params)]
    (reagent/as-element
     [user/card {:name  (:user-name params)
                 :image (:image-url params)}])))
