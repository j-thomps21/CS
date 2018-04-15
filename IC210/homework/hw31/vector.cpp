#include "vector.h"


Vector operator-(Vector a, Vector b)
{
  Vector C;
  C.vals[0] = a.vals[0] - b.vals[0];
  C.vals[1] = a.vals[1] - b.vals[1];
  C.vals[2] = a.vals[2] - b.vals[2];
  C.vals[3] = a.vals[3] - b.vals[3];
  return C;
}

Vector operator+(Vector a, Vector b)
{
  Vector C;
  C.vals[0] = a.vals[0] + b.vals[0];
  C.vals[1] = a.vals[1] + b.vals[1];
  C.vals[2] = a.vals[2] + b.vals[2];
  C.vals[3] = a.vals[3] + b.vals[3];
  return C;
}



istream& operator>>(istream &in, Vector &a)
{
  char c;
  return in >> c >> a.vals[0] >> c >> a.vals[1] >> c >> a.vals[2] >> c >> a.vals[3] >> c;
}
ostream& operator<<(ostream &out, Vector a)
{
  return out << '(' << a.vals[0] << ", " << a.vals[1] << ", " << a.vals[2] << ", " << a.vals[3] << ")";
}
