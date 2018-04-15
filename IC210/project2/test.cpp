#include <iostream>
#include <string>

using namespace std;

int main()
{
  string test = "ABCDEFG";
  string check = test[0];
  cout << check << endl;
  check += test[1];
  cout << check << endl;
}
