(ns app.stories.helper
  (:require [reagent.core :as reagent]))

(defn ->params [^js args]
  (js->clj args :keywordize-keys true))

(defn ->reactified [options path]
  (if (get-in options path)
    (update-in options path reagent/reactify-component)
    options))

(defn ->default [options]
  (-> options
      (->reactified [:component])
      (->reactified [:parameters :docs :page])
      clj->js))
