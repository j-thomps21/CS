#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  //declare all the variables and take in their respective values
  string fpic, bpic, output, P3;
  cout << "Foreground file: ";
  cin >> fpic;
  cout << "Background file: ";
  cin >> bpic;
  cout << "Output file: ";
  cin >> output;

  int F1, F2, F3, B1, B2, B3, O1, O2, O3, garb1, garb2, garb3;

  ifstream FP(fpic.c_str());
  ifstream BP(bpic.c_str());

  //take in the foreground and background first few lines
  //which pertain to the dimensions and other values
  FP >> P3 >> garb1 >> garb2 >> garb3;
  BP >> P3 >> garb1 >> garb2 >> garb3;

  //if the user does not give a valid image file then cout and
  //exit the program
  if (!FP || !BP)
  {
    cout << "Error: Input file not found " << endl;
    return 0;
  }

  //here we begin the main function which only works if both files given
  //are valid
  if (FP && BP)
  {
    ofstream OP(output.c_str());

    //output the first few values which only describe the dimensions of the image
    OP << P3.c_str() << endl << garb1 << endl << garb2 << " " << garb3 << endl;

    //The loop takes in values for both the foreground and background files
    // and if the pixels of the foreground file match the if condition then replace
    // those values with the ones from the background file
    while (FP >> F1 >> F2 >> F3 && BP >> B1 >> B2 >> B3)
    {
      if (F1 == 0 && F2 == 255 && F3 == 0)
      {
        OP << B1 << " " << B2 << " " << B3 << " ";
      }
      //if the foreground pixel doesnt meet the condition then
      // output the foreground pixel instead of the background pixel
      else
      {
        OP << F1 << " " << F2 << " " << F3 << " ";
      }
    }
  }
  cout << "Image saved to " << output << endl;
  return 0;
}
