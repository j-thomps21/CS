#include <iostream>
#include <string>

using namespace std;

string to_string(int v);

int main()
{
  int n;
  cout << "How many cards? ";
  cin >> n;

  cout << "Enter card values: ";
  int* cards = new int[n];
  for(int i=0; i < n; i++)
    cin >> cards[i];

  for(int i=0; i < n; i++)
    cout << to_string(cards[i]) << "  ";
  cout << endl;

  return 0;
}

string to_string(int v)
{
  // note: clubs="\u2663", diamonds="\u2666",
  //       hearts="\u2665", spades="\u2660"
  // initialize the suits
  string suits[5] = {" ", "\u2663", "\u2666", "\u2665", "\u2660"};

  // initialize the faces
  string faces[15] = {"  ", "  ", " 2", " 3", " 4",
                      " 5", " 6", " 7", " 8", " 9",
                      "10", " J", " Q", " K", " A"};

  return faces[v % 100] + suits[v / 100] ;
}
