#include "readboard.h"

int main()
{
  srand(time(0));
  //Ask for file and read in the information
  ifstream readB(getFile().c_str());
  int* header = new int[4];
  header[3] = 0;

  //stores the infromation
  Point** spawnpoints = new Point*[3];
  Point** points = storeinfo(readB, header, spawnpoints);
  printSpawns(spawnpoints, header);

  //starts ncurses
  string command;
  do {
  ncursestart(spawnpoints, points, header);
  //if the player wants to play the same board again then type again
  }while(cin >> command && command == "again");
  return 0;
}
