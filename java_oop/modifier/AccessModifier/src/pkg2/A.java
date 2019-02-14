package pkg2;

public class A implements B { // 该类的访问权限为public
  public int field; // 该字段的访问权限为public

  public void method(int aInt) {
    // 该方法的访问权限为public
  }

  @Override
  public void method1() {
    System.out.println("method1 is implemented.");
  }
}

