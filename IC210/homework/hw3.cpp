//Joshua Thompson
#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main()

{
    char x, y, z;
    cout << "Input a 3-letter word in lowercase letters: ";
    cin >> x >> y >> z;
    x = x - 32;
    cout << "With leading letter capitalized this is: ";
    cout << x<<y<<z;
    cout << endl;
    return 0;
}
