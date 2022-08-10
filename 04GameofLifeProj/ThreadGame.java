import java.io.File;
import java.util.Scanner;
//define a class that implement Runnable
class GameOperate implements Runnable
{
   //declare the variables
   private int x, y;
   private char grid[][], nextGen[][];
   //define the constructor
   public GameOperate(int x, int y, char[][] grid, char[][] nextGen)
   {
       this.x = x;
       this.y = y;
       this.grid = grid;
       this.nextGen = nextGen;
   }

   //definition of the method isCellAlive()
   // find the status for x,y square for next generation
   public boolean isCellAlive()
   {
       int neighbor = 0;
       //find the number of neighbors alive
       for (int i = x - 1; i <= x + 1; i++)
       {
           for (int j = y - 1; j <= y + 1; j++)
           {
               if ((i != x || j != y) && i >= 0 && j >= 0 && i < 20 && j < 20
                       && grid[i][j] == 'X')
               {
                   neighbor++;
               }
           }
       }
       // check if the cell is dead and exactly three live neighbors
       //lives on to the next generation then, the cell is live
       if (grid[x][y] == 'O' && neighbor == 3)
       {
           return true;
       }      
       // check if the cell is alive and and it has either 2 or 4 neighbours
       // then the cell is alive
       if (grid[x][y] == 'X' && (neighbor == 2 || neighbor == 3))
       {
           return true;
       }
       //otherwise the cell is dead
       return false;
   }

   @Override
   public void run()
   {
       //call the method isCellAlive
       boolean isAlive = isCellAlive();
       //if the cell is alive, make it alive in next generation
       if (isAlive)
           nextGen[x][y] = 'X';
       else
           nextGen[x][y] = 'O';
   }
}