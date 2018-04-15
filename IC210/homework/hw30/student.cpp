#include "student.h"

Student* readfile(int& n)
{
  string filename, garb;
  cout << "File name: ";
  cin >> filename;
  ifstream fin(filename.c_str());
  int nh;
  fin >> n >> garb >> nh >> garb;
  Student* stu = new Student[n];

  for(int i = 0; i < n; i++)
  {
    fin >> stu[i].first >> stu[i].last;
    stu[i].hwNum = nh;
    stu[i].hw = new int[nh];
    for(int j = 0; j < nh; j++)
    {
      fin >> stu[i].hw[j];
    }
  }

  average(stu, n);

  return stu;
}


void average(Student* stu, int n)
{
  for(int i = 0; i < n; i++)
  {
    double sum = 0;
    for(int j = 0; j < stu[i].hwNum; j++)
    {
      sum += stu[i].hw[j];
    }
    stu[i].avg = sum/stu[i].hwNum;
  }
}


void sort(Student* A, int N)
{
  for(int length = N; length > 1; length--)
 {
   // Find imax, the index of the largest
   int imax = 0, i;
   for(i = 1; i < length; i++)
     if (before(A[imax].avg,A[i].avg))
       imax = i;

   // Swap A[imax] and the last element
   Student temp = A[imax];
   A[imax] = A[length - 1];
   A[length - 1] = temp;
 }
}

bool before(double a, double b)
{
  return a < b;
}

void print(Student* stu, int n)
{
  for(int i = 0; i < n; i++)
  {
    cout << stu[i].first << " " << stu[i].last << " " << "avg="
    << stu[i].avg << " ";
    for(int j = 0; j < stu[i].hwNum; j++)
      cout << stu[i].hw[j] << " ";
    cout << endl;
  }
}
