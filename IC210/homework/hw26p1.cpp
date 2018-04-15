#include <iostream>
using namespace std;

void selectionsort(int* A, int N);
int indexOfMax(int* A, int N);
void swap(int& a, int& b);
bool before(int a, int b);

int main()
{
  int* A = new int[10];
  for(int i=0; i < 10; i++)
    cin >> A[i];

  selectionsort(A, 10);

  for(int i=0; i < 10; i++)
    cout << A[i] << " ";
  cout << endl;
  return 0;
}

void selectionsort(int *A, int N)
{
  for(int length = N; length > 1; length--)
    swap(A[indexOfMax(A,length)], A[length-1]);
}

int indexOfMax(int *A, int N)
{
  int imax = 0, i;
  for(i = 1; i < N; i++)
    if (before(A[imax],A[i]))
      imax = i;

  return imax;
}

void swap(int& a, int& b){ int t = b; b = a; a = t; }

bool before(int a, int b)
{
  if(a%2 == 1 && b%2 == 1)
      return a < b;
  else if(a%2 == 0 && b%2 == 1)
      return false;
  else if(a%2 == 0 && b%2 == 0)
      return a < b;
    else if(a%2 == 1 && b%2 == 0)
      return true;
}
