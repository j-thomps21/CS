import java.util.concurrent.TimeUnit;

/**
 * TODO: Implement the remainder of this main function!
 */
public class SolveMaze{

  /** Clears the screen - you don't need to worry about this */
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /** Prints the Maze so you can see progress */
  public static void progress(Maze maze){
    //Prints the Maze so you can see progress
    clearScreen();
    System.out.println(maze);
    //Slows it down so you can track
    try{
      TimeUnit.MILLISECONDS.sleep(100);
    }catch (InterruptedException e) {
      System.exit(1);
    }
  }

  public static void main(String args[]){

    String inputFileName="";

    if(args.length < 1 ||  args[0].equals("-h")){
      System.out.println("java PrintMaze <out.ser>");
      System.out.println("out.ser   : serilized maze stored in output");
      System.exit(1);
    }else{
      inputFileName=args[0];
    }

    //Create the maze by reading the input file
    Maze maze = Maze.fromFile(inputFileName);
    System.out.println(maze);

    Coord start=new Coord(0,0);
    maze.visit(start);

    //TODO: Complete the Solve Maze!
    //
    // Basic Algorithm:
    //    init: enqueue the start index on a queue, and mark it as visited
    //
    //    Loop: continue unitl queue empty or finished reached
    //      0. print progress()
    //      1. dequeue current index
    //      2. Check if we've solved the maze, if so break!
    //      3. if any reachable neighbors from the current index
    //         a. enqueue the the neighbor's index
    //         b. mark the neighbor as visited
    //      4. continue loop
    //

    CircularArrayList gameList = new CircularArrayList();
    gameList.enqueue(start);
    Coord endOfMaze = new Coord(maze.getHeight()-1, maze.getWidth()-1);

    while(gameList.size() != 0){
      progress(maze);
      Coord temp = (Coord)gameList.dequeue();
      if(temp.row == endOfMaze.row && temp.col == endOfMaze.col)
        break;
      List t = maze.getReachableUnvisitedNeighbors(temp);
      for(int i = 0; i < t.size(); i++){
        Coord pos = (Coord)t.get(i);
        gameList.enqueue(pos);
        maze.visit(pos);
      }
    }


    //print final result after complete!
    clearScreen();
    System.out.println(maze);
  }

}
