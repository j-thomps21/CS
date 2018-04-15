#include "Pos.h"
#include "playermove.h"
#include "part3.h"


//intitializes the stars with new cMove type.
cMove** starposition(int* header, Point** spawnpoints)
{
  //uses 2D array for how many spawns and how many stars at each point
  cMove** stars = new cMove*[header[2]];
  for(int i = 0; i < header[2]; i++)
  {
    stars[i] = new cMove[5];
    for(int j = 0; j < 5; j++)
    {
      equals(stars[i][j].curr, spawnpoints[0][i]);
      equals(stars[i][j].past, spawnpoints[0][i]);
      int randDir = rand()%4;
      stars[i][j].dir = randDir;
    }
  }
  return stars;
}


//moves the stars
void starmovement(cMove** stars, int* header, Point** board, WINDOW* W)
{
  for(int i = 0; i < header[2]; i++)
  {
    for(int j = 0; j < 5; j++)
    {
      //random movement of the star
      int dchange = rand()%10;
      if(dchange == 0)
      {
        int lr = rand()%2;
        stars[i][j].dir = LeftorRight(lr, stars[i][j]);
      }
      stars[i][j].past = stars[i][j].curr;
      stars[i][j].curr = step(stars[i][j].curr, stars[i][j].dir);

      //detects if the star has hit the wall and takes appropriate action
      stars[i][j].curr = walldetectaction(stars[i][j].curr, board, header, stars[i][j].dir, stars[i][j].past);

      //adds the char to the screen
      addchar(W, stars[i][j].curr, '*');
      clearchar(W, stars[i][j].past);
    }
  }
}

//turs the star left or right
int LeftorRight(int lr, cMove s)
{
  if(lr == 0)
    return turn(s.dir, 90);
  else
    return turn(s.dir, -90);
}

//function to make equaling points and pos types easier
void equals(Pos& a, Point b)
{
  a.row = b.row;
  a.col = b.col;
}

//detects if the player and a star or killer collides
bool PlayerCharCollide(cMove** stars, Pos player, Pos oldpos, int pdir, int* header, cMove* killers)
{
  for(int i = 0; i < header[2]; i++)
  {
    for(int j = 0; j < 5; j++)
    {
      //if same position then true
      if(samepos(stars[i][j].curr, player) == true)
        return true;
      //if they satisfy the adjacent situation then true
      else if(adjacentCollision(stars[i][j], player, oldpos, pdir) == true)
        return true;
    }

    if(samepos(killers[i].curr, player) == true)
      return true;
    else if(adjacentCollision(killers[i], player, oldpos, pdir) == true)
      return true;
  }
  return false;
}

//adjacent situation for collision
bool adjacentCollision(cMove StarKiller, Pos curr, Pos past, int pdir)
{
  if(dist(StarKiller.curr, curr) == 1 && dist(StarKiller.past, past) == 1 && StarKiller.dir == turn(pdir, 180))
    return true;
  else return false;
}
