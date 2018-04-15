#include <iostream>
#include <string>
#include <cmath>
using namespace std;

struct Vector
{
  int vals[4];
};

Vector operator-(Vector a, Vector b);
Vector operator+(Vector a, Vector b);

istream& operator>>(istream &in, Vector &a);
ostream& operator<<(ostream &out, Vector a);
