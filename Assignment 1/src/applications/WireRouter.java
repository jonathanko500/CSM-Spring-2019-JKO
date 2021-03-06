/** find and output a shortest wire path in a grid */

package applications;

import java.util.*;

import dataStructures.*;
//import utilities.*;

public class WireRouter
{//start everything
   // top-level nested class
	/** entry point for wire routing program */
	public static void main(String [] args)
	{//start main
	      welcome();
	      inputData();
	      if (findPath()) outputPath();
	      else System.out.println("There is no wire path");
	}//end main
	private static class Position
	{//start position
		// data members
		private int row;   // row number of the position
		private int col;   // column number of the position
		
		// constructor
		private Position(int theRow, int theCol)
		{
			row = theRow;
			col = theCol;
		}

		// convert to string suitable for output
		public String toString()
		{
			return new String(row + " " + col);
		}
   }//end position
   //*********************************************************************
   // data members
	private static int [][] grid;
	private static int size,
					   xS,
					   yS,
					   xF,
					   yF;         // number of rows and columns in the grid
	private static int pathLength;   // length of shortest wire path
	private static ArrayQueue q;     // queue of unexpanded reached positions
	private static Position start,   // one end point of wire
							finish;  // other end point
	private static Position [] path; // the shortest path
   
   // methods
   /* not yet implemented */
	private static void welcome()
	{//start welcome
		System.out.println("Welcome to the Maze!");
	}//end welcome
   //***********************************************************************
   /** input the wire routing data */
	private static void inputData()
	{//start input data
		// define the input stream to be the standard input stream
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter grid size: ");
		size = Integer.parseInt(keyboard.nextLine());

		System.out.print("Enter the start position (x): ");
		xS = Integer.parseInt(keyboard.nextLine());
		System.out.print("Enter the start position (y): ");
		yS = Integer.parseInt(keyboard.nextLine());
		start = new Position(xS,yS);
		
		System.out.print("Enter the finish position (x): ");
		xF = Integer.parseInt(keyboard.nextLine());
		System.out.print("Enter the finish position (y): ");
		yF = Integer.parseInt(keyboard.nextLine());
		finish = new Position(xF,yF);
		
		// create and input the wiring grid array
		grid = new int [size + 2][size + 2];
		System.out.println("Enter the wiring grid in row-major order");
		for (int i = 1; i <= size; i++)
		{// start loop
			for (int j = 1; j <= size; j++)
			{
				grid[i][j] = 0;
			}	
		}//end loop
	}//end input data
	/** find a shortest path from start to finish
     * @return true if successful, false if impossible */
	private static boolean findPath()
	{//start find path
		if ((start.row == finish.row) && (start.col == finish.col))
		{// start == finish
			pathLength = 0;
			return true;
		}
		
		// initialize offsets
		Position [] offset = new Position [4];
		offset[0] = new Position(0, 1);   // right
		offset[1] = new Position(1, 0);   // down
      	offset[2] = new Position(0, -1);  // left
      	offset[3] = new Position(-1, 0);  // up
      	
      	// initialize wall of blocks around the grid
      	for (int i = 0; i <= size + 1; i++)
      	{
      		grid[0][i] = grid[size + 1][i] = 1; // bottom and top
      		grid[i][0] = grid[i][size + 1] = 1; // left and right
      	}
      	
      	Position here = new Position(start.row, start.col);
      	grid[start.row][start.col] = 2; // block
      	int numOfNbrs = 4; // neighbors of a grid position
      	
      	// label reachable grid positions
      	ArrayQueue q = new ArrayQueue();
      	Position nbr = new Position(0, 0);
      	do 
      	{// label neighbors of here
      		for (int i = 0; i < numOfNbrs; i++)
      		{// check out neighbors of here
      			nbr.row = here.row + offset[i].row;
      			nbr.col = here.col + offset[i].col;
      			if (grid[nbr.row][nbr.col] == 0)
      			{  // unlabeled nbr, label it
      				grid[nbr.row][nbr.col]= grid[here.row][here.col] + 1;
      				if ((nbr.row == finish.row) && (nbr.col == finish.col))
      					break; // done
      				// put on queue for later expansion
      				q.put(new Position(nbr.row, nbr.col));
      			}
      		}//end loop
      		
      		// have we reached finish?
      		if ((nbr.row == finish.row) && (nbr.col == finish.col))
      			break;// done
      		
      		// finish not reached, can we move to a nbr?
      		if (q.isEmpty()) return false;          // no path
      		here = (Position) q.remove();  // get next position
      	} while(true);//end loop
               
      // construct path
      pathLength = grid[finish.row][finish.col] - 2;
      path = new Position [pathLength];
   
      // trace backwards from finish
      here = finish;
      for (int j = pathLength - 1; j >= 0; j--)
      {
         path[j] = here;
         // find predecessor position
         for (int i = 0; i < numOfNbrs; i++)
         {
            nbr.row = here.row + offset[i].row;
            nbr.col = here.col + offset[i].col;
            if (grid[nbr.row][nbr.col] == j + 2) break;
         }
         here = new Position(nbr.row, nbr.col);  // move to predecessor
      }
   
      return true;
   }//end find path
   
   /** output path to exit */
   private static void outputPath()
   {//start out path
      System.out.println("The wire path is");
      for (int i = 0; i < pathLength; i++)
         System.out.println(path[i]);
   }//end out path
}//end everything
