//Joshua Thompson m206360
#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    int w, x, y, z, n;
    char a, b, c;
    cout << "Enter two lengths in feet and inches (larger first!).";
    cin >> w >> a >> x >> b >> c >> y >> a >> z >> b >> c;

    w = (w*12 + x);
    y = (y*12 + z);
    n = w - y;
    w = n/12;
    x = n%12;

    cout << "Difference is ";
    cout << w<<"'" << x<<"''" << endl;

    return 0;
}
