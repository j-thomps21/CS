#include <iostream>
#include <string>
using namespace std;

int main()
{
    int a;
    string s, t;
    s = "Is Leap Year";
    t = "Is Not Leap Year";
    cout <<"Enter year: ";
    cin >> a;

    if (a%4 != 0)
    {
      cout << t;
    }
    else
    {
        if (a%400 == 0)
        {
          cout << s;
        }
        else
        {
          if (a%100 == 0)
          {
            cout << t;
          }
          else
          {
            if (a%4 == 0)
            {
              cout << s;
            }
          }
        }

        cout << endl;
        return 0;
       }
       cout << endl;
       return 0;
}
