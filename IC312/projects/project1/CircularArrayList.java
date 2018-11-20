public class CircularArrayList<T> implements List<T>, Queue<T>, Stack<T>
{
  private T[] array;
  private int size;
   int head;

  @SuppressWarnings("unchecked")
  public CircularArrayList(){
    array = (T[]) new Object[1];
    size=0;
    head=0;
  }


  public T get(int i){
    if(i<0 || i >= head+size || i >= array.length)
      throw new IndexOutOfBoundsException();
    return array[(head+i)%array.length];
  }


  public T set(int i, T e){
    if(i<0 || i >= head+size || i >= array.length)
      throw new IndexOutOfBoundsException();
    T temp = array[i];
    array[i] = e;
    return temp;
  }


  public void add(int i, T e){
    if(i<0 || i > head+size || i > array.length)
      throw new IndexOutOfBoundsException();
    if(size == array.length){
      T[] nArray = (T[]) new Object[2*array.length];
      for(int j = 0; j < array.length; j++)
        nArray[j] = array[(head+j)%array.length];
      array = nArray;
      head = 0;
    }
    array[(head+size)%array.length] = e;
    size++;
  }

  public T remove(int i){
    if(i<0 || i >= head+size || i >= array.length)
      throw new IndexOutOfBoundsException();
    T temp = get(i);

    if(i == head)
      head = (head++)%array.length;
    else{
      if(i != (head+size)%array.length - 1){
        for(int j = i; j < (head+size)%array.length; j++)
          array[(head+j)%array.length] = array[(head+j)%array.length + 1];
      }
    }
    size--;
    return temp;
  }


  public int size(){
    return size;
  }


  public String toString(){
    String s = "[ ";
    for(int i = 0; i < size(); i++)
      s+= "" + get(i) + " ";
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

  //Queue Interface
  public void enqueue(T e){
    add(size(), e);
  }

  public T dequeue() throws IndexOutOfBoundsException{
    if(size == 0)
      throw new IndexOutOfBoundsException();
    return remove(size()-1);
  }

  //Shared Peek
  public T peek() throws IndexOutOfBoundsException{
    if(size == 0)
      throw new IndexOutOfBoundsException();
    return get(0);
  }
}
