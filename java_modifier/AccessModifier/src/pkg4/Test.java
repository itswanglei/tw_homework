package pkg4;

import pkg1.H;
import pkg1.K;

public class Test {
  public static void main(String[] args) {
    F f = new F();
    G g = new G(); // 是F类的同包子类
    H h = new H(); // 是F类的不同包子类

    f.method();
    g.method(); // protected方法是包内可见的
    h.method(); // protected方法是对子类可见的

    K k = new K();
    k.method(); // 编译不通过：'method()' has protected access in 'pkg1.K'
  }
}
