(ns app.stories.avatar-stories
  (:require [app.components.user-avatar :as user-avatar]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "An Avatar Component"
                     :component user-avatar/user-avatar
                     :args      {:message   "David"
                                 :image-url "https://www.gravatar.com/avatar/49e43b90a0eb475326df9e8b6dfbabcd"}}))

(defn ^:export user-avatar [args]
  (let [params    (-> args helper/->params)
        message   (:message params)
        image-url (:image-url params)]
    (reagent/as-element
     [user-avatar/user-avatar message image-url])))
