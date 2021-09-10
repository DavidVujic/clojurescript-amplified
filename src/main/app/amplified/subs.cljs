(ns app.amplified.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :app/user
 (fn [db]
   (get-in db [:app :user])))

(rf/reg-sub
 :app/user-name
 :<- [:app/user]
 (fn [{:keys [username]}]
   username))

(rf/reg-sub
 :app/user-settings
 :<- [:app/user]
 (fn [{:keys [settings]}]
   settings))

(rf/reg-sub
 :app/user-summary
 :<- [:app/user-settings]
 (fn [{:keys [summary]}]
   summary))

(rf/reg-sub
 :app/user-image
 :<- [:app/user]
 (fn [{:keys [image]}]
   image))

(rf/reg-sub
 :app/ready?
 :<- [:app/user]
 (fn [user]
   (boolean (get user :settings false))))

(comment
  @(rf/subscribe [:app/user])
  @(rf/subscribe [:app/ready?])
)
