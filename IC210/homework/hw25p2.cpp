#include <iostream>
using namespace std;

double pow(double, int);

int main()
{
  double x;
  int n;
  cout << "Enter x: ";
  cin >> x;
  cout << "Enter n: ";
  cin >> n;
  double xn = pow(x,n);
  cout << "x^n is " << xn << endl;
  return 0;
}

double pow(double x, int n)
{
  if( n == 1 )
  return x;

  double next = pow(x, n - 1);
  double ans = next * (x);
  return ans;
}
