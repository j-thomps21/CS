#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  string filename, tr, etr, td, etd, table, etable;
  int row, col, n;
  cout << "Enter a file name: ";
  cin >> filename;

  ifstream fin(filename.c_str());
  ofstream fout("output.html");
  fin >> row;
  fin >> col;
  if (!fin)
  {
    cout << "This shit doesnt work!!" << endl;
    return 0;
  }

  fout << "<table border=2>" << endl;

  for (int i = 0; i < row; i++)
  {
    fout << "<tr>";
     for (int ii=0; ii < col; ii++)
     {
      fout << "<td>";
      fin >> n;
      fout << n << "<//td>";
     }
     fout << "<//tr>" << endl;
   }
    fout << "<//table>" << endl;
return 0;
}
