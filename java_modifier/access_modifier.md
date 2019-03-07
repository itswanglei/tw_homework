# 访问控制修饰符用法总结

访问控制修饰符一共四类：`default`、`public`、`private`、`protected`

## default

- 关键字：无。不写访问控制修饰符即为`default`

- 访问权限：同一包内可见

- 修饰对象：类、接口、变量、方法

```java
import pkg1.A;

public class Main {

  public static void main(String[] args) {
    A a = new A(); // 编译不通过：'pkg1.A' is not public in 'pkg1'. Cannot be accessed from outside package
  }
}

// ---------------------------------------------------------------------

package pkg1;

class A implements B { // 该类的访问权限为default
  int field; // 该字段访问权限为default

  void method(int aInt) {
    // 该方法的访问权限为default
  }

  @Override
  public void method1() {
    System.out.println("method1 is implemented.");
  }
}

interface B { // 该接口的访问权限为default
  void method1();
}

class C {
  public void method3() {
    A a = new A();
    a.method(a.field); // 同包内可以访问权限为default的类、方法、字段
  }
}
```

## public

- 关键字：`public`
- 访问权限：对所有类可见
- 修饰对象：类、接口、变量、方法

```java
import pkg2.A;

public class Main {

  public static void main(String[] args) {
    A a = new A();
    a.method(a.field); // 所有类均可以访问权限为public的class A
  }
}

// ---------------------------------------------------------------------

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

public interface B { // 该接口的访问权限为public
  public void method1();
}


```

## private

- 关键字：`private`
- 访问权限：在同一类内可见
- 修饰对象：变量、方法，**不能修饰类（外部类）、接口**

```java
import pkg3.C;

public class Main {
  
  public static void main(String[] args) {
    C c = new C();
    c.method(0); // 编译不通过：'method()' has private access in 'pkg3.C'
  }
}

// ---------------------------------------------------------------------
package pkg3;

public class C { // 该类为外部类，访问权限不能为private，否则编译不通过
  private int field; // 该字段的访问权限为private

  private class B {} // 该类为内部类，访问权限可以为private

  private void method() {
    // 该方法的访问权限为private
    System.out.println(this.field); // 类内部可以访问私有字段
  }
}

package pkg3;

private interface E { // 编译不通过：Modifier 'private' not allowed here
	//...
}

```

## protected

- 关键字：`protected`
- 访问权限：
  - 基类的protected成员是包内可见的，并且对子类可见；
  - 若子类与基类不在同一包中，那么在子类中，子类实例可以访问其从基类继承而来的protected方法，而不能访问基类实例的protected方法。
- 修饰对象：变量、方法。 **不能修饰类（外部类）、接口**

```java
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

// ---------------------------------------------------------------------
package pkg4;

public class F { // 该类为外部类，访问权限不能为protected，否则编译不通过
  protected int field; // 该字段的访问权限为protected

  protected void method() {
    // 该方法的访问权限为protected
  }
}

public class G extends F {} // 同包子类

// ---------------------------------------------------------------------
package pkg1;

import pkg4.F;
import pkg4.Test;

public class H extends F {} // 不同包子类

public class K extends Test {
  protected void method() {
    //...
  }
}
```

