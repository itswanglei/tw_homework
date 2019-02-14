package pkg4;

public class F { // 该类为外部类，访问权限不能为protected，否则编译不通过
  protected int field; // 该字段的访问权限为protected

  protected void method() {
    // 该方法的访问权限为protected
  }
}

