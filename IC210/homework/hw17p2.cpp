#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int gcd(int denom, int num);

int main()
{
  int d, n;
  char op;

  while (cin >> n >> op >> d >> op)
  {
      int a = gcd(d,n);
      if (a > 1)
      {
        cout << n << "/" << d << " is not in lowest terms!" << endl;
      }
      if (op == ';')
      return 0;
  }





  return 0;
}


int gcd(int denom, int num)
{

    int a = (denom < num ? num : denom);
    int b = (denom < num ? denom : num);

    for (int i = 0; b != 0; i++)
    {
      int r = a % b;
      a = b;
      b = r;
    }
  return a;
}
