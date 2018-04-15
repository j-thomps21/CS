#include "readboard.h"

string getFile()
{
  //asks user for board file
  cout << "board file: ";
  string filename;
  cin >> filename;
  ifstream readB(filename.c_str());

  //if the file is no good then exit the program and give error statement
  if(!readB)
  {
    cout << "Not a valid file!" << endl;
    exit;
  }
  return filename;
}

//this function stores the information for the board
Point** storeinfo(ifstream& readB, int* header, Point** spawnpoints)
{
  char c;

  //header array takes in the import information about how many rows
  //how many cols and how many spawns
  readB >> header[0] >> c >> header[1] >> header[2];
  //spawnpoints array saves the points of the end, start, and spawnpoints
  spawnpoints[0] = new Point[header[2]];
  spawnpoints[1] = new Point[1];
  spawnpoints[2] = new Point[1];
  c = readB.get();

  //board array saves all the points on the board.txt file
  Point** board = new Point*[header[0]];
  for(int i = 0; i < header[0]; i++)
    board[i] = new Point[header[1]];

  int count = 0;

  //for loop actually loops and saves all the points
  for(int i = 0; !readB.eof(); i++)
  {
    if(count == header[0]*header[1]) break;
    int rowcount = count / header[1];
    int colcount = count % header[1];

    char A = readB.get();

    if(A == 10) continue;
    board[rowcount][colcount].c = A;

    //if the point is a z or y then change to blank and remeber the point for later
    if(A == 'Z' || A == 'Y')
      ChangeChar(board, spawnpoints, header, count, A);
    board[rowcount][colcount].row = rowcount;
    board[rowcount][colcount].col = colcount;
    count++;
    //changes that point to a blank space and saves the information for later
    if(A == 'X')
    {
      spawnpoints[2][0].c = 'X';
      spawnpoints[2][0].row = rowcount;
      spawnpoints[2][0].col = colcount;
    }
  }
    return board;
}

//function prints the board to the screen through ncurses
void showBoard(Point** board, int* header, WINDOW* W)
{
  cbreak();
  noecho();
  nodelay(W,true);
  curs_set(0);
  keypad(W,true);

  for(int i = 0; i < header[0]*header[1]; i++)
  {
    int rowcount = i / header[1];
    int colcount = i % header[1];
    wmove(W, board[rowcount][colcount].row, board[rowcount][colcount].col);
    waddch(W, board[rowcount][colcount].c);
  }
wrefresh(W);
return;
}

//this function just changes the character of the point that is given and saves the
//information into the spawnpoints array
void ChangeChar(Point** points, Point** spawnpoints, int* header, int count, char A)
{
  int rowcount = count / header[1];
  int colcount = count % header[1];
  points[rowcount][colcount].c = ' ';
  if(A == 'Z')
  {
    spawnpoints[0][header[3]].c = A;
    spawnpoints[0][header[3]].row = rowcount;
    spawnpoints[0][header[3]].col = colcount;
    header[3]++;
  }
  else if(A == 'Y')
  {
    spawnpoints[1][0].c = 'Y';
    spawnpoints[1][0].row = rowcount;
    spawnpoints[1][0].col = colcount;
  }
}


//print the spawns of the player and the the killers onto the regular screen
void printSpawns(Point** spawnpoints, int* header)
{
  cout << "Player start: (" << spawnpoints[1][0].row << ',' << spawnpoints[1][0].col << ')' << endl;
  cout << "Spawn spots : ";
  for(int i = 0; i < header[2]; i++)
    cout << '(' << spawnpoints[0][i].row << ',' << spawnpoints[0][i].col << ')' << " ";
  cout << endl;
}
