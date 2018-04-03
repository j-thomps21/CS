import java.io.*;
import java.util.*;
public class Vault
{
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("usage: java Vault <filename>");
      System.exit(1);
    }
    if(args[0].equals("-au"))
    {
      try {
        addUser(args);
      } catch (Throwable e) {
        System.out.print("<Exception thrown out of main! Exact output not shown.>");
      }
    }


    ArrayList<UserData> users = new ArrayList<UserData>();
    try {
      users = readFile(args);
    } catch(Throwable e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    System.out.print("username: ");
    String uname = System.console().readLine();
    System.out.print("password: ");
    char[] password = System.console().readPassword();
    boolean check = true, checkName = false;
    for(int i = 0; i < users.size(); i++)
    {
      if(!uname.equals(users.get(i).getUserName()))
        continue;
      else
        checkName = true;
      try {
        if(users.get(i).authenticate(uname, password))
        {
          System.out.println("Acess Granted");
          break;
        }
        else
        {
          System.out.println("Acess Denied");
          check = false;
          break;
        }
      } catch(Throwable e) {
          System.out.println("<Exception thrown out of main! Exact output not shown.>");
          System.exit(1);
      }
    }
    if(checkName == false)
    {
      System.out.println("Acess Denied!");
      System.exit(1);
    }
    if(check == true)
      miniSH(users);
  }

  public static ArrayList<UserData> readFile(String[] args) throws Throwable
  {
    Scanner sc = null;
    try {
      sc = new Scanner(new FileReader(args[0]));
    } catch(IOException e) {
      System.out.println("Error! File '" + args[0] + "' could not be opened.");
      System.exit(1);
    }


    ArrayList<Hasher> E = new ArrayList<Hasher>();
    E.add(new ClearHash());
    E.add(new EncHash('c'));
    E.add(new EncHash('v'));

    ArrayList<UserData> users = new ArrayList<UserData>();
    while(sc.hasNext())
    {
      int i = -1;
      String line = sc.nextLine();
      String[] cmd = line.split(" ");
      if((cmd.length < 4) || (!(cmd[0].equals("user")) && !(cmd[0].equals("data"))))
        throw new Throwable("Error! File '" + args[0] + "' improperly formatted.");

      //boolean checkHash = false;
      try {
        while(!E.get(++i).getHashName().equals(cmd[2]));
      } catch (Exception e) {
        System.out.println("Error! Hash algorithm '" + cmd[2] + "' not supported.");
        System.exit(1);
      }
      try {
        users.add(new UserData(E.get(i), cmd[3], cmd[1]));
      } catch(Throwable e) {
        System.out.println("<Exception thrown out of main! Exact output not shown.>");
        System.exit(1);
      }
    }
    return users;
  }

  public static void miniSH(ArrayList<UserData> users)
  {
    Scanner in = new Scanner(System.in);

    while(true)
    {
      System.out.print("> ");
      String command = in.next();

      if(command.equals("quit"))
      {
        System.exit(0);
      }
    }
  }

  public static void addUser(String[] args) throws Throwable
  {
    System.out.print("username: ");
    String uname = System.console().readLine();
    System.out.print("password: ");
    char[] pwd = System.console().readPassword();
    System.out.print("Hash algorithm: ");
    String hashAlg = System.console().readLine();

    PrintWriter pw = null;
    pw = new PrintWriter(new FileWriter(args[1] , true));
    pw.print("user ");
    pw.print(uname + " ");
    pw.print(hashAlg + " ");

    Hasher[] H = new Hasher[3];
    H[0] = new ClearHash();
    H[1] = new EncHash('v');
    H[2] = new EncHash('c');
    int i = 0;
    for(; i < 3; i++)
      if(hashAlg.equals(H[i].getHashName()))
        break;

    H[i].init(pwd);
    pw.println(new String(H[i].computeHash()));
    if (pw != null) pw.close();
    System.exit(0);
  }
}
