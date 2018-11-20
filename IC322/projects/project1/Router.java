import java.io.*;
import java.util.*;


//Router class where all the magic happens.
public class Router{
  public static void main(String[] args) {
    //If the user does not provide the correct fields for the program then this message will be printed out.
    if(args.length < 2){
      System.out.println("Usage: java Router <Routing table file> <input IP file>");
      System.exit(1);
    }

    //PrintWriter object prints output to file called ThompsonAnswer.txt
    PrintWriter out = null;
    try{
      out = new PrintWriter("ThompsonAnswer.txt", "UTF-8");
    } catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }


    //Creates a new scanner for the input routing table.
    String tableFile = args[0];
    Scanner sc = null;
    try{
    sc = new Scanner(new FileReader(tableFile));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }

    //Creates the routing table
    RoutingTable rt = new RoutingTable(sc);

    //Creates a scanner for the input Binary ips and creates an arraylist to
    //store all those ips
    String inputFile = args[1];
    ArrayList<BinaryIP> inputIPs = getInputIPs(inputFile);


    //For loop to check all the prefix matching for each Binary ip
    for(int i = 0; i < inputIPs.size(); i++)
      rt.longestPrefixMatch(inputIPs.get(i), out);

    //Close the output stream
    out.close();
  }

  //Static method to read in the Binary IPs. Returns an ArrayList
  public static ArrayList<BinaryIP> getInputIPs(String inputFile){
    ArrayList<BinaryIP> inputIPs = new ArrayList<BinaryIP>();
    Scanner in = null;
    try{
      in = new Scanner(new FileReader(inputFile));
    } catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }

    while(in.hasNext()){
      String s = in.nextLine();
      inputIPs.add(new BinaryIP(s));
    }
    return inputIPs;
  }
}
