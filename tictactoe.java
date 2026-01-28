import java.util.Scanner;

class tictactoe{
    public static void main(String[] args) {
        char[][]board = new char[3][3];
        for(int row=0;row<board.length;row++){
            for(int col = 0;col<board[row].length;col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.print(" player " + player + " enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            if(board[row][col] == ' '){
                //place the element
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println(" player " +  player  + " has won: ");
                }else if(isDraw(board)){
                    printBoard(board);
                    System.out.println("It's a draw!");
                    gameOver = true;
                }
                else{
                    if(player == 'X'){
                        player = 'O';
                    }else{
                        player = 'X';

                    }
                }

            }else{
                System.out.println("Invalid move.Try again!");
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board,char player){
          //check the row
          for(int row=0;row<board.length;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
            
        }

        //check for col
        for(int col=0; col <board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
            
        }

        //diagonal 
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

         if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;

    }

    public static void printBoard(char[][]board){
        for(int row=0;row<board.length;row++){
            for(int col = 0;col<board[row].length;col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

    }
    // check draw
    public static boolean isDraw(char[][] board){
        for(int row=0;row<3;row++){
            for(int col = 0;col<3;col++){
                if(board[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}