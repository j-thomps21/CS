#include <iostream>
using namespace std;

int main()
{
  double** M;
  M = new double*[4];
  // *** TO DO: Allocate and initialize the 2D array shown in the above diagram

  for(int i = 0; i < 4; i++)
  {
    M[i] = new double[2];
  }

  double supaset = 0.0;
  for(int i = 0; i < 8; i++)
  {

    M[i/2][i%2] = supaset;
    supaset += .1;
  }
  // *** TO DO: **ONLY** fill inside the parentheses of the for-loops
  for (int i = 0; i < 4; i++)
  {
    for (int j = 0; j < 2; j++)
      cout << fixed << M[i][j] << " ";    // DON'T CHANGE THIS!

    cout << endl; // DON'T CHANGE THIS!
  }

  return 0;
}
