#include <iostream>

using namespace std;

int square(int n);
int add(int p, int q);

int main()
{
  cout << "Enter x: ";
  int x, sum;
  cin >> x;
  sum = 0;
  int g = x;
  x = 0;

  for (; sum < g; x++)
  {
    sum = (square(x+1) + sum);
  }

  cout << "The sum of the first " << x << " squared numbers is " << sum <<
  ", which is the first greater than " << g << endl;
  return 0;
}


int square(int n)
{
  int a;
  a = n*n;
  return a;
}

int add(int p, int q)
{
 q = q + p;
 return q;
}
