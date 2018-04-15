#include <iostream>
using namespace std;

int indexOfMin(int *A, int start, int end);
void sort(int* A, int N);
void swap(int& a, int& b);

int main()
{
  int* A = new int[5];
  A[0] = 1; A[1] = 7; A[2] = 3; A[3] = 5; A[4] = 10;

  sort(A, 5);

  for(int i=0; i < 5; i++)
    cout << A[i] << " ";
  cout << endl;

  return 0;
}

int indexOfMin(int *A, int start, int end)
{
  int imin = start;
  for(int i = start+1; i <= end; i++)
    if (A[imin] > A[i])
      imin = i;
  return imin;
}

void swap(int& a, int& b){ int t = b; b = a; a = t; }

// TO DO: define function sort()
void sort(int* A, int N)
{
  for(int length = 1; length <= N; length++)
      swap(A[length-1], A[indexOfMin(A, length - 1, N)]);
}
