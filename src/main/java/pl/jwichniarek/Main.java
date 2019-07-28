package pl.jwichniarek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" Game of life ");
        System.out.println();
        Game game = new Game();
        game.startGame();

    }
}
