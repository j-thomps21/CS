#include <iostream>
#include <string>

using namespace std;

struct contestant
{
  string name;
  int* tickets;
};

void search(contestant*, int, int);
void print(contestant*, int);

int main()
{
  int n;
  cout << "How many people? ";
  cin >> n;

  contestant* A = new contestant[n];

  for(int i = 0; i < n; i++)
  {
    A[i].tickets = new int[4];
  }

  for(int i = 0; i < n; i++)
  {
    cout << "Person " << i+1 << " name: ";
    cin >> A[i].name;
    cout << "Person " << i+1 << " tickets: ";
    cin >> A[i].tickets[0] >> A[i].tickets[1] >> A[i].tickets[2] >> A[i].tickets[3];
  }

  int winticket;
  cout << "Winning ticket: ";
  cin >> winticket;

  search(A, n, winticket);

  return 0;
}


void search(contestant* A, int n, int wt)
{
  for(int i = 0; i < n; i++)
  {
    for(int j = 0; j < 4; j++)
    {
      if(A[i].tickets[j] == wt)
      {
        print(A,i);
        break;
      }
    }
  }
}

void print(contestant* A, int i)
{
  cout << A[i].name << " won!" << endl;
}
