#include "Pos.h"
#include "playermove.h"
#include "part4.h"



//initializes the killers
cMove* killerposition(int* header, Point** spawnpoints)
{
  //uses how many spawnpoints to make the array
  cMove* killers = new cMove[header[2]];
  for(int i = 0; i < header[2]; i++)
  {
    //puts them at their corresponding points
    equals(killers[i].curr, spawnpoints[0][i]);
    equals(killers[i].past, spawnpoints[0][i]);
    //stars them with a random direction
    int randDir = rand()%4;
    killers[i].dir = randDir;
  }
  return killers;
}


//movement for the killers
void killermovement(cMove* killers, int* header, Point** board, WINDOW* W, Pos player)
{
  for(int i = 0; i < header[2]; i++)
  {
    //used the infromation on the website to write this portion
    int dchange = rand()%2, cdchange = rand()%2;

    //this if statement determines the direction of the killers
    //so that they track the player
    if(dchange == 0)
    {
      int cdir, rdir;
      int dc = player.col - killers[i].curr.col;
      int dr = player.row - killers[i].curr.row;
      dc < 0 ? cdir = 3 : cdir = 1;
      dr < 0 ? rdir = 0 : rdir = 2;
      if(cdchange == 0)
        killers[i].dir = rdir;
      else
        killers[i].dir = cdir;
    }
    //after the direction is found then make them take a step in the direction and change current and
    //past positions
    killers[i].past = killers[i].curr;
    killers[i].curr = step(killers[i].curr, killers[i].dir);

    //detects if killer hits the wall
    killers[i].curr = walldetectaction(killers[i].curr, board, header, killers[i].dir, killers[i].past);

    //adds the killers to the screen
    addchar(W, killers[i].curr, 'K');
    clearchar(W, killers[i].past);
  }
}

void addchar(WINDOW* W, Point p)
{
  wmove(W, p.row, p.col);
  waddch(W, p.c);
}
