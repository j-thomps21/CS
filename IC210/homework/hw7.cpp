#include <iostream>
#include <string>
using namespace std;

int main()
{
  cout << "Time: ";
  int n;
  cin >> n;

  if ((n >= 0600) && (n <= 2300))
    cout << "Awake" << endl;
  else
  {
    if ((n < 0000) || (n > 2400))
      cout << "Not a real time!" << endl;
    else
      cout << "Asleep" << endl;
   }
  return 0;
}
