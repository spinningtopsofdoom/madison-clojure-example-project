(ns game.life.core
  (:require [quil.core :as qc]
            [quil.middleware :as qm]))
(def cell-size 5)
(def cell-x 40)
(def cell-y 40)
(def board-size-x (* cell-size cell-x))
(def board-size-y (* cell-size cell-y))

(defn generate-board [cell-num x-size y-size]
  (into #{} (repeatedly cell-num #(vector (rand-int x-size) (rand-int y-size)))))
; Boards are sets of x y coordinates
(def board (generate-board 200 cell-x cell-y))
; Takes a board of the game of life and returns the next time step
(defn step [board]
  (->>
    board
    (mapcat (fn neighbors [[cell-x cell-y]]
              (for
                [x (range -1 2) y (range -1 2) :when (case [x y] [0 0] false true)]
                [(mod (+ cell-x x) 50) (mod (+ cell-y y) 50)])))
    (group-by identity)
    (mapv
      (fn parse [[cell neighbor-cells]]
        [cell (if (board cell) :alive :dead) (count neighbor-cells)]))
    (filter
      (fn lives-on [[_ liveness neighbor-count]]
        (case liveness
          :alive (#{2 3} neighbor-count)
          :dead (= 3 neighbor-count)
          false)))
    (map first)
    (into #{})))

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
