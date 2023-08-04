# Madison Clojure Meetup Example Project

An example project to show how to build Clojure Applications and explore different parts of the Clojure ecosystem

## Project Creation

The example project will be creating [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

The project will display the cells starting configuration the show the updates at each time step as per the rules. Any method of displaying the 2d cell grid is allowed. The project structure can be any desired along with any libraries needed

### Game of Life Rules

Conway's game of life takes place on a 2d square grid with cells that are alive (`X`) or dead (`O`). At each step cells can either become alive or dead. The rules for determining the cells status are

1) Any live cell with two or three live neighbors survives

Examples of live cells staying alive
```
XXX OOX OOO XXO
OXO OXO XXX XXO
OOO XOO OOO OOO
```

2) Any dead cell with three live neighbors becomes a live cell.

Examples of dead cells changing to live cells
```
XXX OOX OXO XXO
OOO XOO XOX XXO
OOO XOO OOO OOO
```

3) All other cells become dead

Examples of cells becoming or staying dead
```
OOO XXX XOO XXX XOO
OOO XXO OXO OOO OOX
OOO OOO OOO XXX OOO
```