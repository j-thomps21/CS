// hw.cpp
#include "student.h"

int main()
{
  int n = 0;

  Student* stu = readfile(n);

  sort(stu, n);

  print(stu, n);

  return 0;
}
