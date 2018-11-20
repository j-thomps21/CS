import java.io.*;
import java.util.*;
import java.lang.*;

public class Binary{
  //value is an array of 1s and 0s of size 8
  private int[] value;

  //Constructor takes in a regular integer and changes it into binary.
  //Note that the integer must be 0 - 255
  public Binary(int n){
    value = toBinary(n);
  }

  //Takes a Binary string and just convert to an integer array.
  public Binary(String s){
    value = new int[8];
    for(int i = 0; i < s.length(); i++)
      value[i] = s.charAt(i) - '0';
  }

  //Converts an integer to binary.
  public static int[] toBinary(int n){
    int[] binaryString = new int[8];

    for(int i = 0; i < 8; i++){
      if(n >= Math.pow(2, 7-i)){
        binaryString[i] = 1;
        n = n - (int)Math.pow(2,7-i);
      }
      else
        binaryString[i] = 0;
    }
    return binaryString;
  }

  //toString method
  public String toString(){
    String s = "";

    for(int i = 0; i < 8; i++)
      s+= value[i];

    return s;
  }

  //Converts from binary to integer
  public int toInt(){
    int sum = 0;
    for(int i = 0; i < 8; i++){
      if(value[i] == 1)
        sum += Math.pow(2, 7-i);
    }
    return sum;
  }

  //Returns the array
  public int[] getValue(){
    return value;
  }
}
