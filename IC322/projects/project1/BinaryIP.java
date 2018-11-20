import java.io.*;
import java.util.*;

//Purpose of this class is to represent an IP in binary form using 4 Binary objects.
public class BinaryIP{
  //Array of Binary Objects
  protected Binary[] ip;

  //Takes in an array of regular integers and converts them to binary
  public BinaryIP(int[] n){
    ip = new Binary[4];
    for(int i = 0; i < 4; i++){
      ip[i] = new Binary(n[i]);
    }
  }

  //Takes a full length 32 bit binary string and makes a BinaryIP object
  public BinaryIP(String s){
    ip = new Binary[4];
    ip[0] = new Binary(s.substring(0, 8));
    ip[1] = new Binary(s.substring(8, 16));
    ip[2] = new Binary(s.substring(16, 24));
    ip[3] = new Binary(s.substring(24, 32));
  }

  //toString method
  public String toString(){
    String s = "";
    for(int i = 0; i < 4; i++){
      s += ip[i].toString();
    }
    return s;
  }

  //Similar to toString method but returns an int array
  public int[] getIP(){
    int[] arr = new int[32];
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 8; j++){
        arr[8*i+j] = ip[i].getValue()[j];
      }
    }
    return arr;
  }

  //Converts the BinaryIP to a normal integer IP that we are used to
  public String toIntIP(){
    String s = "";
    s+= ip[0].toInt();
    for(int i = 1; i < 4; i++)
      s += "." + ip[i].toInt();
    return s;
  }
}
