#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;

string* getWords(istream& in, int k);

int main()
{
   ifstream fin("tmp.txt");
   string* A = getWords(fin, 10);

   for(int i = 0; i < 10; i++)
   {
     if ('a' <= A[i][0] && A[i][0] <= 'z')
       A[i][0] -= 32;
   }

   for(int i = 0; i < 10; i++)
     cout << A[i] << endl;
   return 0;
}


string* getWords(istream& in, int k)
{
   string* W = new string[k];
   while(--k >= 0 && in >> W[k]);
   return W;
}
