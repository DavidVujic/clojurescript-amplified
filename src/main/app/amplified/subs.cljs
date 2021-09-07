(ns app.amplified.subs
  (:require [re-frame.core :as r]))

(r/reg-sub
 :app/user
 (fn [db]
   (get-in db [:app :user])))

(r/reg-sub
 :app/username
 :<- [:app/user]
 (fn [{:keys [username]}]
   username))

(comment
  @(r/subscribe [:app/user])

  @(r/subscribe [:app/username])
)
