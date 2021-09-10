(ns app.amplified.events
  (:require [app.amplified.api.fetch :as fetch]
            [app.amplified.auth :as auth]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :app/teardown
 (fn [db _]
   (dissoc db [:app])))

(rf/reg-event-db
 :app/user-summary
 (fn [db [_ data]]
   (assoc-in db [:app :user :settings :summary] data)))

(rf/reg-event-db
 :app/user
 (fn [db [_ data]]
   (assoc-in db [:app :user] data)))

(rf/reg-event-db
 :app/user-settings
 (fn [db [_ data]]
   (assoc-in db [:app :user :settings] data)))

(rf/reg-fx
 :app/fetch-user-settings
 (fn [_]
   (fetch/settings! #(rf/dispatch [:app/user-settings %]))))

(rf/reg-event-fx
 :app/fetch-user-settings!
 (fn [_ _]
   {:app/fetch-user-settings nil}))

(rf/reg-fx
 :app/fetch-user
 (fn [_]
   (auth/user! (fn [data]
                 (rf/dispatch [:app/user data])
                 (rf/dispatch [:app/fetch-user-settings!])))))

(rf/reg-event-fx
 :app/fetch-user!
 (fn [_ _]
   {:app/fetch-user nil}))

(defn- on-auth [event]
  (case event
    :signIn  (rf/dispatch [:app/fetch-user!])
    :signOut (rf/dispatch [:app/teardown])
    nil))

(rf/reg-fx
 :app/listen-to-auth-events
 (fn [_]
   (auth/listen-to-auth-events on-auth)))

(rf/reg-event-fx
 :app/listen!
 (fn [_ _]
   {:app/listen-to-auth-events nil}))

(rf/reg-event-fx
 :app/init
 (fn [_ _]
   {:fx [[:dispatch-n (list [:app/listen!]
                            [:app/fetch-user!])]]}))
