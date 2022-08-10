import java.io.File;
import java.util.Scanner;

class GameofLife
{
   private char grid[][] = new char[20][20];
   private char nextGen[][] = new char[20][20];

   //reads data from the file, converts and return value of the generations
   public int getGenReadFile()
   {
       int idx = 0, genValue = 1;
       try
       {
           //open the input file and read the file
           File file = new File("startinggrid.txt");
           Scanner sc = new Scanner(file);
           
           while (sc.hasNext())
           {
               String str = sc.next();
               //if the length of the string is 20 read into grid
               if (str.length() == 20)
               {
                   for (int j = 0; j < 20; j++)
                   {
                       grid[idx][j] = str.charAt(j);

                   }
                   idx++;
               }
               //Get number of generations from last line
               else
               {
                   genValue = Integer.parseInt(str);
                   break;
               }
           }
           sc.close();
       }
       catch (Exception e)
       {
           System.out.println(e);
       }
       //return the generation value
       return genValue;
   }
   // processThread nextGen for generation one at a time
   public void processThread()
   {
       //thread for each square of the grid
       // create 20*20 thread for each square
       Thread thread[] = new Thread[400];
       int idx = 0;
       for (int i = 0; i < 20; i++)
       {
           for (int j = 0; j < 20; j++)
           {
               //create a thread by passing the constructor of GameOperate
               thread[idx] = new Thread(new GameOperate(i, j, grid, nextGen));
               thread[idx].start();
               idx++;
           }
       }
       try
       {
           for (int i = 0; i < 400; i++)
           {
               //call the join method for each thread.
               thread[i].join();
           }
              
       }
       catch (Exception e)
       {
           System.out.println(e);
       }
       //assign the next generation value into grid value
       for (int i = 0; i < 20; i++)
       {
           for (int j = 0; j < 20; j++)
           {
               grid[i][j] = nextGen[i][j];
           }
       }  
   }

   public static void main(String[] args)
   {
       GameofLife game = new GameofLife();
       //call the method to read the file
       //getGenReadFile
       int gen = game.getGenReadFile();
       // call the method processThread for each generation
       for (int i = 0; i < gen; i++)
       {
           game.processThread();
       }
       // printing processThread
       System.out.println("The output at the last generation");
       for (int i = 0; i < 20; i++)
       {
           for (int j = 0; j < 20; j++)
           {
               //print as string output
               System.out.print(String.valueOf(game.grid[i][j]));
           }
           System.out.println("");
       }
   }
}