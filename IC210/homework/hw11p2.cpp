#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  int w, x, y, z;
  x = 0;
  y = 0;
  z = -1;
  w = 0;
  char A;
  A = 1;

  for (cin >> A; A != 92; cin >> A)
  {
     (A >= 65 && A <= 90 ? w = w + 1 : w = w + 0);

     (A >= 97 && A <= 122 ? x = x + 1 : x = x + 0);

     (A >= 48 && A <= 57 ? y = y + 1 : y = y + 0);

     (A != 92 ? z = z + 1 : z = z + 0);
  }
  if (x > 1 && y > 1 && z > 1 && w > 1)
      cout << "pass" << endl;
  else
      cout << "fail" << endl;

  return 0;
}
