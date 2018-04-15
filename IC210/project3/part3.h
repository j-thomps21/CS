#include "playermove.h"
#ifndef PART3_H
#define PART3_H

//defines new struct which saves the current position along
//with the last position beforehand. also direction
struct cMove
{
  Pos curr, past;
  int dir;
};

cMove** starposition(int* header, Point** spawnpoints);
void starmovement(cMove** stars, int* header, Point** board, WINDOW* W);
int LeftorRight(int lr, cMove s);
void equals(Pos& a, Point b);
bool PlayerCharCollide(cMove**, Pos, Pos, int, int*, cMove*);
bool adjacentCollision(cMove, Pos, Pos, int);
#endif
