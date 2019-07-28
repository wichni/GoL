package pl.jwichniarek;

import java.util.Scanner;

public class Board {
    Scanner user = new Scanner(System.in);
    double userr;

    private int size = user.nextInt();

    private boolean[][] grid;

    public Board() {
        initGrid();
    }

    public Board(boolean[][] grid) {

        this.grid = grid;
        this.size = this.grid.length;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((grid[i][j] ? (Colors.ANSI_RED+'x'+Colors.ANSI_RESET) : "-") + "  ");
            }
            System.out.println();

        }
    }

    private void initGrid() {
        grid = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = getRandomCellState();
            }
        }
    }

    private boolean getRandomCellState() {
        return Math.random() >= 0.7;
    }

    public boolean tick() {
        boolean isAnyAlive = false;

        boolean[][] newGrid = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newGrid[i][j] = isCellAliveInNextGen(i, j);

                if (newGrid[i][j] && !isAnyAlive) {
                    isAnyAlive = true;
                }
            }
        }
        grid = newGrid;

        return isAnyAlive;
    }

    private boolean isCellAliveInNextGen (int x, int y){
        int neighbours = getNeighbours(x, y);

        switch (neighbours){
            case 2:
                return grid[x][y];
            case 3:
                return true;
                default:
                    return false;
        }
    }

    protected int getNeighbours(int x, int y) {

        int aliveNeighbours = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            if (i >= 0 && i < size) {
                for (int j = y - 1; j <= y + 1; j++)
                    if (j >= 0 && j < size) {
                        if (!(i == x && j == y) && grid[i][j]) {
                            aliveNeighbours++;
                        }
                    }
            }
        }
        return aliveNeighbours;
    }

    private class ColorsPiece {
    }
}
