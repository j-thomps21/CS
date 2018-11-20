import java.io.*;
import java.util.*;

//This class creates a routing table from an input file
public class RoutingTable{
  //Has a list for the Network ips and for their corresponding output interfaces
  private ArrayList<NetworkIP> ipList;
  private ArrayList<String> interfaces;

  //Constructor takes a Scanner object which points to an input file
  public RoutingTable(Scanner sc){
    ipList = new ArrayList<NetworkIP>();
    interfaces = new ArrayList<String>();

    String ip, fa;
    while(sc.hasNext()){
      ip = sc.next();
      if(ip.equals("All"))
        ip += " " + sc.next();
      fa = sc.nextLine();

      if(ip.equals("All else")){
        ipList.add(null);
        interfaces.add(fa);
        continue;
      }

      String[] s1 = ip.split("\\/");
      String[] s2 = s1[0].split("\\.");
      int[] ipInts = new int[4];
      for(int i = 0; i < 4; i++)
        ipInts[i] = Integer.parseInt(s2[i]);

      int header = Integer.parseInt(s1[1]);
      ipList.add(new NetworkIP(ipInts, header));
      interfaces.add(fa);
    }
  }

  //This funciton is called to compare an input BinaryIP and print out to an
  //output file where the packet with that IP would be sent. Heavily relies on
  //using the compare method in the NetworkIP class
  public void longestPrefixMatch(BinaryIP ip, PrintWriter out){
    int max = 0;
    Integer maxIndex = null;
    for(int i = 0; i < ipList.size(); i++){
      if(ipList.get(i) != null){
        int temp = ipList.get(i).compare(ip);
        if(temp > max){
          max = temp;
          maxIndex = i;
        }
      }
    }
    out.println("IP address: " + ip.toIntIP());
    out.print("Longest Matching Prefix: ");
    if(max == 0){
      out.println("*");
      out.println("Outbound interface: " + interfaces.get(interfaces.size()-1));
    }
    else{
      for(int i = 0; i < max; i++)
        out.print(ip.getIP()[i]);
      out.println();
      out.println("Outbound interface: " + interfaces.get(maxIndex));
    }
    out.println();
  }

  //Prints out the routing table that was read in. Helpful for debugging
  public void printRoutingTable(){
    for(int i = 0; i < ipList.size(); i++){
      System.out.println("Network IP: " + ipList.get(i) + "    Interface: " + interfaces.get(i));
    }
  }
}
