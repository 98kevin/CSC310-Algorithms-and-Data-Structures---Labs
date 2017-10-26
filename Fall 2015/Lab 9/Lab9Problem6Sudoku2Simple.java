import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab9Problem6Sudoku2Simple
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
   		    else
    		      System.out.println("no");

    	}
    	scan.close();
	}
	  public static int[][] getFreeCellList(int[][] grid) {
	    int numberOfFreeCells = 0;   
	    for (int i = 0; i < grid.length; i++)
	      for (int j = 0; j < grid.length; j++) 
	        if (grid[i][j] == 0) 
	          numberOfFreeCells++;
	    
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
	  public static boolean search(int[][] grid) {
	    int[][] freeCellList = getFreeCellList(grid); 
	    int k = 0;   
	    boolean found = false; 
	    
	    while (!found) {
	      int i = freeCellList[k][0];
	      int j = freeCellList[k][1];
	      if (grid[i][j] == 0) 
	        grid[i][j] = 1; 

	      if (isValid(i, j, grid)) {
	        if (k + 1 == freeCellList.length) { 
	          found = true; 
	        }
	        else { 
	          k++;
	        }
	      }
	      else if (grid[i][j] < grid.length) {
	        grid[i][j] = grid[i][j] + 1; 
	      }
	      else { 
	        while (grid[i][j] == grid.length) {
	          grid[i][j] = 0; 
	          if (k == 0) {
	            return false; 
	          }
	          k--; 
	          i = freeCellList[k][0];
	          j = freeCellList[k][1];
	        }

	        grid[i][j] = grid[i][j] + 1; 
	      }
	    }

	    return true; 
	  }

	  public static boolean isValid(int i, int j, int[][] grid) {
	    for (int column = 0; column < grid.length; column++)
	      if (column != j && grid[i][column] == grid[i][j])
	        return false;

	    for (int row = 0; row < grid.length; row++)
	      if (row != i && grid[row][j] == grid[i][j])
	        return false;

	    return true; 
	  }

	  public static boolean isValid(int[][] grid) {
	    for (int i = 0; i < grid.length; i++)
	      for (int j = 0; j < grid.length; j++)
	        if (grid[i][j] != 0 && !isValid(i, j, grid)) return false;

	    return true; 
	  }
}
