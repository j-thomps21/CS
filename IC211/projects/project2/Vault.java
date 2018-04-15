import java.io.*;
import java.util.*;

/**
Class Vault that creates a mini shell which allows the user to interact
with the interface. Contains several methods such as the main where everything happens,
and other helper methods that help with the creation of the mini shell, and reading in the file.
@author Thompson, Joshua - 206360
*/
public class Vault
{
  /**
  Main method where everything is called. Does some error checking for the file
  and argument checking. Prompts the user for username and password and then
  authenticates them if the username and password are correct. If authenticated,
  give a mini shell which gives the user access to their own files via labels.
  @param args Arguments that the program takes. In this case a file is required which the program
  reads from in order to get the data. Option -au can also be used which adds the ability to write a
  new user to the output file.
  */
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      System.out.println("usage: java Vault [-au] <filename>");
      System.exit(1);
    }
    if(args[0].equals("-au"))
    {
      try {
        addUser(args);
      } catch (Throwable e) {
        System.out.println(e.getMessage());
        System.exit(1);
      }
    }

    Scanner sc = null;
    try {
      sc = new Scanner(new FileReader(args[0]));
    } catch(IOException e) {
      System.out.println("Error! File '" + args[0] + "' could not be opened.");
      System.exit(1);
    }

    //Reads in the username and password
    System.out.print("username: ");
    String uname = System.console().readLine();
    System.out.print("password: ");
    char[] password = System.console().readPassword();

    ArrayList<UserData> users = new ArrayList<UserData>();
    try {
      users = readFile(args[0], sc);
    } catch(Throwable e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    boolean check = true, checkName = false;
    int i = 0;
    for(; i < users.size(); i++)
    {
      if(!uname.equals(users.get(i).getUserName()))
        continue;
      else
        checkName = true;
      try {
        if(users.get(i).authenticate(uname, password))
        {
          System.out.println("Access granted!");
          break;
        }
        else
        {
          System.out.println("Access denied!");
          check = false;
          break;
        }
      } catch(Throwable e) {
          System.out.println(e.getMessage());
          System.exit(1);
      }
    }
    if(checkName == false)
    {
      System.out.println("Access denied!");
      System.exit(1);
    }
    if(check == true)
    {
      try {
        users.get(i).decryptData(password);
        miniSH(users.get(i), password, args[0]);
      } catch(Throwable e) {
        System.out.println(e.getMessage());
        System.exit(1);
      }
    }
  }

  /**
  This method takes a filescanner and reads the data from its file. If the line starts with "user" then
  the method adds a new user to the list. If it starts with "data" then the method finds the corresponding
  user and adds the data to the data ArrayList in that object. Does some error checking as well.
  @param fname Used in throwning throwables that have to do with improperly formatted source files.
  @param sc The filescanner that is used to read the source data. Is already assumed to be an opened file.
  @throws Throwable Thrown if file is improperly formatted, or if wrong algorithms are used and other instances.
  */
  public static ArrayList<UserData> readFile(String fname, Scanner sc) throws Throwable
  {
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
        throw new Throwable("Error! File '" + fname + "' improperly formatted.");

      if(cmd[0].equals("user"))
      {
        try {
          while(!E.get(++i).getHashName().equals(cmd[2]));
        } catch (Exception e) {
          System.out.println("Error! Hash algorithm '" + cmd[2] + "' not supported.");
          System.exit(1);
        }
        try {
          users.add(new UserData(E.get(i), cmd[3], cmd[1]));
        } catch(Throwable e) {
          System.out.println(e.getMessage());
          System.exit(1);
        }
      }
      else if(cmd[0].equals("data"))
      {
        boolean check = false;
        int j = 0;
        for(; i < users.size(); j++)
        {
          if(cmd[1].equals(users.get(j).getUserName()))
          {
            check = true;
            break;
          }
        }
        //possibly put exception throw here
        users.get(j).addDataEntry(cmd[2],cmd[3]);
      }
    }
    return users;
  }

  /**
  Method used to create the mini shell that the user interacts with to access
  the files once they have been authenticated. Creates an infinite while loop that waits for commands and
  is terminated upon the entry of the "quit" command.
  @param user The user has been authenticated and will then have access to all the data inside
  their user object.
  */
  public static void miniSH(UserData user, char[] pwd, String fname)
  {
    Scanner in = new Scanner(System.in);

    while(true)
    {
      try {
        System.out.print("> ");
        String command = in.next();

        if(command.equals("get"))
        {
          String l = in.next();
          user.printDataText(l);
        }
        else if(command.equals("labels"))
        {
          user.printLabels();
        }
        else if(command.equals("add"))
        {
          String enc = in.next();
          String label = in.next();
          String text = in.next();
          //String[] text = command.split(" ");
          PrintWriter pw = null;
          user.addDataEntry(enc, label, text, pwd);
          pw = new PrintWriter(new FileWriter(fname, true));
          pw.println(user.outputFileString());
          if(pw != null) pw.close();
        }
        else if(command.equals("quit"))
        {
          System.exit(0);
        }
        else
          System.out.println("Unknown command '" + command + "'.");
        } catch(Throwable e) {
          System.out.println(e.getMessage());
          System.exit(1);
        }
    }
  }

  /**
  Method used if the user enters the -au option. Takes args argument to check
  the file that the user data will be outputted to. Prompts user for what username,
  password, and hash algorithm they want to use for the new user entry.
  @param args Output file that the userdata will be sent to
  @throws Throwable Various throwables that could be thrown from computing hash or
  if the user enters a bad character in the password.
  */
  public static void addUser(String[] args) throws Throwable
  {
      PrintWriter pw = null;
    try{
      pw = new PrintWriter(new FileWriter(args[1] , true));
    } catch (Throwable e) {
      throw new Throwable("Error! File '" + args[1] + "' could not be opened.");
    }
    System.out.print("username: ");
    String uname = System.console().readLine();
    System.out.print("password: ");
    char[] pwd = System.console().readPassword();
    System.out.print("Hash algorithm: ");
    String hashAlg = System.console().readLine();

    for(int i = 0; i < pwd.length; i++)
      if(pwd[i] > 122 || pwd[i] < 42)
        throw new Throwable("Error! Invalid symbol '" + pwd[i] + "' in password.");

    ArrayList<Hasher> E = new ArrayList<Hasher>();
    E.add(new ClearHash());
    E.add(new EncHash('c'));
    E.add(new EncHash('v'));
    boolean check = false;
    for(int i = 0; i < E.size(); i++)
      if(hashAlg.equals(E.get(i).getHashName()))
        check = true;
    if(check == false)
      throw new Throwable("Error! Hash algorithm '" + hashAlg + "' not supported.");



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
