(ns nodashka.reagent
  (:require #_[reagent.dom.server :as rds]
            [nodashka.core :as nodashka]
            [reagent.core :as r]
            [reagent.dom :as rdom]
            [sci.core :as sci]))

(def rns (sci/create-ns 'reagent.core nil))

(def reagent-namespace
  {'atom (sci/copy-var r/atom rns)
   'as-element (sci/copy-var r/as-element rns)})

(def rdns (sci/create-ns 'reagent.dom nil))

(def reagent-dom-namespace
  {'render (sci/copy-var rdom/render rdns)})

(def rdsns (sci/create-ns 'reagent.dom.server nil))

#_(def reagent-dom-server-namespace
  {'render-to-string (sci/copy-var rds/render-to-string rdsns)})

(defn init []
  (nodashka/register-plugin!
   ::reagent
   {:namespaces {'reagent.core reagent-namespace
                 'reagent.dom reagent-dom-namespace
                 #_#_'reagent.dom.server reagent-dom-server-namespace}}))