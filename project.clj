(defproject scramble-words "1.0.0-SNAPSHOT"
  :description "Clojure + ClojureScript exercise for scrambling strings"
  :url "https://github.com/cedward0/scramble-words"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.758" :exclusions [com.google.code.findbugs/jsr305 com.fasterxml.jackson.core/jackson-core commons-codec]]
                 [ring-server "0.4.0"]
                 [ring "1.6.1"]
                 [ring/ring-defaults "0.3.1"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.6.0"]
                 [hiccup "1.0.5"]
                 [cljs-http/cljs-http "0.1.46" :exclusions [commons-codec]]]

  :plugins [[lein-cljsbuild "1.1.8"]
            [lein-ring "0.12.1"]]

  :min-lein-version "2.7.3"

  :source-paths ["src/main/clojure"]
  :resource-paths ["target/cljsbuild"]

  :test-paths ["src/test/clojure"]

  :ring {:handler      scramble-words.handler/app
         :uberwar-name "scramble-words.war"}

  :uberjar-name "scramble-words.jar"

  :profiles {:dev     {:repl-options {:init-ns scramble-words.core
                                      :init    (scramble-words.core/-main)}
                       :dependencies [[ring/ring-mock "0.3.1"]
                                      [org.clojure/tools.nrepl "0.2.13"]]
                       :plugins      [[lein-figwheel "0.5.20"]]
                       :env          {:dev true}}
             :uberjar {:env         {:production true}
                       :aot         :all
                       :prep-tasks  ["compile" ["cljsbuild" "once"]]
                       :omit-source true}}

  :cljsbuild {:builds [{:id           "main"
                        :figwheel     true
                        :source-paths ["src/main/clojure"]
                        :compiler     {:main          "scramble-words.index"
                                       :output-to     "target/cljsbuild/public/js/main.js"
                                       :output-dir    "target/cljsbuild/public/js/out"
                                       :asset-path    "js/out"
                                       :optimizations :none
                                       :pretty-print  true}}]}

  :figwheel {:http-server-root "public"
             :server-port      3000
             :nrepl-port       30000
             :ring-handler     scramble-words.handler/app}

  :main scramble-words.core)
