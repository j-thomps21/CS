#include <iostream>
#include <fstream>
#include <string>
#include <cmath>

using namespace std;

int main()
{
  string filename, names, garbage1, garbage2, garbage3, garbage4;
  cout << "Enter a filename: ";
  cin >> filename;
  ifstream fin(filename.c_str());
  double x, y, z, AVG;
  fin >> garbage1 >> garbage2 >> garbage3 >> garbage4;
  fin >> names >> x >> y >> z;
  while (fin)
  {
      AVG = (x*.20) + (y*.20) + (z*.60);
      cout << names <<"   "<< AVG << endl;
      AVG = 0;
      fin >> names >> x >> y >> z;

  }
return 0;
}
