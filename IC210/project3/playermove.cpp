#include "Pos.h"
#include "playermove.h"
#include "part3.h"
#include "part4.h"


//starts the ncurses for the entire program. Uses function from the readboard.cpp file
void ncursestart(Point** spawnpoints, Point** board, int* header)
{
  int rounds = 0;
  bool checkfinish = false;

  //initializes ncurses
  WINDOW* W = initscr();

  //shows the board to the screen
  showBoard(board, header, W);
  Point player = spawnpoints[1][0];

  //starts the movement of the player and other objects
  playermovement(player, header, W, checkfinish, board, spawnpoints[2][0], rounds, spawnpoints);
  //if the checkfinish variable is true, then the player has reached the end and exits the game
  if(checkfinish == true)
  {
    endwin();
    cout << "You won, high score " << 500-rounds << endl;
    return;
  }
  //if false, then the player was killed and exits with this message
  else if(checkfinish == false)
  {
    endwin();
    cout << "You lost, they got you!" << endl;
    return;
  }
  /*
  do {
    usleep(150000);
    char c = wgetch(W);
    if (c == 'y') break;
  } while(true);
  */
  endwin();
  return;
}

//this function allows the movement of all objects in the game from the player to the killers
void playermovement(Point player, int* header, WINDOW* W, bool& check, Point** board, Point X, int& rounds, Point** spawnpoints)
{
  //initializes variables like keypress variable, direction, direction history and the firstpress variable
  int kb, dir = 4, firstpress = 0, dirhist = 4;
  Pos playerpos;
  playerpos.row = player.row; playerpos.col = player.col;

  //initializes the stars and killers
  cMove** stars = starposition(header, spawnpoints);
  cMove* killers = killerposition(header, spawnpoints);

  //this is the meat of the function. Here the original position of the player is saved for a round
  //which is used for hit detection with walls, killers, and stars
  do {
    Pos oldpos = playerpos;

    //gets keypress
    kb = wgetch(W);
    if(kb != ERR)
    {
      //calculates the direction
      dir = kbcalc(kb);
      dirhist = dir;
      playerpos = step(playerpos, dir);

      firstpress = 1;
    }
    else
      //automoves the player if there is no keypress detected
      playerpos = step(playerpos, dirhist);

    //checks if the players has hit a wall
    playerpos = walldetectaction(playerpos, board, header, dirhist, oldpos);
    addchar(W, playerpos, 'P');

    //moves the stars and killers one round
    starmovement(stars, header, board, W);
    killermovement(killers, header, board, W, playerpos);

    //adds an X in case a star goes over and clears it
    addchar(W, X);

    //if a collision between a player and star or killer is  detected then end game
    if (PlayerCharCollide(stars, playerpos, oldpos, dirhist, header, killers) == true)
    {
      cerr << "they got you!!" << endl;
      check = false;
      return;
    }

    //if the player hasnt pressed a key yet, then dont clear the player
    //char from the screen
    if (firstpress == 1 && !samepos(playerpos, oldpos))
    {
      clearchar(W, oldpos);
      rounds++;
    }
    //exits if y is pressed
    if(kb == 'y')
    {
      endwin();
      return;
    }

    wrefresh(W);
    usleep(100000);
  } while(checkfinish(playerpos, X) == false);
  check = true;
}

//checks if the player has reached the finish
bool checkfinish(Pos p, Point X)
{
  Pos x; x.row = X.row; x.col = X.col;
  if(dist(p, x) <= 1)
    return true;
  else return false;
}


//calculates the direction
int kbcalc(int kb)
{
  if (kb == 'a' || kb == KEY_LEFT)
    return 3;
  else if(kb == 's' || kb == KEY_DOWN)
    return 2;
  else if(kb == 'd' || kb == KEY_RIGHT)
    return 1;
  else if(kb == 'w' || kb == KEY_UP)
    return 0;
  else if(kb == 'r')
    return 4;
}

//addchar to the screen
void addchar(WINDOW* W, Pos p, char c)
{
  wmove(W, p.row, p.col);
  waddch(W, c);
}

//clears the char from the screen
void clearchar(WINDOW* W, Pos p)
{
  wmove(W, p.row, p.col);
  waddch(W, ' ');
}

//if a player, star or killer hits the wall then take appropriate action
Pos walldetectaction(Pos p, Point** board, int* header, int& dirhist, Pos op)
{
  bool check = false;

  //if a wall is detected then revertPos
  if(walldetect(board, p, header[0], header[1]) == true)
  {
    revertPos(p, dirhist);
    //if a wall is still detected, then return the character to original position
    if(walldetect(board, p, header[0], header[1]) == true)
    {
      return op;
    }
    return p;
  }
  else
    return p;
}

//actually detects if the player has hit the wall
bool walldetect(Point** board, Pos p, int trows, int tcols)
{
  //just uses a for loop to check every point if the player has hit a point that
  //has a '#' character
  for(int i = 0; i < trows; i++)
  {
    for(int j = 0; j < tcols; j++)
    {
      if(board[i][j].c == ' ') continue;
      else if(p.row == board[i][j].row && p.col == board[i][j].col && board[i][j].c == '#')
        return true;
    }
  }
  return false;
}


//just checks if two points are at the same position
bool samepos(Pos a, Pos b)
{
  if(a.row == b.row && a.col == b.col)
    return true;
  else return false;
}

//turns the character 180 and takes two steps in the direction
void revertPos(Pos& p, int& dirhist)
{
  dirhist = turn(dirhist, 180);
  p = step(p, dirhist);
  p = step(p, dirhist);
}

//reverts to original position
void originalPos(Pos& p, int& dirhist)
{
  dirhist = turn(dirhist, 180);
  p = step(p, dirhist);
}

bool operator == (Pos a, Pos b)
{
  if(a.col == b.col && a.row == b.row)
    return true;
  else return false;
}

bool operator != (Pos a, Pos b)
{
  if(a.col != b.col && a.row != b.row)
    return true;
  else return false;
}
