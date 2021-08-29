(ns app.events
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-event-fx
 :app/init
 (fn [_ _]
   {:dispatch [:app/init-hub]}))
