(ns app.amplified.views
  (:require [app.amplified.auth :as auth]
            [app.amplified.subs]
            [app.components.user :as user]
            [app.components.top :as top]
            [re-frame.core :as rf]
            [reagent-material-ui.components :refer [stack]]))

(defn panels []
  [stack {:spacing 2}
   [top/bar "Clojure. Amplified." #(auth/sign-out)]
   [user/card {:name  @(rf/subscribe [:app/username])
               :image nil}]])
