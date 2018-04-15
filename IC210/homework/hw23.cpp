#include <iostream>
#include <string>
using namespace std;

void crossOut(char, string*, int);
string* cloneArray(string*, int);
int main()
{
  // receive a letter to cross out
  char c;
  cout << "Letter to cross out: ";
  cin >> c;

  // how many words to read?
  int n;
  cout << "How many words? ";
  cin >> n;

  // read the actual n words from the input
  string* arrWords = new string[n];
  for(int i=0; i < n; i++)
    cin >> arrWords[i];

  // ***** DECLARE AND DEFINE: cloneArray
  // clone the array arrWords to arrCrossout
  // arrCrossout is used right below

  string* arrCrossout = cloneArray(arrWords, n);

  // ***** DECLARE AND DEFINE: crossOut
  // Crossout!

  crossOut(c, arrCrossout, n);

  // Print out the results

  for(int i=0; i < n; i++)
    cout << arrWords[i] << " --> " << arrCrossout[i] << endl;

  return 0;
}


string* cloneArray(string* arrWords, int n)
{
  string* clone = new string[n];

  for(int i = 0; i < n; i++)
  {
    clone[i] = arrWords[i];
  }
  return clone;
}


void crossOut(char c, string* narray, int n)
{
  for(int i = 0; i < n; i++)
  {
    string tempstring = narray[i];
    for(int ii = 0; ii < tempstring.length(); ii++)
    {
      if (tempstring[ii] == c)
      tempstring[ii] = '*';
    }
    narray[i] = tempstring;
  }
}
