(defproject githubs3 "0.1.0-SNAPSHOT"
  :description "Sync github to S3"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.json "0.2.6"]
                 [uswitch/lambada "0.1.0"]]
  :profiles {:uberjar {:aot :all}}
  :uberjar-name "githubs3.jar")
