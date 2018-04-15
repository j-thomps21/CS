#include <iostream>
#include <string>
#include <fstream>

using namespace std;
struct NameScore
{
  string first, last;
  int score;
};

int* indexNames(NameScore*, int, int&);
void getData(istream&, NameScore*, int);
void namesort(NameScore*, int);
void scoresort(NameScore*, int);
bool beforename(string, string, string, string);
bool beforescore(int, int);
void print(NameScore**, int, int*);
NameScore** Created2D(NameScore*, int, int*, int);

int main()
{
  string filename;
  cin >> filename;
  ifstream fin(filename.c_str());
  int n, namecount;
  fin >> n;

  NameScore* A = new NameScore[n];
  getData(fin, A, n);
  namesort(A, n);
  int* names = indexNames(A, n, namecount);
  NameScore** X = Created2D(A, n, names, namecount);
  for(int i = 0; i < namecount; i++)
  {
    scoresort(X[i], names[i]);
  }
  print(X, namecount, names);
  return 0;
}


void getData(istream& fin, NameScore* A, int n)
{
  for(int i = 0; i < n; i++)
  {
    fin >> A[i].first >> A[i].last >> A[i].score;
  }
}


void namesort(NameScore* A, int n)
{
  for(int length = n; length > 1; length--)
  {
    int imax = 0, i;
    for(i = 1; i < length; i++)
      if(beforename(A[imax].last, A[i].last, A[imax].first, A[i].first))
        imax = i;

    NameScore t = A[imax];
    A[imax] = A[length-1];
    A[length-1] = t;
  }
}


int* indexNames(NameScore* A, int n, int& a)
{
  int* nameamount = new int[n];
  a = 0;
  int i, count = 1;
  string temp = A[0].first + " " + A[0].last;
  for(i = 1; i < n; i++)
  {
    if((A[i].first + " " + A[i].last) != temp)
    {
      temp = A[i].first + " " + A[i].last;
      nameamount[a] = count;
      a++;
      count = 0;
    }
    if(i == n-1)
    {
      count++;
      nameamount[a] = count;
      a++;
    }
    count++;
  }
  return nameamount;
}


bool beforename(string maxlast, string ilast, string maxfirst, string ifirst)
{
  if (maxlast == ilast)
    return maxfirst >= ifirst;
  else
    return maxlast > ilast;
}

NameScore** scoresort(NameScore* A, int n, int* names, int nc)
{
  NameScore** final = new NameScore*[nc-1];

}




void scoresort(NameScore* A, int n)
{
  for(int length = n; length > 1; length--)
  {
    int imax = 0, i;
    for(i = 1; i < length; i++)
      if(beforescore(A[imax].score, A[i].score))
        imax = i;

    NameScore t = A[imax];
    A[imax] = A[length-1];
    A[length-1] = t;
  }
}


bool beforescore(int a, int b)
{
  return a >= b;
}


void print(NameScore** X, int n, int* names)
{
  for(int i = 0; i < n; i++)
  {
    for(int j = 0; j < names[i]; j++)
    {
      cout << X[i][j].first << " " <<  X[i][j].last << " " << X[i][j].score << endl;
    }
  }
}


NameScore** Created2D(NameScore* A, int n, int* names, int nc)
{
  NameScore** final = new NameScore*[nc-1];
  int counter = 0;
  for(int i = 0; i < nc; i++)
  {
    final[i] = new NameScore[names[i]];
    for(int j = 0; j < names[i]; j++)
    {
      final[i][j] = A[counter];
      counter++;
    }
  }
    return final;
}
