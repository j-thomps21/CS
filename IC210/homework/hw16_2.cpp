#include <iostream>

using namespace std;

int main()
{
 int n;
 cin >> n;
 int lastone;
 int r = 0;
 int i = n - 1;
 while (i != 1)
 {
   r = n % i;
   if (r == 0)
   {
     lastone = i;
     cout << lastone <<endl;
   }
   i--;
 }
 return 0;
}
