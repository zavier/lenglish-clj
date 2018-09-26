(ns lenglish-clj.database
  (:use korma.db
        korma.core))

(defdb korma-db (mysql {:db "learn_english",
                        :host "",
                        :port 3306,
                        :user "",
                        :password ""}))

(defentity t_knowledge)

(defn get-all-knowledge []
  (select t_knowledge))