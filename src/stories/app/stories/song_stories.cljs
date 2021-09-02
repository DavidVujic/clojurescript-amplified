(ns app.stories.song-stories
  (:require [app.components.song :as song]
            [app.stories.helper :as helper]
            [reagent.core :as reagent]))

(def ^:export default
  (helper/->default {:title     "A Material-UI Song Component"
                     :component song/song-card}))

(defn ^:export song []
  (reagent/as-element
   [song/song-card]))
