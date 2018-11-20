import java.util.List;
import java.util.ArrayList;
//import either java.util.ArrayList or java.util.LinkedList
//DO NOT IMPORT JAVA.UTIL.*

//This fancy generic here says that the keys in the map must implement the
//Comparable interface and be comparable to other keys of the same
//type.
//
//Aside from this, there is no restriction placed on the type of the values
public class BST<K extends Comparable<K>,V> implements Map<K,V>{
  ////////////////////////////////////////////////////////////////////////////////////
  private class Node {
    public K key;
    public int height;
    public V value;
    public Node left, right;
    public Node(K k, V v){
      key = k;
      value = v;
      left = right = null;
      height = -1;
    }
  }
  ////////////////////////////////////////////////////////////////////////////////////
  private Node root;
  private int height;

  public BST(){
    root = null;
  }
  ////////////////////////////////////////////////////////////////////////////////////
  public V get(K key){
    return get(root, key);
  }

  private V get(Node n, K key){
    if(n == null)
      return null;
    else if(key.compareTo(n.key) == 0)
      return n.value;

    if(key.compareTo(n.key) < 0)
      return get(n.left, key);
    else
      return get(n.right, key);
  }
  ////////////////////////////////////////////////////////////////////////////////////

  public void insert(K key, V value){
    root = insert(root, key, value);
  }

  private Node insert(Node n, K key, V value){
    if(n == null)
      return new Node(key, value);

    if(key.compareTo(n.key) == 0)
      n.value = value;
    else if(key.compareTo(n.key) < 0)
      n.left = insert(n.left, key, value);
    else
      n.right = insert(n.right, key, value);

    return n;
  }

  ////////////////////////////////////////////////////////////////////////////////////
  public int size(){
    return size(root);
  }
  private int size(Node n){
    if(n == null)
      return 0;

    return 1 + size(n.left)+ size(n.right);
  }
  ////////////////////////////////////////////////////////////////////////////////////
  public List<K> keys(){
    List<K> keyList = new ArrayList<K>();
    keyList = keys(root, keyList);
    return keyList;
  }

  private List<K> keys(Node n, List keyList){
    if(n == null)
      return keyList;

    keyList = keys(n.left, keyList);
    keyList.add(n.key);
    keyList = keys(n.right, keyList);
    return keyList;
  }
  ////////////////////////////////////////////////////////////////////////////////////
  public List<V> values(){
    List<V> valueList = new ArrayList<V>();
    valueList = values(root, valueList);
    return valueList;
  }
  private List<V> values(Node n, List<V> valueList){
    if(n == null)
      return valueList;

    valueList = values(n.left, valueList);
    valueList.add(n.value);
    valueList = values(n.right, valueList);
    return valueList;
  }
  ////////////////////////////////////////////////////////////////////////////////////


  public static void main(String args[]){

    Map<Integer,String> map = new BST<Integer,String>();

    map.insert(222222, "Ernest Hemingway");
    map.insert(111111, "Ray Charles");
    map.insert(333333, "John F Kennedy");

    System.out.println(map.get(333333)); // should print John F Kennedy
    System.out.println(map.get(222222)); // should print Ernest Hemingway

    String name = map.get(444444);

    if (name == null)
      System.out.println("444444 is not in the map");   // should do this
    else
      System.out.println("this is not right: " + name); // not this

    System.out.println(map.size()); // should print 3

    System.out.println();
    System.out.println("Keys:");
    for(Integer i : map.keys()){
      System.out.println(i);  //this will print all the keys
    }
    System.out.println();

    System.out.println("Values:");
    for(String v : map.values()){
      System.out.println(v); //this will print all the values, in the order of their keys
    }
    System.out.println();
  }
}
