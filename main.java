import java.util.Scanner;

public class main {
    public static void main (String[] args) {
        TicTacToe test = new TicTacToe();
        test.displayExBoard();
        Scanner s = new Scanner(System.in);
        System.out.println("To play: input first number in a square and hit enter, then input second number in a square and hit enter.");
        while (!test.getGameOver()) {
            System.out.println();
            System.out.println("Input first number");
            int first = s.nextInt();
            System.out.println();
            System.out.println("Input second number");
            int second = s.nextInt();
            System.out.println();
            test.play(first, second);
            test.checkWinner();
        }
    }
}