package pkg3;

public class C { // 该类为外部类，访问权限不能为private，否则编译不通过
  private int field; // 该字段的访问权限为private

  private class B {} // 该类为内部类，访问权限可以为private

  private void method() {
    // 该方法的访问权限为private
    System.out.println(this.field); // 类内部可以访问私有字段
  }
}


