import java.util.List;
import java.util.ArrayList;
//Balanced Tree that uses the AVL rules. Implements Set
public class AVLSet<K extends Comparable<K>>  implements Set<K>{
  //Private Node class required for each of the leaves of the tree
  //Unique to AVL is the height field (as opposed to BST)
  private class Node{
    public final K key;
    public Node left;
    public Node right;
    public int height;
    public Node(K key){
      this.key = key;
      left = null;
      right = null;
      height = 0;
    }
    //Update height function that takes the largest height
    //of the child nodes and adds one
    public void updateHeight(){
      if(left == null && right == null)
        height = 0;
      else if(left == null)
        height = right.height + 1;
      else if(right == null)
        height = left.height + 1;
    }
  }

  private Node root;
  private int size;

  //Constructor
  public AVLSet(){
    root = null;
    size = 0;
  }
//////////////////////////////////////////////////////////////////
  //Add methods that take in a key and adds a new node with that key
  //into the tree. Will automatically balance the tree if needed.
  public void add(K key){
    root = add(root, key);
  }
  private Node add(Node n, K key){
    if(n == null){
      size++;
      return new Node(key);
    }

    //Standard BST adding
    if(n.key.equals(key))
      return n;
    else if(key.compareTo(n.key) < 0)
      n.left = add(n.left, key);
    else if(key.compareTo(n.key) > 0)
      n.right = add(n.right, key);

    //Update the node height
    n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1;

    //fixing the tree
    if(balance(n) == 2 && balance(n.right) == 1)
      return leftRotate(n);
    if(balance(n) == -2 && balance(n.left) == -1)
      return rightRotate(n);
    if(balance(n) == 2 && balance(n.right) == -1){
      n.right = rightRotate(n.right);
      return leftRotate(n);
    }
    if(balance(n) == -2 && balance(n.left) == 1){
      n.left = leftRotate(n.left);
      return rightRotate(n);
    }

    //return the root of the subtree
    return n;
  }
//////////////////////////////////////////////////////////////////
  //returns amount of nodes in tree
  public int size(){
    return size;
  }
//////////////////////////////////////////////////////////////////
  //Gets the height of that particular subtree
  public int getHeight(Node n){
    if(n == null)
      return 0;

    return n.height;
  }
//////////////////////////////////////////////////////////////////
  //puts all the keys into a list
  public List<K> toList(){
    List<K> keyList = new ArrayList<K>(size);
    toList(root, keyList);
    return keyList;
  }
  private void toList(Node n, List<K> keyList){
    if(n == null)
      return;
    toList(n.left, keyList);
    keyList.add(n.key);
    toList(n.right, keyList);
  }
//////////////////////////////////////////////////////////////////
  //Check to see if the tree contains a certain input key
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
  //Returns the balance of the input node. Does this by subtracting
  //the height of the right node from the left, with some special cases
  //in case the nodes are null.
  private int balance(Node n){
    if(n == null)
      return 0;
    else if(n.left == null && n.right == null)
      return 0;
    else if(n.left == null)
      return n.right.height;
    else if(n.right == null)
      return -n.left.height;
    else
      return n.right.height - n.left.height;
  }
//////////////////////////////////////////////////////////////////
  //Perform left rotation around the oldRoot
  private Node leftRotate(Node oldRoot){
    Node newRoot = oldRoot.right;
    Node otherNode = newRoot.left;
    newRoot.left = oldRoot;
    oldRoot.right = otherNode;
    //update the heights of both nodes
    oldRoot.height = Math.max(getHeight(oldRoot.right), getHeight(oldRoot.left)) + 1;
    newRoot.height = Math.max(getHeight(newRoot.right), getHeight(newRoot.left)) + 1;
    return newRoot;
  }
  //Perform right rotation around the oldRoot
  private Node rightRotate(Node oldRoot){
    Node newRoot = oldRoot.left;
    Node otherNode = newRoot.right;
    newRoot.right = oldRoot;
    oldRoot.left = otherNode;
    //update the heights of both nodes
    oldRoot.height = Math.max(getHeight(oldRoot.right), getHeight(oldRoot.left)) + 1;
    newRoot.height = Math.max(getHeight(newRoot.right), getHeight(newRoot.left)) + 1;
    return newRoot;
  }
//////////////////////////////////////////////////////////////////
}
