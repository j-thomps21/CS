#include <iostream>
using namespace std;

int flamingo(int bb, int qq);
int gnu(int bb);

int main()
{
  int seed, pin, password;
  cout << "wecom:" << endl;
  cout << "Enter the seed value: ";
  cin >> seed;
  cout << "Enter the PIN value: ";
  cin >> pin;

  if(seed <= 10 && pin <= 10)
  {
    password = flamingo(seed, pin);
    cout << "your pwd: " << password << endl;
  }
  else
    cout << "Seed error! " << endl;
  return 0;
}

int flamingo (int bb, int qq)
{
  if (bb > 6)
  {
    return 7 + flamingo(bb-2, qq+3);
  }
  else if (bb > 4)
  {
    return flamingo(bb-2, qq) + flamingo(bb-1, qq-2) +bb;
  }
  else
    return 8 + 2*gnu(qq);

}

int gnu(int bb)
{
  if (bb <= 6)
  {
    return bb * 2 + 4;
  }
  else
    return bb * 3 + gnu(bb-1);
}
