
import java.util.Scanner;
//Sara
public class TicTacToe {
    static String[] pos = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    static int round = 1;
    static String turn = "X";

    public static void main(String[] args) {
        board();
        Scanner scanner = new Scanner(System.in);
        while (round < 10) {
            System.out.println("which position to play?");
            int play = scanner.nextInt();
            if (round % 2 != 0) {
                turn = "X";
                pos[play] = turn;
            }
            if (round % 2 == 0) {
                turn = "O";
                pos[play] = turn;
            }
            board();
            CheckWinner();
            round++;
        }

    }

    public static void board() {
        System.out.println(" " + pos[6] + " | " + pos[7] + " | " + pos[8] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + pos[3] + " | " + pos[4] + " | " + pos[5] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + pos[0] + " | " + pos[1] + " | " + pos[2] + " ");
    }

    public static void CheckWinner() {
        //Horizontal
        if (pos[0] == turn && pos[1] == turn && pos[2] == turn) {
            System.out.println(pos[0] + " Is the winner");
        }
        if (pos[3] == turn && pos[4] == turn && pos[5] == turn) {
            System.out.println(pos[0] + " Is the winner");
        }
        if (pos[6] == turn && pos[7] == turn && pos[8] == turn) {
            System.out.println(pos[0] + " Is the winner");
        }

        //Vertical
        if (pos[0] == turn && pos[3] == turn && pos[6] == turn) {
            System.out.println(turn + " Is the winner");
        }
        if (pos[1] == turn && pos[4] == turn && pos[7] == turn) {
            System.out.println(turn + " Is the winner");
        }
        if (pos[2] == turn && pos[5] == turn && pos[8] == turn) {
            System.out.println(turn + " Is the winner");
        }

        //Diagonal
        if (pos[0] == turn && pos[4] == turn && pos[8] == turn) {
            System.out.println(turn + " Is the winner");
        }
        if (pos[2] == turn && pos[4] == turn && pos[6] == turn) {
            System.out.println(turn + " Is the winner");
        }
    }
}
