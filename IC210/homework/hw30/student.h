#include <iostream>
#include <string>
#include <fstream>

using namespace std;

struct Student
{
  string first, last;
  double avg;
  int* hw;
  int hwNum;
};

Student* readfile(int&);
void sort(Student*, int);
void print(Student*, int);
void average(Student*, int);
bool before(double, double);
