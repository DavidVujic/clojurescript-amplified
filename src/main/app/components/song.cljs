(ns app.components.song
  (:require [reagent-material-ui.components :refer [box
                                                    card
                                                    card-content
                                                    card-media
                                                    icon-button
                                                    typography]]
            [reagent-material-ui.icons.play-arrow :refer [play-arrow]]
            [reagent-material-ui.icons.skip-next :refer [skip-next]]
            [reagent-material-ui.icons.skip-previous :refer [skip-previous]]))

(defn song-card []
  [card {:sx {:display "flex"}}
   [box {:sx {:display "flex" :flex-direction "column"}}
    [card-content {:sx {:flex "1 0 auto"}}
     [typography {:component "div" :variant "h5"} "Live from Space"]
     [typography {:component "div" :variant "subtitle1" :color "text.secondary"} "Mac Miller"]]

    [box {:sx {:display "flex" :align-items "center" :pl 1 :pb 1}}
     [icon-button {:aria-label "previous"} [skip-previous]]
     [icon-button {:aria-label "play/pause"} [play-arrow]]
     [icon-button {:aria-label "next"} [skip-next]]]

    [card-media {:component "img"
                 :sx        {:width 151}
                 :image     "https://next.material-ui.com/static/images/cards/live-from-space.jpg"
                 :alt       "Live from space album cover"}]]])
