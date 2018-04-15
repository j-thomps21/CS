#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void writefrac(int, int, int, ostream&, int, char);
int length(int k);
void printdash(int, ostream&);

int main()
{
  int n, d, dash, lsd;
  char n2, op, garb;
  ostream& os = cout; //could also be fstream variable

  cout << "Enter fraction: ";
  cin >> op;

  if (op == '-')
    cin >> n >> garb >> d;
  else
  {
    cin >> n2;
    if (n2 != '/')
    {
      cin >> garb >> d;
      n = ((op - '0')*10 + (n2 - '0'));
    }
    else
    {
      cin >> d;
      n = (op - '0');
    }
  }

  (n < d) ? lsd = 1 : lsd = 0;
  (n < d) ? dash = length(d) : dash = length(n);
  (n < d) ? writefrac(n, d, dash, os, lsd, op) : writefrac(d, n, dash, os, lsd, op);

  return 0;

}


void writefrac(int x, int y, int k, ostream& os, int lsd, char op)
{
  int width = length(x)/2;
  int space = (k / 2) - width;
  if(op != '-')
  {
    if (lsd == 1)
    {
      for(int i = 0; i < space; i++)
        os << ' ';

      os << x << endl;
      printdash(k, os);
      os << y << endl;
    }
    else
    {
      os << x << endl;
      printdash(k, os);
      for (int i = 0; i < space; i++)
        os << ' ';
      os << y << endl;
        os << ' ';
    }
  }
  else
  {
    if (lsd == 1)
    {
      for(int i = 0; i < space-1; i++)
        os << ' ';
      os << '-' << x << endl;
      printdash(k, os);
      os << y << endl;
    }
    else
    {
      os << x << endl;
      printdash(k, os);
      for (int i = 0; i < space-1; i++)
        os << ' ';
      os << '-' << y << endl;
     }
   }
}




int length(int k)
{
  int length, x, i;
  i = 0;
  for(; k != 0; i++)
  {
    k = k/10;
  }
  return i;
}


void printdash(int dash, ostream& os)
{
  for (int i = 0; i < dash; i++)
  {
    os << '-';
  }
  os << endl;
}
