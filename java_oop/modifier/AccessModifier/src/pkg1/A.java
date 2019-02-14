package pkg1;

class A implements B { // 该类的访问权限为default
  int field; // 该字段访问权限为default

  void method(int aInt) {
    // 该方法的访问权限为default
  }

  @Override
  public void method1() {
    System.out.println("Implements method1.");
  }

  @Override
  public void method2() {
    System.out.println("Implements method2.");
  }
}

interface B { // 该接口的访问权限为default
  void method1();

  void method2();
}

class C {
  public void method3() {
    A a = new A();
    a.method(a.field);
  }
}