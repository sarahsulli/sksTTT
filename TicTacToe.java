import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe
{
    char[][] board = new char[3][3];
    Scanner give = new Scanner(System.in);
    Random rand = new Random();
    int xIn; int yIn;

    public void display(){
        for(int i = 0; i < board.length-2; i++){
            for(int j = 0; j < board[0].length; j++){
                char one = board[i][j]; char two = board[i+1][j]; char three = board[i+2][j];
                System.out.format("%3s%3s%3s%n", "["+one+"]", "["+two+"]", "["+three+"]");
            }
        }
    }

    public void fillBlank(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = ' ';
            }
        }
    }

    public boolean isFull() {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    //Boolean determines whether X or O turn
    public void addToBoard(int x, int y, boolean z){
        if(z == true) {
            board[x][y] = 'X';
        }else {
            board[x][y] = 'O';
        }
    }

    //Asks where wants position
    public void setUserInput(boolean xo){
        try 
        {
            System.out.print("Horizontal (0-2) --> ");
            xIn = give.nextInt();
            System.out.print("Vertical (0-2) --> ");
            yIn = give.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Error: You didn't pick a number. Turn skipped");
        }
        try 
        {
            if(board[xIn][yIn] == ' ') 
            { 
                addToBoard(xIn, yIn, xo); 
            }
            else
            { 
                System.out.println("That spots taken! Your turn is skiped skipped. ya snooze ya lose"); 
            }
        }
        catch(ArrayIndexOutOfBoundsException f) 
        {
            System.out.println("Out of bounds! Your turn is skiped. ya snooze ya lose");
        }
    }    

    public void setRandInput() 
    {
        boolean placed = false;
        while(placed == false && isFull() == false) 
        {
            int randX = rand.nextInt(3);
            int randY = rand.nextInt(3);
            if(board[randX][randY] == ' ') 
            {
                placed = true;
                addToBoard(randX, randY, false);
            }
        }
    }
    //checks if win
    public char winCheck()
    {
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2]) 
        {
            if(board[0][0] == 'X') 
            {
                return 'X';
            }
            else if(board[0][0] == 'O') 
            {
                return 'O';
            }
        }
        else if(board[1][0] == board[1][1] && board[1][1] == board[1][2]) 
        {
            if(board[1][0] == 'X') 
            {
                return 'X';
            }
            else if(board[1][0] == 'O') 
            {
                return 'O';
            }
        }
        else if(board[2][0] == board[2][1] && board[2][1] == board[2][2]) 
        {
            if(board[2][0] == 'X') 
            {
                return 'X';
            }
            else if(board[2][0] == 'O') 
            {
                return 'O';
            }
        }
        else if(board[0][0] == board[1][0] && board[1][0] == board[2][0]) 
        {
            if(board[0][0] == 'X') 
            {
                return 'X';
            }
            else if(board[0][0] == 'O') 
            {
                return 'O';
            }
        }
        else if(board[0][1] == board[1][1] && board[1][1] == board[2][1]) 
        {
            if(board[0][1] == 'X')
            {
                return 'X';
            }
            else if(board[0][1] == 'O') 
            {
                return 'O';
            }
        }
        else if(board[0][2] == board[1][2] && board[1][2] == board[2][2]) 
        {
            if(board[0][2] == 'X') 
            {
                return 'X';
            }
            else if(board[0][2] == 'O') 
            {
                return 'O';
            }
        }
        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) 
        {
            if(board[0][0] == 'X') 
            {
                return 'X';
            }
            else if(board[0][0] == 'O') 
            {
                return 'O';
            }
        }
        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) 
        {
            if(board[1][1] == 'X') 
            {
                return 'X';
            }
            else if(board[1][1] == 'O') 
            {
                return 'O';
            }
        }
        return 'n';
    }

    public void game() {
        fillBlank();
        display();
        while(winCheck() == 'n' && isFull() == false) {
            setUserInput(true);
            display();
            System.out.println("Computer turn");
            setRandInput();
            display();
        }
        if(winCheck() == 'n' && isFull() == true) {
            System.out.println("Draw!");
        }else if(winCheck() == 'X') {
            System.out.println("X Wins!");
        }else if(winCheck() == 'O') {
            System.out.println("O Wins!");
        }
    }

    public void computerPlays() {
        fillBlank();
        display();
        while(winCheck() == 'n' && isFull() == false) {
            System.out.println("Player 1: ");
            setUserInput(true);
            display();
            System.out.println("Player 2: ");
            setUserInput(false);
            display();
        }
        if(winCheck() == 'n' && isFull() == true) {
            System.out.println("Draw!");
        }else if(winCheck() == 'X') {
            System.out.println("X Wins!");
        }else if(winCheck() == 'O') {
            System.out.println("O Wins!");
        }
    }

}