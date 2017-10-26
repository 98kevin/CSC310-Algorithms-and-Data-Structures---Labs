import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab9Problem6Sudoku2
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File input=new File("p6.txt");

    	Scanner scan=new Scanner(input);
    	int testcases=scan.nextInt();
    	for(int test=0;test<testcases;test++)
    	{
    		int N=scan.nextInt();
    		int m=scan.nextInt();
    		int[][] array=new int[N][N];
    		for(int i=0;i<m;i++)
    		{
    			int n=scan.nextInt();
    			int r=scan.nextInt();
    			int c=scan.nextInt();
    			array[r][c]=n;
    		}
    		
    		if (search(array)) {System.out.println("yes");}
    		     // printGrid(grid);
   		    else
    		      System.out.println("no");
/*    	    if (SolveSudoku(array) == true)
    	    	System.out.println("yes");//printGrid(array);
    	    else
    	    	System.out.println("no");// solution exists");
  */	 

    	}
    	scan.close();
	}
	public static int[][] readAPuzzle() {
	    // Create a Scanner
	    Scanner input = new Scanner(System.in);

	    System.out.println("Enter a Sudoku puzzle:");
	    int[][] grid = new int[9][9];
	    for (int i = 0; i < 9; i++) 
	      for (int j = 0; j < 9; j++)
	        grid[i][j] = input.nextInt();
	    
	    return grid;
	  }

	  /** Obtain a list of free cells from the puzzle */
	  public static int[][] getFreeCellList(int[][] grid) {
	    // Determine the number of free cells 
	    int numberOfFreeCells = 0;   
	    for (int i = 0; i < grid.length; i++)
	      for (int j = 0; j < grid.length; j++) 
	        if (grid[i][j] == 0) 
	          numberOfFreeCells++;
	    
	    // Store free cell positions into freeCellList 
	    int[][] freeCellList = new int[numberOfFreeCells][2];
	    int count = 0;
	    for (int i = 0; i < grid.length; i++)
	      for (int j = 0; j < grid.length; j++) 
	        if (grid[i][j] == 0) {
	          freeCellList[count][0] = i;
	          freeCellList[count++][1] = j;
	        }
	    
	    return freeCellList;
	  }

	  /** Print the values in the grid */
	  public static void printGrid(int[][] grid) {
	    for (int i = 0; i < grid.length; i++) {
	      for (int j = 0; j < grid.length; j++)
	        System.out.print(grid[i][j] + " ");
	      System.out.println();
	    }
	  }

	  /** Search for a solution */
	  public static boolean search(int[][] grid) {
	    int[][] freeCellList = getFreeCellList(grid); // Free cells
	    int k = 0; // Start from the first free cell    
	    boolean found = false; // Solution found?
	    
	    while (!found) {
	      int i = freeCellList[k][0];
	      int j = freeCellList[k][1];
	      if (grid[i][j] == 0) 
	        grid[i][j] = 1; // Start with 1

	      if (isValid(i, j, grid)) {
	        if (k + 1 == freeCellList.length) { // No more free cells 
	          found = true; // A solution is found
	        }
	        else { // Move to the next free cell
	          k++;
	        }
	      }
	      else if (grid[i][j] < grid.length) {
	        grid[i][j] = grid[i][j] + 1; // Check the next possible value
	      }
	      else { // grid[i][j] is 9, backtrack
	        while (grid[i][j] == grid.length) {
	          grid[i][j] = 0; // Reset to free cell
	          if (k == 0) {
	            return false; // No possible value
	          }
	          k--; // Backtrack
	          i = freeCellList[k][0];
	          j = freeCellList[k][1];
	        }

	        grid[i][j] = grid[i][j] + 1; // Check the next possible value
	      }
	    }

	    return true; // A solution is found
	  }

	  /** Check whether grid[i][j] is valid in the grid */
	  public static boolean isValid(int i, int j, int[][] grid) {
	    // Check whether grid[i][j] is valid at the i's row
	    for (int column = 0; column < grid.length; column++)
	      if (column != j && grid[i][column] == grid[i][j])
	        return false;

	    // Check whether grid[i][j] is valid at the j's column
	    for (int row = 0; row < grid.length; row++)
	      if (row != i && grid[row][j] == grid[i][j])
	        return false;

	    // Check whether grid[i][j] is valid in the 3 by 3 box
/*	    for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
	      for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
	        if (row != i && col != j && grid[row][col] == grid[i][j])
	          return false;
//TRUE above cz hell with box*/
	    return true; // The current value at grid[i][j] is valid
	  }

	  /** Check whether the fixed cells are valid in the grid */
	  public static boolean isValid(int[][] grid) {
	    for (int i = 0; i < grid.length; i++)
	      for (int j = 0; j < grid.length; j++)
	        if (grid[i][j] != 0 && !isValid(i, j, grid)) return false;

	    return true; // The fixed cells are valid
	  }
}
