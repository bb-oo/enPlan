(ns app.dashboard.info
  (:require
   [goog.string :as gstring]
   [reagent.core :as reagent
     :refer [atom]]
   [re-frame.core :as rf]
   [cljsjs.material-ui]
   [cljs-react-material-ui.core :as material
     :refer [get-mui-theme color]]
   [cljs-react-material-ui.reagent :as ui]
   [cljs-react-material-ui.icons :as ic]
   [app.dashboard.pane
    :refer [pane]]))

(defn response-table [session]
  [:table.table.table-striped.table-sm
    (into [:tbody]
     (for [[k v] @(:survey/response session)]
       [:tr [:th (str k)]
            [:td (str v)]]))])

(defn response-card [session]
  (let []
    [:div.card
     [:div.card-body
      [:h3.card-title "Survey Response"]
      [response-table session]]]))

(defn view [session]
  [:div
   [response-card session]])
