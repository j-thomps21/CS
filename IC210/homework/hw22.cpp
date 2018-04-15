#include <iostream>

using namespace std;

int main()
{
  char N, op;
  int n;
  cin >> N >> op >> n;
  double *x, *y;
  x = new double[n];
  y = new double[n];

  for(int i = 0; i < n; i++)
  {
    cin >> op >> x[i] >> op >> y[i] >> op;
  }
  cout << "X := [";
  for (int i = 0; i < n; i++)
  {
    if(i == n-1)
    {
      cout << x[i];
      break;
    }
    cout << x[i] << ',' << " ";
  }
  cout << ']' << endl;

  cout << "Y := [";
  for (int i = 0; i < n; i++)
  {
    if(i == n-1)
    {
      cout << y[i];
      break;
    }
    cout << y[i] << ',' << " ";
  }
  cout << ']' << endl;

  return 0;
}
