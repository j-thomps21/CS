#include <iostream>

using namespace std;

int seconds(int, int, int);

int main()
{
  cout << "Enter first time: ";
  int t1m, t1h, t1s, t2s, t2h, t2m, diff, total1, total2;
  char garb;
  cin >> t1h >> garb >> t1m >> garb >> t1s;
  cout << "Enter second time: ";

  cin >> t2h >> garb >> t2m >> garb >> t2s;

  total1 = seconds(t1h, t1m, t1s);
  total2 = seconds(t2h, t2m, t2s);

  diff = total2 - total1;
    
  cout << "Ellapsed time is " << diff << " seconds" << endl;
  return 0;
}



int seconds(int x, int y, int z)
{
  x = x*60*60;
  y = y*60;
  int total = x + y + z;

  return total;
}
