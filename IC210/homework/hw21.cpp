#include <iostream>
#include <string>

using namespace std;

int main()
{
  cout << "Number of words: ";
  int n;
  cin >> n;
  string* a;
  a = new string[n];

  cout << "Sentence: ";

  for(int i = 0; i < n; i++)
  cin >> a[i];

  for(int ii = n -1; ii >= 0; ii--)
  cout << a[ii] << " ";

  cout << endl;

  return 0;
}
