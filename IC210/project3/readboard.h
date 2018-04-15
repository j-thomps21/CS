#ifndef READBOARD
#define READBOARD
#include <iostream>
#include <string>
#include <fstream>
#include <unistd.h>
#include <cstdlib>
#include <curses.h>
#include <cmath>



using namespace std;

//point struct that saves position along with character
struct Point
{
  int row, col;
  char c;
};



string getFile();
Point** storeinfo(ifstream&, int*, Point**);
void showBoard(Point** points, int* header, WINDOW*);
void ChangeChar(Point**, Point**, int*, int, char);
void printSpawns(Point**, int*);
void ncursestart(Point**, Point**, int*);
#endif
