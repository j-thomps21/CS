#include <iostream>
#include <fstream>

using namespace std;

int main()
{
  ifstream fin("in.txt");
  ofstream fout("out.txt");

  int n;
  while(fin>>n)
  {
    fout << n << " ";
  }
  fout << endl;

  return 0;
}
