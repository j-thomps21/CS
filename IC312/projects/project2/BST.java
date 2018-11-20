import java.util.List;
import java.util.ArrayList;

public class BST<K extends Comparable<K>> implements Set<K>{
  private class Node{
    public final K key;
    public Node left;
    public Node right;
    public Node(K key){
      this.key = key;
      left = null;
      right = null;
    }
  }

  private Node root;
  private int size;

  public BST(){
    root = null;
    size = 0;
  }
//////////////////////////////////////////////////////////////////
  public void add(K key){
    root = add(root, key);
  }

  private Node add(Node n, K key){
    if(n == null){
      size++;
      return new Node(key);
    }
    if(n.key.equals(key)){
      return n;
    }
    else if(key.compareTo(n.key) < 0)
      n.left = add(n.left, key);
    else if(key.compareTo(n.key) > 0)
      n.right = add(n.right, key);
    return n;
  }
//////////////////////////////////////////////////////////////////
  public int size(){
    return size;
  }
//////////////////////////////////////////////////////////////////
  public List<K> toList(){
    List<K> keyList = new ArrayList<K>(size);
    toList(root, keyList);
    return keyList;
  }
  private void toList(Node n, List<K> keyList){
    if(n == null)
      return;
    toList(n.left,  keyList);
    keyList.add(n.key);
    toList(n.right, keyList);
  }
//////////////////////////////////////////////////////////////////
  public boolean contains(K key){
    return contains(root, key);
  }
  private boolean contains(Node n, K key){
    if(n == null)
      return false;
    if(n.key.equals(key))
      return true;
    else if(n.key.compareTo(key) < 0)
      return contains(n.right, key);
    else
      return contains(n.left, key);
  }
//////////////////////////////////////////////////////////////////
}
