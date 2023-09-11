(ns game.life.core
  (:require [quil.core :as qc]
            [quil.middleware :as qm]))
; Boards are sets of x y coordinates
(def board #{[0 0] [26 31] [8 12]})
; Takes a board of the game of life and returns the next time step
(defn step [board]
  board)

(defn display-board [board]
  (println board))
(defn setup []
  ; initial state
  (qc/frame-rate 1)
  board)

(defn draw [state]
  (qc/background 0)
  (qc/fill 255 0 0)
  (doseq [[x y] state]
    (qc/rect (* x 5) (* y 5) 5 5)))

(qc/defsketch life
  :title "Conway's Game of Life"
  :size [200 200]
  :setup setup
  :middleware [qm/fun-mode]
  :draw draw
  :update step)

(comment
  (def next-board (step board))
  (display-board board)
  (display-board next-board))
