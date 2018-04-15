// hw2.cpp
#include "vector.h"

int main()
{
  char c;
  Vector x, y, z;
  cin >> c >> c >> x
      >> c >> c >> y
      >> c >> c >> z;

  cout << "X-Y+Z = " << x-y+z << endl;

  return 0;
}
