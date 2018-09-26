(ns lenglish-clj.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as json]
            [lenglish-clj.database :as db]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/json" [] {:status 200 :headers {"Content-Type" "application/json"} :body "{name: \"zheng\", age: 26}"})
  (GET "/db" [] (str (nth (db/get-all-knowledge) 0)))
  (GET "/db-json" [] {:status 200 :headers {"Content-Type" "application/json"} :body (nth (db/get-all-knowledge) 0)})
  (route/not-found "Not Found"))

(def app1
  (wrap-defaults app-routes site-defaults))

(def app
  (-> app-routes
      json/wrap-json-response
      json/wrap-json-body))
