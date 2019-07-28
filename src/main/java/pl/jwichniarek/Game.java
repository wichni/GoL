package pl.jwichniarek;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    private Board board;

    public Game(){

        System.out.println("Podaj rozmiar tablicy: ");
        board = new Board();

    }
    public void startGame() throws InterruptedException {

        int liczbaRuchow = 0;

        do {
            board.print();
            System.out.println(Colors.ANSI_BLUE + " ========== " + Colors.ANSI_RESET);
            TimeUnit.MILLISECONDS.sleep(700);
            liczbaRuchow++;
        }while (board.tick());


        board.print();
        System.out.println("Liczba ruchow " + liczbaRuchow);

}
}
