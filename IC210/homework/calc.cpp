#include <iostream>
using namespace std;

int main()
{
  cout << "Enter an expression: ";

  int total, k;
  char op;
  total = 0;
  op = '+';

  // Loop
  while(op != '=')
  {
    // read next value
    cin >> k;

    // add or subtract value from total
    if (op == '+')
      total = total + k;
    else
      total = total - k;

    // read next op
    cin >> op;
  }

  // Write result
  cout << total << endl;

  return 0;
}
