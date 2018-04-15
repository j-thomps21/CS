#include <iostream>

using namespace std;

// PROTOTYPE: IMPLEMENT THIS FUNCTION BELOW main!!
int firstfactor(int);

int main()
{
  // Get integer n, n > 1, from user
  int n;
  cout << "Enter an integer larger than 1: ";
  cin >> n;

  // Print out factorization
  cout << "The factorization of " << n << " is ";
  while(n > 1)
  {
    // get & print next prime factor
    //cout << endl << "N is currently:" << n << endl;
    int f = firstfactor(n);
    cout << '(' << f << ')';
    n = n / f;
  }
  cout << endl;

  return 0;
}

int firstfactor(int n)
{
 int lastone = n;
 int r = 0;
 int i = n - 1;
 while (i > 1)
 {
   r = n % i;
   if (r == 0)
   {
     lastone = i;
   }

   i--;
 }
 return lastone;
}
