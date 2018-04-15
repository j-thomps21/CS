#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  //Take in all the filenames for foreground image, background image, and output  image
  //take in offset
  string fpic, bpic, output, P3;
  int offset1, offset2;
  char character;
  cout << "Foreground file: ";
  cin >> fpic;
  cout << "Background file: ";
  cin >> bpic;
  cout << "Enter offset (x,y): ";
  cin >> character >> offset1 >> character >> offset2 >> character;
  cout << "Output file: ";
  cin >> output;


  int F1, F2, F3, B1, B2, B3, O1, O2, O3, garb1, garb2, garb3, dimw, diml;

  ifstream FP(fpic.c_str());
  ifstream BP(bpic.c_str());
  ofstream OP(output.c_str());

  //take in the first few lines of the image that do not pertain to the pixels
  FP >> P3 >> dimw >> diml >> garb3;
  BP >> P3 >> garb1 >> garb2 >> garb3;

  //if the files given by the user are not found then give Error message and exit program
  if (!FP || !BP)
  {
    cout << "Error: Input file not found" << endl;
    return 0;
  }

  //if the offset is too much in x or y direction then exit program
  if (offset1 > 900 || offset2 > 300)
  {
    cout << "Error: The foreground image goes past the background image" << endl;
    return 0;
  }

  garb1 = 1280;
  garb2 = 960;

  //if everything is successful then begin the main computation
  if (FP || BP)
  {
    //output the first few lines of the image that
    //don't pertain to the pixels themselves

    OP << P3.c_str() << endl << garb1 << endl << garb2 << " " << garb3 << endl;

    //for the first loop we count the offset in the y direction
    for (int i=0; i < offset2; i++)
     {
      // for the loop inside of the first loop we make sure that in each line of pixels it is
      // a total of 1280 pixels wide
      for (int ii = 0; ii < 1280; ii++)
       {
        // we are only outputting the pixels in the backgound image that lead up to where the
        // foreground image begins
        BP >> B1 >> B2 >> B3;
        OP << B1 << " " << B2 << " " << B3 << " ";
       }
        OP << endl;
     }
        // in this loop we are now going to deal with both the foreground and
        // background images. Here the loop only runs while both files are inputting
        for (int vi = 0; vi < diml; vi++)
        {
           //in this loop we are counting the pixels up to the offset in the x direction
           for (int iii = 0; iii < offset1; iii++)
            {
             //we only output the background image pixels until
             //the offset number is met
             BP >> B1 >> B2 >> B3;
             OP << B1 << " " << B2 << " " << B3 << " ";
            }
            //we finally get to where the foreground image is being outputted.
            //the dimw variable is the value for the width of the foreground image
            //and will output number of pixels in the width.
            for (int iv = 0; iv < dimw && FP >> F1 >> F2 >> F3 && BP >> B1 >> B2 >> B3; iv++)
             {
              //here we do the green screen effect
              if (F1 == 0 && F2 == 255 && F3 == 0)
               OP << B1 << " " << B2 << " " << B3 << " ";
             else
               OP << F1 << " " << F2 << " " << F3 << " ";
             }
              // this loop just outputs the rest of the background
             //image in the row
             for (int v = 0; v < (1280 - (dimw + offset1)); v++)
             {
               BP >> B1 >> B2 >> B3;
               OP << B1 << " " << B2 << " " << B3 << " ";
             }
              //We end the line and then the loop resets to start the next row of pixels.
              OP << endl;
          }
       }
       while (BP >> B1 >> B2 >> B3)
        {
         OP << B1 << " " << B2 << " " << B3 << " ";
        }
  //cout the output filename
  cout << "Image saved to " << output << endl;
  return 0;
}
