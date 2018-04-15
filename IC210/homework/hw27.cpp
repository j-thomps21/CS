#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int** getgrades(istream&, int&, int&);
void selectionsort(int** grades, int students, int assignments, double* averages);
double average(int**, int, int);
double average2(int*, int);
bool before(double, double);
void swap(int*& a, int*& b);
void swap(double*, int, int);
int indexOfMax(double*, int, int);
void print(int**, int, int);
double* avgArray(int** grades, int students, int assignments);

int main()
{
  string filename;
  cout << "File name: ";
  cin >> filename;
  int students = 0, assignments = 0;
  ifstream fin(filename.c_str());

  int** grades = getgrades(fin, students, assignments);
  double* averages = avgArray(grades, students, assignments);
  selectionsort(grades, students, assignments, averages);

  //for(int i = 0; i < students; i++)
    //cout << averages[i] << endl;

  print(grades, students, assignments);
}


int** getgrades(istream& fin, int& students, int& assignments)
{
  string garb;
  fin >> students >> garb >> assignments >> garb;
  int** grades = new int*[students];
  for(int i = 0; i < students; i++)
    {
      grades[i] = new int[assignments];
      for(int j = 0; j < assignments; j++)
        fin >> grades[i][j];
    }
  return grades;
}


void selectionsort(int** grades, int students, int assignments, double* averages)
{
  for(int i = students; i > 1; i--)
  {
    int imax = indexOfMax(averages, i, assignments);
    swap(averages, imax, i-1);
    swap(grades[imax], grades[i-1]);
  }
}

void swap(double* averages, int a, int b)
{
  double t = averages[a];
  averages[a] = averages[b];
  averages[b] = t;
}

void swap(int*& a, int*& b)
{
  int* temp = a;
  a = b;
  b = temp;
}


double average(int** grades, int index, int assignments)
{
  double sum = 0;
  for(int i = 0; i < assignments; i++)
    sum += grades[index][i];
  double average = sum/assignments;
  return average;
}

int indexOfMax(double* averages, int n, int assignments)
{
  int imax = 0, i;
  for(i = 1; i < n; i++)
    if (before(averages[imax], averages[i]))
      imax = i;

  return imax;
}


bool before(double a, double b)
{
  return a > b;
}

double average2(int* a, int n)
{
  double sum = 0;
  for(int i = 0; i < n; i++)
    sum += a[i];
  double avg = sum/n;
  return avg;
}

void print(int** grades, int students, int assignments)
{
  for(int i = 0; i < students; i++)
  {
    double avg = average(grades, i, assignments);
    for(int j = 0; j < assignments; j++)
    {
      cout << grades[i][j] << " ";
    }
    cout << "ave = " << avg << endl;
  }
}

double* avgArray(int** grades, int students, int assignments)
{
  double* averages = new double[students];

  for(int i = 0; i < students; i++)
  {
    averages[i] = average(grades, i, assignments);
  }
  return averages;
}
