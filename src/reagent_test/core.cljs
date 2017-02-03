(ns reagent-test.core
    (:require [reagent.core :as reagent]
              [shadow.markup.css :as css :refer (defstyled)]))

(defstyled h1 :h1
  [_]
  {:color "red"})

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
