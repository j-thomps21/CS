#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  string filename, P3, grayfilename;
  int x, y, z, a, b, c, avg, AA, BB, CC, xx, yy, zz;
  cout << "Input file: ";
  cin >> filename;
  cout << "Output file: ";
  cin >> grayfilename;
  ifstream fin(filename.c_str());
  AA = 1280; BB = 960; CC = 255;

  fin >> P3 >> x >> y >> z;
  if (fin)
    {
     ofstream fout(grayfilename.c_str());
     fout << P3.c_str() << endl << AA << " "<< BB << endl << CC << endl;

      for (fin >> xx >> yy >> zz; fin; fin >> xx >> yy >> zz)
       {
       avg = (xx + yy + zz)/3;
       a = avg; b = avg; c = avg;
       fout << a << " "<< b<< " " << c << " ";
     }
    }
  else
    {
     cout << "Error: Input file not found" << endl;
     return 0;
    }
  cout << "Image saved to "<< grayfilename << endl;
return 0;
}
