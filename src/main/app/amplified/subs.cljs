(ns app.amplified.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :app/user
 (fn [db]
   (get-in db [:app :user])))

(rf/reg-sub
 :app/username
 :<- [:app/user]
 (fn [{:keys [username]}]
   username))

(comment
  @(rf/subscribe [:app/user])

  @(rf/subscribe [:app/username])
)
