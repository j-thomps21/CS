public static class CPair
{
  Fooable x, y;
  public CPair(Fooable o1, Fooable o2)
  {
    x = o1;
    y = o2;
  }
  public Fooable first() { return x ;}
  public Fooable second() { return y; }

  public static class Bat implements Fooable
  {
    int val;
    public Bat(int k) { val = k; }
    public String foo() { return "Bat" + val; }
    public int bar() { return val*val; }
  }

  public static class Pig implements Fooable
  {
    String lab;
    public Pig(String s) { lab = s; }
    public String foo() { return "Pig" + lab; }
  }

  public static void main(String[] args) {
    APair a = new APair(new Bat(7), new Pig("Q"));
    BPair<Bat> b = new BPair<Bat>(new Bat(8), new Bat(9));
    CPair c = new CPair(new Bat(5), new Pig("Z"));
  }
}
