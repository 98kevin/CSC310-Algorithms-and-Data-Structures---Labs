import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab9Problem1Queens
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File input=new File("p1.txt");

    	Scanner scan=new Scanner(input);
    	int N=scan.nextInt();
    	for(int i=0;i<N;i++)
    	{
    		int n=scan.nextInt();
    		int [][]board = new int[n][n];
    		
    		if(putQueens(board, 0))
    			System.out.println("yes");
    			//printQueens(board);
    		else
    			System.out.println("no");
    	}
    	scan.close();
	}
	
	public static void printQueens(int [][]Board)
	{
		for(int row = 0; row < Board.length ; row++)
		{
			for(int col = 0; col < Board[row].length ; col++)
			{
				System.out.print(Board[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isPlaceable(int Board[][],int row,int col)
	{
		for(int i = 0; i < col ; i++)
		{
			if(Board[row][i] == 1)
				return true;
		}
		
		for(int i = col; i < Board.length ; i++)
		{
			if(Board[row][i] == 1)
				return true;
		}
		
		for(int i = row+1, j = col+ 1; i < Board.length && j < Board.length ; i++, j++)
		{
			if(Board[i][j] == 1)
				return true;
		}
		
		for(int i = row- 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--)
		{
			if(Board[i][j] == 1)
				return true;
		}
		
		for(int i = row - 1, j = col + 1; i >= 0 && j < Board.length ; i--, j++)
		{
			if(Board[i][j] == 1)
				return true;
		}
		
		for(int i = row+1, j = col - 1; i < Board.length && j >= 0 ; i++, j--)
		{
			if(Board[i][j] == 1)
				return true;
		}
		return false;
	}
	
	public static boolean putQueens(int [][]board, int value)
	{
		if(value == board.length)
			return true;
		else
		{
			boolean check = false;
			int row = 0;
			
			while(!check && (row < board.length))
			{
				if(isPlaceable(board, row, value))
				{
					row++;
				}
				else
				{
					board[row][value] = 1;
					check = putQueens(board, value + 1);
					
					if(!check)
					{
						board[row][value] = 0;
						row++;
					}
				}
			}
			return check;
		}
	}
}
