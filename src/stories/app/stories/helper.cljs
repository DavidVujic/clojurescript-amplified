(ns app.stories.helper
  (:require [clojure.walk :as walk]))

(defn ->params [^js args]
  (-> args
      js->clj
      walk/keywordize-keys))
