#include <iostream>
#include <cmath>
using namespace std;

int main()
{
  int n1, n2, k, x;
  cout <<"Enter two intergers: ";
  cin >> n1 >> n2;
  k = 1;
  x = n1;

  while (n1 <= n2)
    {
      k = k * n1;
      n1 = n1 + 1;
    }

  cout << "Product of all intergers from "<<x <<" to "<<n2
  <<" is "<< k<< endl;

  return 0;
}
