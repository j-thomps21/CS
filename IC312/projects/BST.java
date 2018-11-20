import java.util.List;
import java.util.ArrayList;

public class BST<K extends Comparable<K>,V> implements Map<K,V>{

  private class Node{
    public final K key;
    public V value;
    public Node left;
    public Node right;
    public Node(K key, V value){
      this.key=key;
      this.value=value;
      left=null;
      right=null;
    }
  }

  private Node root;
  private int size;
  public BST() {
    root=null;
    size=0;
  }

  public void insert(K key, V value) {
    root=insert(root,key,value);
  }
  private Node insert(Node n, K key, V value) {
    if (n==null && value==null)//why are you adding a new key with a null
      return null;             //value? I won't do it!
    if (n==null){
      size++; //new key, so increment size
      return new Node(key, value);
    }
    if (n.key.equals(key)){ //replace the value of an existing key
      n.value=value;
      if (value==null)//deletion!
        size--;
    }
    else if (key.compareTo(n.key)<0) 
      n.left=insert(n.left, key, value);
    else
      n.right=insert(n.right, key, value);
    return n;
  }

  public V get(K key) {
    return get(root,key);
  }
  private V get(Node n, K key){
    if (n==null) //not there!
      return null;
    if (n.key.equals(key))
      return n.value;
    if (n.key.compareTo(key)<0)
      return get(n.right,key);
    return get(n.left,key);
  }

  public int size() {
    return size;
  }

  public List<K> keys() {
    List<K> theList=new ArrayList<K>(size);
    keys(root,theList);
    return theList;
  }

  //inorder, of course
  private void keys(Node n, List<K> theList) {
    if (n==null)
      return;
    keys(n.left,theList);
    if (n.value != null)//don't want to add deleted keys
      theList.add(n.key);
    keys(n.right,theList);
  }

  public List<V> values() {
    List<V> theList=new ArrayList<V>(size);
    values(root,theList);
    return theList;
  }
  private void values(Node n, List<V> theList) {
    if (n==null)
      return;
    values(n.left,theList);
    if (n.value != null)//don't want to add null values
      theList.add(n.value);
    values(n.right,theList);
  }
}
