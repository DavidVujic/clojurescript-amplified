(ns app.components.song
  (:require [reagent-material-ui.components :refer [box
                                                    card
                                                    card-content
                                                    card-media
                                                    icon-button
                                                    typography]]
            [reagent-material-ui.icons.skip-previous :refer [skip-previous]]
            [reagent-material-ui.icons.play-arrow :refer [play-arrow]]
            [reagent-material-ui.icons.skip-next :refer [skip-next]]
            [reagent-material-ui.icons.info :refer [info]]))

(defn song-card []
  [:div "hello world."])
