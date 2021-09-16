(ns app.stories.helper
  (:require [reagent.core :as reagent]))

(defn ->params [^js args]
  (js->clj args :keywordize-keys true))

(defn ->default [options]
  (clj->js (update options :component reagent/reactify-component)))
