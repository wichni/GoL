package pl.jwichniarek;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Colors.ANSI_BLUE + " Game of life " + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_RED + " Enter size: " + Colors.ANSI_RESET);
        Game game = new Game();
        game.startGame();

    }
}
