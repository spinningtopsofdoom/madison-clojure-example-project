(ns game.life.core
  (:require [quil.core :as qc]
            [quil.middleware :as qm]))
(def cell-size 5)
(def cell-x 40)
(def cell-y 40)
(def board-size-x (* cell-size cell-x))
(def board-size-y (* cell-size cell-y))
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
    (qc/rect (* x cell-size) (* y cell-size) cell-size cell-size)))

(qc/defsketch life
  :title "Conway's Game of Life"
  :size [board-size-x board-size-y]
  :setup setup
  :middleware [qm/fun-mode]
  :draw draw
  :update step)

(comment
  (def next-board (step board))
  (display-board board)
  (display-board next-board))
