(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [org.clojure/core.async "0.4.490"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [org.webjars/bootstrap "3.2.0"]
                 [cljs-http "0.1.46"]
                 [compojure "1.6.1"]
                 [liberator "0.15.3"]
                 [fogus/ring-edn "0.3.0"]
                 [reagent "0.8.1"]
                 [figwheel "0.5.18"]
                 [cider/piggieback "0.4.1"]
                 [weasel "0.7.0" :exclusions [org.clojure/clojurescript]]
                 [environ "1.0.0"]]

  :plugins [[lein-ring "0.12.5"]
            [lein-cljsbuild "1.1.7"]
            [cider/cider-nrepl "0.21.1"]
            [lein-environ "1.0.0"]]

  :source-paths ["src"]

  :profiles {:dev {:repl-options {:init-ns {{ns-name}}.api
                                  :nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
                   :plugins [[lein-figwheel "0.5.18"]]
                   :figwheel {:http-server-root "public"}
                   :env {:is-dev true}}}

  :cljsbuild {
              :builds [{:id "{{ns-name}}"
                        :source-paths ["src-cljs"]
                        :figwheel true
                        :compiler {:output-to "resources/public/{{sanitized}}.js"
                                   :output-dir "resources/public/out"
                                   :optimizations :none
                                   :source-map true}}]}

  :ring {:handler {{ns-name}}.api/handler
         :nrepl {:start? true :port 4500}
         :port 8090}
  :global-vars {*print-length* 20})
