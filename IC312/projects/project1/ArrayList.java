public class ArrayList<T> implements List<T>, Stack<T>
{
  private T[] array;
  private int size;

  @SuppressWarnings("unchecked")
  public ArrayList(){
    array = (T[]) new Object[1];
    size=0;
  }


  public T get(int i){
    if(i<0 || i >= size)
      throw new IndexOutOfBoundsException();
    return array[i];
  }


  public T set(int i, T e){
    if(i<0 || i >= size)
      throw new IndexOutOfBoundsException();
    T temp = array[i];
    array[i] = e;
    return temp;
  }


  public void add(int i, T e){
    if( i < 0 || i > size)
      throw new IndexOutOfBoundsException();
    if(size == array.length){
      T[] nArray = (T[]) new Object[2*array.length];
      for(int j = 0; j < array.length; j++)
        nArray[j] = array[j];
      array = nArray;
    }
    for(int j = size; j > i; j--)
      array[j] = array[j-1];
    array[i] = e;
    size++;
  }

  public T remove(int i) throws IndexOutOfBoundsException{
    if(i >= size || i < 0)
      throw new IndexOutOfBoundsException();
    T data = get(i);
    if(i != size-1){
      for(int j = i; j < size; j++){
        array[j] = array[j+1];
      }
    }
    size--;
    return data;
  }


  public int size(){
    return size;
  }


  public String toString(){
    String s = "[ ";
    for(int i = 0; i< size(); i++)
      s += "" + get(i) + " ";
    s+="]";
    return s;
  }


  //Stack Interface
  public void push(T e){
    add(size(), e);
  }


  public T pop() throws IndexOutOfBoundsException{
    if(size == 0)
      throw new IndexOutOfBoundsException();
    return remove(size-1);
  }


  public T peek() throws IndexOutOfBoundsException{
    if(size == 0)
      throw new IndexOutOfBoundsException();
    return get(0);
  }
}
