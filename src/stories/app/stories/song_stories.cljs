(ns app.stories.song-stories
  (:require [app.components.song :refer [song-card]]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "Material-UI Song"
                     :component song-card}))

(defn ^:export song []
  (reagent/as-element [song-card]))
