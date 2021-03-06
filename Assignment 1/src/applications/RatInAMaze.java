/** find and output a path in a maze */

package applications;

import java.util.*;
import java.util.Stack;

import dataStructures.*;
//import utilities.*;

public class RatInAMaze
{//Start RatInaMaze
	/** entry point for rat in a maze program */
	public static void main(String [] args)
	{//start main
		welcome();
		inputMaze();
		
		if (findPath()) outputPath();
		else System.out.println("No path");
		
	}//end main
	// top-level nested class
	private static class Position
	{//start Position
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
   }//end Position
 
	// data members
	private static byte [][] maze;
	private static int size;   // number of rows and columns in the maze
	private static float density;//float
	private static Stack path;  // path to current position
	Random rand = new Random();
	private static int PathOrWall=0;
	private static double chance;
	// methods
	/* not yet implemented */
	private static void welcome() 
	{
		System.out.println("Welcome to the Maze!");
	}
	/** input the maze */
	private static void inputMaze()
	{//start input maze
		// define the input stream to be the standard input stream
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter maze size: ");
		size = Integer.parseInt(keyboard.nextLine());
		
		// create and input the maze array
		maze = new byte [size + 2][size + 2];
		
		//density
		System.out.print("What density (number between 0 and 1):");
		chance=Double.parseDouble(keyboard.nextLine());
		PathOrWall = density(PathOrWall,chance);//increase chance to generate 1
		
		System.out.println("Enter the maze in row-major order");
		for (int i = 1; i <= size; i++)
		{//start loop
			System.out.println();
			for (int j = 1; j <= size; j++)
			{
				maze[i][j] = (byte) PathOrWall;
				System.out.print(maze[i][j]);
				PathOrWall = density(PathOrWall,chance);//0= wall or background 1=path or foreground
				
			}
		}//end loop   
		
	}//end input maze
	public static int density(int num, double chance)// increase chance for obj of array to be 1
	{//start
		Random rand = new Random();
		double f=rand.nextDouble();
		if(f<chance)//default density
		{//bigger decimal = more 0
			num=0;
		}
		else
		{
			num=1;
		}
		return num;
	}//end
   
   /** find a path from (1,1) to the exit (size, size)
     * @return true if successful, false if impossible */
	private static boolean findPath()
	{//start findPath
		path = new Stack();
		int[][] dup = cloneGrid();
   
		// initialize offsets
		Position [] offset = new Position [4];
		offset[0] = new Position(0, 1);   // right
		offset[1] = new Position(1, 0);   // down
		offset[2] = new Position(0, -1);  // left
		offset[3] = new Position(-1, 0);  // up 
      
		// initialize wall of obstacles around maze
		for (int i = 0; i <= size + 1; i++)
		{
			maze[0][i] = maze[size + 1][i] = 1; // bottom and top
			maze[i][0] = maze[i][size + 1] = 1; // left and right
		}
		
		Position here = new Position(1, 1);
		
		maze[1][1] = 1; // prevent return to entrance
		int option = 0; // next move
		int lastOption = 3;
		
		// search for a path
		while (here.row != size || here.col != size)
		{// not at exit
			// find a neighbor to move to
			// won't compile without explicit initialization
			int r = 0, c = 0;   // row and column of neighbor
			while (option <= lastOption)
			{
				r = here.row + offset[option].row;
				c = here.col + offset[option].col;
				if (dup[r][c] == 0) break;
				option++; // next option
			}
    
			// was a neighbor found?
			if (option <= lastOption)  // yes
			{// move to maze[r][c]
				path.push(here);
				here = new Position(r, c);
				// set to 1 to prevent revisit
				dup[r][c] = 1;
				option = 0;
			}
			else
			{// no neighbor to move to, back up
				if (path.empty()) return false;  // no place to back up to
				Position next = (Position) path.pop();
				if (next.row == here.row)
					option = 2 + next.col - here.col;
				else option = 3 + next.row - here.row;
				here = next;
			}
		}//end while
   
		return true;// at exit
   }//end findPath
	
	/** output path to exit */
	private static void outputPath()
	{
		System.out.println("The path is");
		while (!path.empty())
			System.out.println(path.pop());
	}
	public static int[][] cloneGrid ()
	{
		int[][] dup=new int[size+1][size+1];
		for(int i=0;i<size+1;i++)
		{
			for(int j=0;j<size+1;j++)
			{
				if(i==0||j==0)
				{//boarders
					dup[0][j]=0;
					dup[i][j]=0;
				}
				else if(dup[i][j]==dup[1][1])
				{//start of maze
					dup[1][1]=1;
				}
				else 
				{//remaining amount
					dup[i][j]=(int)maze[i][j];
				}
			}
		}
		return dup;
	}
}//end rat in a maze
