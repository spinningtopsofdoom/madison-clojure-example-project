(ns game.life.core)
; Boards are sets of x y coordinates
(def board #{[0 0] [26 31] [8 12]})
; Takes a board of the game of life and returns the next time step
(defn step [board]
  board)

(defn display-board [board]
  (println board))

(comment
  (def next-board (step board))
  (display-board board)
  (display-board next-board))
