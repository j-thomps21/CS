public class TestAL{
  public static void main(String[] args) {
    CircularArrayList<Integer> list = new CircularArrayList<Integer>();

    list.push(0);
    list.push(1);
    list.push(2);
    list.push(3);
    list.push(4);
    System.out.println(list.toString());
    System.out.println("Removed: " + list.remove(0));
    System.out.println("Removed: " + list.remove(1));
    System.out.println("Removed: " + list.remove(2));

    System.out.println(list.toString());
    System.out.println("Head = " + list.head);
  }
}
