(ns app.stories.helper
  (:require [clojure.walk :as walk]
            [reagent.core :as reagent]))

(defn ->params [^js args]
  (-> args
      js->clj
      walk/keywordize-keys))

(defn ->default [options]
  (clj->js (update options :component reagent/reactify-component)))
