#ifndef PLAYERMOVE
#define PLAYERMOVE
#include "readboard.h"


void ncursestart(Point**, Point**, int*);
void playermovement(Point, int*, WINDOW*, bool&, Point**, Point, int&, Point**);
bool checkfinish(Pos, Point);
int kbcalc(int);
void addchar(WINDOW*, Pos, char);
void clearchar(WINDOW*, Pos);
Pos walldetectaction(Pos, Point**, int*, int&, Pos);
bool walldetect(Point**, Pos, int, int);
void revertPos(Pos&, int&);
void originalPos(Pos&, int&);
bool operator == (Pos a, Pos b);
bool operator != (Pos a, Pos b);
bool samepos(Pos, Pos);

#endif
