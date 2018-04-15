#include <iostream>
#include <string>
using namespace std;

//============================================================
// prototypes
// c: input character,  n: shift amount
char shift(char c, int n);

// w: input string,  n: shift amount
string shift(string w, int n);

//============================================================
// main function: I already wrote the easy part for you.
int main()
{
  // get a shift value from the user
  int n;
  cout << "Enter a shift value: ";
  cin >> n;

  // get a plaintext message from the user
  string s;
  cout << "Enter a plaintext message (lower-case letters only): ";
  cin >> s;

  // shift cipher!!
  cout << shift(s,n) << endl;
}

//============================================================
// function definitions
char shift(char c, int n)
{
  for(int i = n; i != 0; i--)
  {
    c++;
    if (c > 'z')
     c = 'a';
  }
  return c;
}

string shift(string w, int n)
{
  for(int i = 0; i < w.length(); i++)
  {
    char c = w[i];
    c = shift(c,n);
    w[i] = c;
  }
  return w;
}
