#include <iostream>
#include <string>

using namespace std;

int main()
{
  char star = '*';
  char space = ' ';
  int h, w, off;
  int i, ii, iii;
  cout << "Enter height (greater than 2): ";
  cin >> h;
  cout << "Enter width  (greater than 2): ";
  cin >> w;
  cout << "Enter offset: ";
  cin >> off;




  for (iii = 0; iii < h; iii++)
    {
     cout << endl;
  for (i = 0; i < off; i++)
     cout << space;

  for (ii = 0; ii < w; ii++)
      {
       if (iii == 0 || iii == h-1 )
          cout << star;
       else if (ii == 0 || ii == w-1)
         cout << star;
       else
         cout << space;
      }
    }
     cout << endl;

  return 0;
}
