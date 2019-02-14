# final 关键字

`final`关键字可以用来修饰变量、方法、类。

## final 变量

被声明为`final`的变量是只读的，如果希望变量在程序运行的过程中保持不变，可将其声明为`final`，可以与`static`关键字结合来声明一个常量，即

```java
public static final String LOAN = "loan";
LOAN = new String("loan"); //invalid compilation error
```

如果`final`修饰的是一个引用类型，则意味着该变量的指向（或者说该变量保存的地址是不变的）但其内部状态（即该地址下存储的内容）是可变的，例如：

```java
final StringBuilder sb = new StringBuilder("Geeks");
sb.append("ForGeeks"); // 这是合法的，对数组来说也是如此
```

当变量被`final`修饰时，变量名应全大写，单词间用下划线分隔。

`final`变量声明后 **必须** 被初始化（但不要求声明后立即初始化），且不能被再次赋值。给`final`变量初始化的三种方式：

- 在声明时初始化

- 在构造函数或 instance-initializer block 内初始化，如：

  ```java
  static final double CAPACITY; 
  // instance-initializer block;
  { 
  	CAPACITY = 25; 
  } 
  ```

- 在 static block 中初始化，如：

  ```java
  static final double EULERCONSTANT; 
  // static block
  static { 
  	EULERCONSTANT = 2.3; 
  }
  ```

## final 方法

被`final`修饰的方法不可被子类重写，如果不希望子类改变某个方法，则可将其声明为`final`。例如，Object类的方法都被声明为`final`。

示例：

```java
class PersonalLoan{
    public final String getName(){
        return "personal loan";
    }
}
 
class CheapPersonalLoan extends PersonalLoan{
    @Override
    public final String getName(){
        return "cheap personal loan"; //compilation error: overridden method is final
    }
}
```

方法被声明为`final`后执行效率更高（在方法较为简单的前提下），因为其在编译时已经静态绑定了，不需要在运行时动态绑定。

## final 类

被`final`修饰的类不能被继承，例如，String、和Integer、Float等不可变类。

示例：

```java
final class PersonalLoan{}
 
class CheapPersonalLoan extends PersonalLoan{  //compilation error: cannot inherit from final class 
}
```

因此，抽象类和接口不能用`final`修饰，因为抽象类和接口必须被继承。

## final关键字的好处

1. final关键字提高了性能。JVM和Java应用都会缓存final变量。
2. final变量可以安全的在多线程环境下进行共享，而不需要额外的同步开销。
3. 使用final关键字，JVM会对方法、变量及类进行优化。