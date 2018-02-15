import java.util.Scanner;

public class GameMenu
{
    //public int n;
    public static void main(String args[]){
        TicTacToe toe = new TicTacToe();
        Scanner prompt = new Scanner(System.in);
        /**System.out.println("Put in values for horizontal and verticle");
        System.out.println("How big do you want the game board (i recomend an odd number)");
        System.out.println("-------->)");              
        n = prompt.nextInt();      */

        System.out.println("What kind of Game do you want to play?");
        System.out.println("(1) Player vs Computer");
        System.out.println("(2) Player vs Player");        
        int decision = prompt.nextInt();
        if(decision == 1){
            toe.game();
        }
        else if(decision == 2){
            toe.computerPlays();
        }
        else{
            System.out.println("pick something else");
        }
        System.out.println("Play again? (yes) or (no)?");
        String a = prompt.next();
        while(a.equals("yes")) {
            System.out.println("What kind of Game do you want to play?");
            System.out.println("(1) Player vs Computer");
            System.out.println("(2) Player vs Player");  
            decision = prompt.nextInt();
            if(decision == 1){
                toe.game();
            }
            else if(decision == 2){
                toe.computerPlays();
            }
            else{
                System.out.println("pick something else");
            }
            System.out.println("Play again? (yes) or (no)");
            a = prompt.next();
        }
        prompt.close();
        System.out.println("Thanks for playing!");
    }
    
}