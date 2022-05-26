package com.company;

import java.util.Random;

public class Game {

    private static final int EMPTY_CELL = 0;
    private static final int LIVE_CELL = 1;
    private static final int GRID_HEIGHT = 6;
    private static final int GRID_WIDTH = 10;

    private int[][] grid = new int[GRID_HEIGHT][GRID_WIDTH];

    public void showPlayingField() {

        generateGrid();
        printGrid();
    }

    public void nextRound() {

        int[][] tmp = new int[GRID_HEIGHT][GRID_WIDTH];

        for (var y = 0; y < GRID_HEIGHT; y++) {
            for (var x = 0; x < GRID_WIDTH; x++) {
                var aliveNeighbours = 0;
                for (var i = -1; i <= 1; i++) {
                    for (var j = -1; j <= 1; j++) {
                        if ((y + i >= 0 && y + i < GRID_HEIGHT) && (x + j >= 0 && x + j < GRID_WIDTH)) {
                            aliveNeighbours += grid[y + i][x + j];
                        }
                        aliveNeighbours -= grid[y][x];

                        if ((grid[y][x] == LIVE_CELL) && (aliveNeighbours < 2)) {
                            tmp[y][x] = EMPTY_CELL;

                        } else if ((grid[y][x] == LIVE_CELL) && (aliveNeighbours > 3)) {
                            tmp[y][x] = EMPTY_CELL;

                        } else if ((grid[y][x] == EMPTY_CELL) && (aliveNeighbours == 3)) {
                            tmp[y][x] = LIVE_CELL;

                        } else {
                            tmp[y][x] = grid[y][x];
                        }
                    }
                }
            }
        }

        copyArray(tmp);
        printGrid();
    }

    private void generateGrid() {
        var random = new Random();

        for (var i = 0; i < 6; i++) {
            for (var j = 0; j < 10; j++) {
                if (random.nextInt(8) % 4 == 0) {
                    this.grid[i][j] = LIVE_CELL;
                } else {
                    this.grid[i][j] = EMPTY_CELL;
                }
            }
        }
    }

    private void printGrid() {
        for (var i = 0; i < GRID_HEIGHT; i++) {
            for (var j = 0; j < GRID_WIDTH; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private void copyArray(int[][] referenceArray) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                grid[i][j] = referenceArray[i][j];
    }
}
