(ns reagent-test.core
  (:require [reagent.core :as reagent]
            [shadow.markup.css :as css :refer (defstyled)]))

(def media-demo
  "@media (max-width: 600px)")

(defstyled h1 :h1
  [_]
  {:color "red"
   media-demo
   {:color "green"}})

;; -------------------------
;; Views

(defn home-page []
  [:div [h1 "Welcome to Reagent"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
