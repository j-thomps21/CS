#include <iostream>
#include <string>

using namespace std;

void printNumbers(int start, int n);

int main()
{
  // Read in the parameter n
  int n;
  cout << "Enter value n, where n < 50: ";
  cin >> n;

  // Write Hankel matrix 1,...,2*n
  for(int row = 1; row <= n; row++)
  {
    printNumbers(row , n);
    cout << endl;
  }

  return 0;
}


void printNumbers(int start, int n)
{
  for(int i=0; i < n; i++)
  {
    int m = start + i;
    if ( m < 10 )
      cout << " ";
    cout << m << " ";
  }
  cout << endl;
}
