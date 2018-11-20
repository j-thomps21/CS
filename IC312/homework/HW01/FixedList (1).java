public class FixedList<T> implements List<T>{
  private T[] daArray;
  private int size;

  @SuppressWarnings("unchecked") //the array creation in this constructor
                                 //requires this!
  public FixedList(int capacity) {
    daArray = (T[])new Object[capacity];
    this.size=0;
  }

  public T get(int i) {
    if (i<0 || i>=size)
      throw new IndexOutOfBoundsException();
    return daArray[i];
  }

  public T set(int i, T e) {
    if (i<0 || i>=size)
      throw new IndexOutOfBoundsException();
    T temp = daArray[i];
    daArray[i]=e;
    return temp;
  }

  public void add(int i, T e) {
    if (i<0 || i>size)
      throw new IndexOutOfBoundsException();
    if (size==daArray.length)
      throw new IndexOutOfBoundsException();
    for (int ind = size; ind >i; ind--)
      daArray[ind]=daArray[ind-1];
    daArray[i]=e;
    size++;
  }

  public T remove(int i) {
    if (i<0 || i>=size)
      throw new IndexOutOfBoundsException();
    T temp = daArray[i];
    for (int ind = i; ind < size; ind++)
      daArray[ind]=daArray[ind+1];
    size--;
    return temp;
  }

  public int size() {
    return size; //O(1)!
  }

  public String toString(){
    String s = "[ ";
    for(int i=0;i<this.size();i++){
      s += "" + get(i) +" ";
    }
    s += "]";
    return s;
  }


}
