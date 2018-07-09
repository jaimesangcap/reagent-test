(ns reagent-test.core
  (:require [reagent.core :as reagent]
            [shadow.markup.css :as css :refer (defstyled)]))

(defstyled h1 :h1
  [{:keys [breakpoint-md] :as env}]
  {:color "red"
   breakpoint-md
   {:color "green"}})

;; -------------------------
;; Views

(defn home-page []
  [:div [h1 "Welcome to Reagent"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init []
  (css/set-env!
    {:breakpoint-sm "@media (min-width: 576px)"
     :breakpoint-md "@media (min-width: 768px)"
     :breakpoint-lg "@media (min-width: 992px)"
     :breakpoint-xl "@media (min-width: 1200px)"})
  (mount-root))
