import java.io.*;
import java.util.*;
import java.math.*;

//I created my own HashSet class for the 100% solution
public class MyHashSet<K extends Comparable<K>> implements Set<K>{
  //private Node class. Pretty much the same node that we would use in a normal linked list
  private class Node{
    K key;

    Node next;

    public Node(K key){
      this.key = key;
      next = null;
    }
  }

  //The main arraylist where everything is kept
  private ArrayList<Node> daArray;

  //keep track of the max capacity of the array (for load capacity)
  private int maxCap;

  //how many elements are currently loaded in the data structure
  private int size;

  public MyHashSet(){
    daArray = new ArrayList<Node>(10);
    maxCap = 10;
    size = 0;

    //initialize each of the indexes with null
    for(int i = 0; i < maxCap; i++)
      daArray.add(null);
  }

  //return how many elements in the structure
  public int size(){
    return size;
  }

  //Use's java's hash method to return the index where we will store the key
  private int getKeyIndex(K key){
    int hashInt = key.hashCode();
    int arrayindex = Math.abs(hashInt % maxCap);
    return arrayindex;
  }

  //Add method
  public void add(K key){
    //get the index where we are going to add the key
    int index = getKeyIndex(key);
    Node n = daArray.get(index);

    //checks to see if there is a duplicate
    while(n != null){
      if(n.key.equals(key))
        return;
      n = n.next;
    }

    //increment size
    size++;
    n = daArray.get(index);
    Node newOne = new Node(key);
    newOne.next = n;
    //add the new node to the end of the linked list at the index
    daArray.set(index, newOne);

    //check the load factor, making sure its below .65
    if((double)(size/maxCap) >= 0.65){
      //if the load factor is larger, then double the array size
      ArrayList<Node> temp = daArray;
      daArray = new ArrayList<Node>();
      maxCap = 2 * maxCap;
      size = 0;

      //re add everything into the new array
      for(int i = 0; i < maxCap; i++)
        daArray.add(null);

      for(Node xNode : temp){
        while(xNode != null){
          add(xNode.key);
          xNode = xNode.next;
        }
      }
    }

  }

  //Check to see if the data structure contains the key
  public boolean contains(K key){
    //find out where the key should go
    int index = getKeyIndex(key);
    Node n = daArray.get(index);

    //check to see if the key is there
    while(n != null){
      if(n.key.equals(key))
        //if it is here then return true
        return true;
      n = n.next;
    }
    //otherwise return false
    return false;
  }

  //puts all the elements into an ArrayList and returns the list
  public List<K> toList(){
    ArrayList<K> tempList = new ArrayList<K>(size);
    for(Node tempNode : daArray){
      while(tempNode != null){
        tempList.add(tempNode.key);
        tempNode = tempNode.next;
      }
    }
    return tempList;
  }





}
