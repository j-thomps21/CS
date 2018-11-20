public interface List<T>{

  /**
  Return the element at index i in the list.

  @param index the index to get at
  @return the value of the elemnt at the inde
  **/
  public T get(int index) throws IndexOutOfBoundsException;


  /**
  Set the value of the element at index i to e

  @param index the index to set at
  @param element the value to set 
  @return the old value of the element set
  **/
  public T set(int index, T element) throws IndexOutOfBoundsException;

  /**
  Add an element e to the list at the index i

  @param index the index to add to
  @param element the value to add
  **/
  public void add(int index, T element) throws IndexOutOfBoundsException;

  /**
  Remove an element from the list at index i and return it

  @param index the index to be removed
  @return the element removed
  **/
  public T remove(int index)   throws IndexOutOfBoundsException;


  /**
  Returns the number of elements in the list

  @return the number of elements in the list
  **/
  public int size();
}
