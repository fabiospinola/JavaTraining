import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[]args){
        int count = 0;
        char[] pos = {'1','2','3','4','5','6','7','8','9'};

        printBoard(pos);
        getPlay(pos);
        getWinner(pos);

    }

    static void printBoard(char[] pos){
        System.out.println(" " + pos[0] + " | " + pos[1] + " | " + pos[2] 
+ " ");
        System.out.println("---+---+---");
        System.out.println(" " + pos[3] + " | " + pos[4] + " | " + pos[5] 
+ " ");
        System.out.println("---+---+---");
        System.out.println(" " + pos[6] + " | " + pos[7] + " | " + pos[8] 
+ " ");
    }

    static char[] getPlay(char[] pos){
        int input = 0;

        for(int i = 1; i < 10; i++){
            System.out.println("What's the position you want to play?");
            input = scanner.nextInt();

            if (i%2 == 0){
                pos[input - 1] = 'O';
                printBoard(pos);
            }
            else{
                pos[input - 1] = 'X';
                printBoard(pos);
            }
        }
        return pos;
    }
    static void printWinner (char pos){
        System.out.println("");
        System.out.println("##################################");
        System.out.println("### AND THE WINNER IS PLAYER "+pos+" ###");
        System.out.println("##################################");
    }
    static void getWinner (char[] pos){
        char winner = 0;
        
        if(pos[0]==pos[1] && pos[0]==pos[2]) {
            winner = pos[0];

        }else if (pos[3]==pos[4] && pos[3]==pos[5]){
            winner = pos[3];

        }else if(pos[6]==pos[7] && pos[6]==pos[8]){
            winner = pos[6];

        }else if (pos[0]==pos[3] && pos[0]==pos[6]){
            winner = pos[0];

        } else if (pos[1]==pos[4] && pos[1]==pos[7]){
            winner = pos[1];

        }else if (pos[2]==pos[5] && pos[2]==pos[8]){
            winner = pos[2];

        } else if (pos[0]==pos[4] && pos[0]==pos[8]){
            winner = pos[0];

        }else if (pos[2]==pos[4] && pos[2]==pos[6]){
            winner = pos[2];
        }
        else{
            System.out.println("######################");
            System.out.println("### WE HAVE A DRAW ###");
            System.out.println("######################");
        }
        printWinner(winner);
    }
}
