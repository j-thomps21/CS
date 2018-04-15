  #include "playermove.h"

void ncursestart(Point** spawnpoints, Point** board, int* header)
{
  bool checkfinish = false;
  WINDOW* W = initscr();
  showBoard(board, header, W);
  cerr << "Onto playermovement function " << endl;
  playermovement(spawnpoints, header, W, checkfinish, board);
  if(checkfinish == true)
  {
    endwin();
    return;
  }
  do {
    usleep(150000);
    char c = wgetch(W);
    if (c == 'y') break;
  } while(true);

  endwin();
  return;
}


void playermovement(Point** spawnpoints, int* header, WINDOW* W, bool& check, Point** board)
{
  int temprow = 0, tempcol = 0, kbhist = 0;
  Point* playerunit = new Point;
  playerunit->row = spawnpoints[1][0].row;
  playerunit->col = spawnpoints[1][0].col;
  int kb, rounds = 0, firstpress = 0;

  do  {
    //REMEMBER THAT 0 MEANS THE PLAYER STOPS MOVING

    kb = wgetch(W);
    if (kb != ERR)
    {
      keypress(playerunit, kb);
      kbhist = kb;
      firstpress = 1;
    }
    else
      automove(playerunit, kbhist);

    walldetect(board, playerunit, header, kbhist, kb);
    addchar(W, playerunit, 'P');
    if (firstpress == 1 && kbhist !=0 ) clearchar(W, temprow, tempcol);

    cerr << "KB: " << kb << "  kbhist: " << kbhist << endl;

    temprow = playerunit->row;
    tempcol = playerunit->col;
    if(kb == 'y')
    {
      endwin();
      return;
    }

    wrefresh(W);
    usleep(100000);

  } while(!checkfinish(playerunit[0],spawnpoints[2][0]));

  check = true;
}

void keypress(Point* playerunit, int& kb)
{
  if(kb == 'a')
    playerunit->col--;
  else if(kb == 'w')
    playerunit->row--;
  else if(kb == 's')
    playerunit->row++;
  else if(kb == 'd')
    playerunit->col++;
  else if(kb == 'r')
    kb = 0;
}

bool checkfinish(Point player, Point X)
{
  if (player.row == X.row-1 || player.row == X.row || player.row == X.row-1)
  {
    if(player.col == X.col-1 || player.col == X.col+1)
      return true;
  }
  else if (player.col == X.col-1 || player.col == X.col || player.col == X.col-1)
  {
    if(player.row == X.row-1 || player.row == X.row+1)
      return true;
  }
  else return false;
}

void automove(Point* player, int kbhist)
{
  if(kbhist == 0)
    return;
  else if(kbhist == 'a')
    player->col--;
  else if(kbhist == 'w')
    player->row--;
  else if(kbhist == 's')
    player->row++;
  else if(kbhist == 'd')
    player->col++;
  else return;
}

void addchar(WINDOW* W, Point* unit, char c)
{
  wmove(W, unit->row, unit->col);
  waddch(W, c);
}

void clearchar(WINDOW* W, int row, int col)
{
  wmove(W, row, col);
  waddch(W, ' ');
}

void walldetect(Point** board, Point* player, int* header, int& kbhist, int& kb)
{
  int tempcol = player->col, temprow = player->row;
  bool check = false;
  for(int i = 0; i < header[0]; i++)
  {
    for(int j = 0; j < header[1]; j++)
    {
      if(board[i][j].c == ' ') continue;
      else if(player->row == board[i][j].row && player->col == board[i][j].col && board[i][j].c == '#')
      {
        movebacktwo(kbhist, player);
        check = true;
        break;
      }
    }
    if(check == true) break;
  }

  int row = player->row, col = player->col;
  if(player->row == board[row][col].row && player->col == board[row][col].col && board[row][col].c == '#')
      stopPlayer(kbhist, player, kb);
  else if(board[row][col].row == ERR || board[row][col].col == ERR)
      stopPlayer(kbhist, player, kb);
}

void movebacktwo(int& kbhist, Point* player)
{
  if(kbhist == 'a')
  {
    player->col+=2;
    kbhist = 'd';
  }
  else if(kbhist == 'w')
  {
    player->row+=2;
    kbhist = 's';
  }
  else if(kbhist == 's')
  {
    player->row-=2;
    kbhist = 'w';
  }
  else if(kbhist == 'd')
  {
    player->col-=2;
    kbhist = 'a';
  }
}

void stopPlayer(int& kbhist, Point* player, int& kb)
{
  if(kbhist == 'a')
    player->col--;
  else if(kbhist == 'w')
    player->row--;
  else if(kbhist == 's')
    player->row++;
  else if(kbhist == 'd')
    player->col++;

  kbhist = 0;
  kb = 0;
}

//void randomMove()
{

}
