//Purpose of this class is to simply add a header onto the input BinaryIP
public class NetworkIP extends BinaryIP{
  //Header specifies the "/int" amount that describes the network. Ex: "1.1.1.0/24"
  private int header;

  //Inherits same constructor but adds header value
  public NetworkIP(int[] n, int h){
    super(n);
    header = h;
  }

  //toString
  public String toString(){
    String s = "";
    for(int i = 0; i < 4; i++)
      s+= ip[i].toString();
    s += "/" + header;
    return s;
  }

  //Compare function that compares the NetworkIP to BinaryIP objects (which could include
  //other NetworkIPs objects.) This is the bread and butter of this project. Returns an
  //int of how many bits the input IP had in common with this NetworkIP
  public int compare(BinaryIP a){
    int count = 0;
    int[] ip1 = this.getIP();
    int[] ip2 = a.getIP();
    for(int i = 0; i < 32; i++){
      if(ip1[i] == ip2[i]){
        count++;
        if(count == header)
          break;
      }
      else
        break;
    }
    if(count < header)
      return 0;
    return count;
  }
}
