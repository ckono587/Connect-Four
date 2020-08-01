package ConnectF4;
import java.util.Scanner;

public class Connect4 {

	public static void main(String args[])
	// Variable Declaration.
    { 

       Scanner input = new Scanner(System.in);
       char[][] board = new char[7][8];
       //boolean finished = false;
        boolean gameOver = false;
        char currentPlayer = 'X';
        int numMoves = 0;
        // loop until user wants to stop
        initialize(board);

        do

        	{ 
        	// Display The Board
        		DisplayBoard(board);
        		// Initialize player move
        		System.out.print("Player " + currentPlayer + " - enter the column to drop your piece: ");
        		int col = input.nextInt();
        		if (makeMove(board,col, currentPlayer)){             
        			// Try move
        			if(checkForWin(board))
        				// Check for winner
        				{ 
        					System.out.println("Player " + currentPlayer + " is the victor!");
        					DisplayBoard(board);
        					return;
        				}
        			// Swap players
        			currentPlayer = swapPlayer(currentPlayer); 
        			numMoves = numMoves + 1;
        		}
        		// Checking to see if the game is a tie
        		if (numMoves == 42)
        			{
        				System.out.println("The Game is a Tie!");
        				DisplayBoard(board);
        				gameOver = true;
        				
        			}
        	} while (!gameOver);

    }

    public static char[][] initialize(char[][] board){
    	for(int row = 0; row < board.length; row++) {
    		for(int col = 0; col < board[0].length; col++) {
    			board[row][col] = '*';

    		}
    	}
    	
    	return board;
    }
 public static void DisplayBoard(char[][] board)

    {
	 System.out.println();

	 	for(int row = 0; row < board.length; row++) {

	 		for(int c = 0; c < board[0].length; c++) {

	 			System.out.printf("%s ",board[row][c]);
	 		}

	 		System.out.println();

	 	}
	 	System.out.println();

}

    public static boolean makeMove(char[][] board, int col, char player)		
    {
    	boolean result = false;
    	// Check if the column is full
    	if (board[0][col] != '*')
    	{
    		System.out.println("That column is already full.");
    		return false;
    	}
    	
    	for (int row = board.length-1; row >= 0; row--)
    	{
    		if (board[row][col] == '*')
    		{
    			board[row][col] = player;
    			return true;
    		}
    	}
    	return result;
    }

   

    public static boolean checkForWin(char[][] board)

    {
    	// Check for win horizontally
    	for (int row = 0; row < board.length; row++)
    	{

    		for (int col = 0; col < board[row].length - 3; col++)
    		{
    			if 	(	
    				board[row][col] != '*' 
    				&& board[row][col] == board[row][col+1] 
    				&& board[row][col] == board[row][col+2] 
    				&& board[row][col] == board[row][col+3]
    				)
    			{
    				return true;
    			}
    		}
    	}
    	
    	// Check for win vertically
    	for (int col = 0; col < board[0].length; col++)
    	{
    		for (int row = 0; row < board.length - 3; row++)
    		{
    			if 
    				(
    				board[row][col] != '*' 
    				&& board[row][col] == board[row+1][col] 
    				&& board[row][col] == board[row+2][col] 
    				&& board[row][col] == board[row+3][col]
    				)
    			{
    				return true;
    			}
    		}
    	}

    	// Check for diagonal top
    	for (int row = 0; row < board.length - 3; row++)
    	{
    		for (int col = 0; col < board[row].length - 3; col++)
    		{
    			if 
    				(
    				board[row][col] != '*' 
    				&& board[row][col] == board[row+1][col+1] 
    				&& board[row][col] == board[row+2][col+2] 
    				&& board[row][col] == board[row+3][col+3]
    				)
    			{
    				return true;
    			}
    		}
    	}
    	
    	
    	// Check for diagonal down

    	for (int row = 0; row < board.length - 3; row++)
    	{
    		for (int col = 3; col < board[row].length; col++){
    			if 
    				(
    				board[row][col] != '*' 
    				&& board[row][col] == board[row+1][col-1]
    				&& board[row][col] == board[row+2][col-2] 
    				&& board[row][col] == board[row+3][col-3]
    				)
    			{
    				return true;
    			}

    		}
    	}
    	return false;
    }

   

    public static char swapPlayer(char currentPlayer)

    {

                    if (currentPlayer == 'X')
                    {

                                    return 'O';

                    }

                    else
                    {

                                    return 'X';
                    }
                    

    }
}
