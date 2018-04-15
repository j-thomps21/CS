#include <iostream>
#include <string>
#include <cmath>

using namespace std;

struct fart
{
  int j;
  char c;
};

int main()
{
  fart* p = new fart[5];
  for(int i = 0; i < 5; i++)
  {
    p[i].j = i;
    p[i].c = i+'a';
  }

  cout << p->j << endl;
  return 0;
}
