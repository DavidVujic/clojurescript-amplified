(ns app.amplified.events
  (:require [app.amplified.auth :as auth]
            [re-frame.core :as r]))

(defn- failed [e]
  (-> js/console (.error e)))

(r/reg-event-db
 :app/teardown
 (fn [db _]
   (dissoc db [:app])))

(r/reg-event-db
 :app/user
 (fn [db [_ data]]
   (assoc-in db [:app :user] data)))

(r/reg-fx
 :app/fetch-user
 (fn [_]
   (auth/user! #(r/dispatch [:app/user %]) failed)))

(r/reg-event-fx
 :app/user!
 (fn [_ _]
   {:app/fetch-user nil}))

(defn- on-auth [event]
  (case event
    :signIn  (r/dispatch [:app/user!])
    :signOut (r/dispatch [:app/teardown])
    nil))

(r/reg-fx
 :app/listen-to-auth-events
 (fn [_]
   (auth/listen-to-auth-events on-auth)))

(r/reg-event-fx
 :app/listen!
 (fn [_ _]
   {:app/listen-to-auth-events nil}))

(r/reg-event-fx
 :app/init
 (fn [_ _]
   {:fx [[:dispatch-n (list [:app/listen!]
                            [:app/user!])]]}))
