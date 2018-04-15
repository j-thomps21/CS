#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  int i, W, X, Y;
  W = 0;
  X = 0;
  Y = -1;
  char A;
  A = 1;

  while (A != 92)
  {
    if (A >= 65 && A <= 90)
     {
       W = W + 1;
       cin >> A;
     }
    else if (A >= 97 && A <= 122)
     {
       X = X + 1;
       cin >> A;
     }
    else if (A != 92)
     {
       Y = Y + 1;
       cin >> A;
     }
  }
  if (W > 1 && X > 1 && Y > 1)
      cout << "pass" << endl;
  else
      cout << "fail" << endl;

  return 0;
}










  /*for (cin >> A; cin >> A; cin >> A)
  {
    if (A >= 65 && A <= 90)
      W = W + 1;
    else if (A >= 97 && A <= 122)
      X = X + 1;
    else if (A != 92)
      Y = Y + 1;
    else if (W >= 2 && X >= 2 && Y >= 2)
      cout << "pass" << endl;
    else
      cout << "fail" << endl;
  }*/
