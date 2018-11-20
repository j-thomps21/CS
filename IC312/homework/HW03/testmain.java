public class testmain
{
  public static void main(String[] args) {
    LinkedList<Integer> l = new LinkedList<Integer>();
    l.add(0, 1);
    l.add(1, 2);
    l.add(2, 1);
    l.add(3, 4);
    l.add(4, 1);
    l.add(5, 6);
    l.add(6, 1);
    l.add(7, 8);
    l.add(8, 1);
    System.out.println("Size of list is: " + l.size());
    System.out.println("Before: " + l.toString());
    l.removeElement(1);
    l.remove(2);
    l.set(2, 10000);
    System.out.println("After: " + l.toString());
    System.out.println("Max is: "+l.max());
    System.out.println("Size of list is: " + l.size());
  }
}
