#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  cout << "Enter a fraction additional problem: ";
  int x1, x2, y1, y2, z1, z2, r, w1, w2;
  char A, B, C, D;
  cin >> x1 >> A >> y1 >> B >> x2 >> C >> y2;
  z1 = ((x1 * y2) + (x2 * y1));
  z2 = y1 * y2;
  w1 = z1;
  w2 = z2;
  D = '=';

  if (z1 < z2)
  {
    r = z2%z1;
    while (r > 0)
    {
      z2 = z1;
      z1 = r;
      r = z2%z1;
    }
    w1 = w1 / z1;
    w2 = w2 / z1;
    cout << x1 << A << y1 << " " << B << " " << x2 << C << y2
    << " " << D << " " << w1 << A << w2 << endl;
  }
  else
  {
    r = z1%z2;
    while (r > 0)
    {
      z1 = z2;
      z2 = r;
      r = z1%z2;
    }
    w1 = w1 / z2;
    w2 = w2 / z2;
    cout << x1 << A << y1 << " " << B << " " << x2 << C << y2
    << " " << D << " " << w1 << A << w2 << endl;
  }
  return 0;
}
