(ns githubs3.lambda
  (:require [uswitch.lambada.core :refer [deflambdafn]]
            [clojure.data.json :as json]
            [clojure.java.io :as io]))

(defn handle-event
  [event]
  (let [github-message-json (or (get-in event ["Records" 0 "Sns" "Message"]) "{}")
        message             (json/read-str github-message-json)
        git-ref             (message "ref")]
    (println "Push to ref: " (pr-str git-ref))
    {:status "ok"}))

(deflambdafn githubs3.lambda.SyncToS3
  [in out ctx]
  (let [event (json/read (io/reader in))
        res (handle-event event)]
    (json/write res (io/writer out))))
