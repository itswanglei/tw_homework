# Java学习中一些遗漏的知识点

- 标识符：指用来定义名称的东西，如类名、函数名、变量名…

- `true`、`false`、`null`不是关键字

- 编译器会给成员变量分配默认值，但不会给局部变量分配默认值

- `new`一个对象时JVM都做了什么？

  1. 类加载检查
  2. 分配内存空间
  3. 设置对象基本信息
  4. 调用构造函数初始化

  （参考：[Java对象的创建 —— new之后JVM都做了什么？](https://blog.csdn.net/Rainnnbow/article/details/52149586)）

- 处理异常的三种方式：捕获异常、声明异常、抛出异常

- 异常机制的好处：

  - 分离了异常处理的代码与常规代码
  - 将异常传递到了调用栈顶端
  - 对异常的类型进行的归类

  （参考：[Advantages of Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/advantages.html)）

- 隐藏静态方法和重写实例方法的区别：

  - 被调用的重写实例方法的版本是子类中的版本；
  - 被调用的隐藏静态方法的版本取决于它是从父类还是从子类实现调用的。

  （参考：[Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)）

- 当父类的实例方法与接口的默认方法重名时，子类调用方法时遵循的原则为：

  - 实例方法比接口的默认方法优先级更高；
  - 当子类实现的多个接口都继承自同一个父类时，且只有一个接口重写了父类的方法，则被接口重写过的方法优先级更高；
  - 当子类实现的几个接口的方法存在冲突时，必须在子类中指明用哪个方法

  （参考：[Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)）

- 重写的几个规则

  - 如果不能继承一个方法，则不能重写这个方法。
  - 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常。

  （参考：[Java 重写(Override)与重载(Overload)](http://www.runoob.com/java/java-override-overload.html)）

- 重载的关键点：重载方法时必须改变参数（类型或个数）

  （参考：[Java 重写(Override)与重载(Overload)](http://www.runoob.com/java/java-override-overload.html)）

- 构造函数调用的方法应当定义为`final`，避免子类重写该方法导致意外的结果

  （参考：[Writing Final Classes and Methods](https://docs.oracle.com/javase/tutorial/java/IandI/final.html)）

- 抽象类中的抽象方法最好加上`abstract`修饰符，而接口中的抽象方法不必加`abstract`修饰符

  （参考：[Abstract Methods and Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)）

- 一个类可以实现多个接口使用关键字implements ；

  一个接口可以继承多个接口使用关键字`extends`；

  一个类可以同时继承一个别的类，而且实现一个或多个接口，但是关键字`extends`要在前

  （参考：[Java基础 接口和抽象类](https://www.jianshu.com/p/eb77a2e64fda)）

- 接口如果新增了一个方法则所有实现该接口的类必须实现该方法，否则编译不通过，因此接口最好在定义时尽可能完善。如果确实需要扩展接口的功能，可以通过以下方式：

  - 使用一个新接口继承原接口，并在新接口中定义新的方法，这样继承原接口的类可以选择是否改用新的接口
  - 在原接口中定义默认方法或静态方法

  （参考：[Evolving Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/nogrow.html)）

- 当继承一个具有默认方法的接口时，可以有以下三种方式：

  - 若不提及该默认方法，则继承的接口继承了该默认方法
  - 若声明了该默认方法，则该方法成为一个抽象方法，需要实现新接口的类来实现
  - 重写该默认方法，实现新接口的类会调用该重写方法

  （参考：[Default Methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)）

- 可以利用静态方法在接口中定义一些工具方法以简化代码

  （参考：[Default Methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)）

- `protected`关键字不能用于修饰类

  （参考：[访问控制修饰符](https://github.com/EasonAndLily/JavaTrainingCamp/blob/master/JavaSE/Java%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E5%9F%BA%E7%A1%80/5.%E4%BF%AE%E9%A5%B0%E7%AC%A6.md)）

- `protected`的可见性：

  - 基类的 protected 成员是包内可见的，并且对子类可见；
  - 若子类与基类不在同一包中，那么在子类中，子类实例可以访问其从基类继承而来的protected方法，而不能访问基类实例的protected方法。

  （参考：[Java protected 关键字详解](http://www.runoob.com/w3cnote/java-protected-keyword-detailed-explanation.html)）

- 局部变量不能被声明为 static 变量；静态方法不能使用类的非静态变量。

  （参考：[访问控制修饰符](https://github.com/EasonAndLily/JavaTrainingCamp/blob/master/JavaSE/Java%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E5%9F%BA%E7%A1%80/5.%E4%BF%AE%E9%A5%B0%E7%AC%A6.md)）

- 将对象（即引用类型变量）传递给方法时，被调用的方法可以更改传递给它的对象的内容，但不能更改对象的地址；

  将值类型变量传递给方法时，只传递值类型变量的副本。被调用的方法无法访问其原始值，因此无法更改它。被调用的方法可以更改复制的值。

  （参考：[Chapter 4. Reference Types](https://www.oreilly.com/library/view/java-8-pocket/9781491901083/ch04.html)）

- String对象是不可更改的，但StringBuffer和StringBuilder对象是可修改的

  （参考：[Chapter 4. Reference Types](https://www.oreilly.com/library/view/java-8-pocket/9781491901083/ch04.html)）

- 枚举值既可以使用`equals()`方法比较也可以使用`==`比较

  （参考：[Chapter 4. Reference Types](https://www.oreilly.com/library/view/java-8-pocket/9781491901083/ch04.html)）

- 两个重载函数，一个参数为原始类型、另一个为包装类型（如List类的`remove(index i)`和`remove(Object o)`），在调用这两个函数时不会发生自动装箱。

  （参考：[Java中的自动装箱与拆箱](http://www.codeceo.com/article/java-auto-pack-unpack.html)）

- 使用`==`比较两个包装类型时不会发生自动装箱，就是在比较两个对象的地址

  （参考：[Java中的自动装箱与拆箱](http://www.codeceo.com/article/java-auto-pack-unpack.html)）

- LinkedHashMap与HashMap的不同之处在于它具有一个包含其所有键值对的双向链表，该链表定义了键值对的迭代排序，通常是插入的顺序。注意如果将以插入过的键值对重新插入map中，插入顺序不受影响（因为其插入时会先判断map中是否包含了该键值对）。

  （参考：[LinkedHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html)）

- ArrayList会按照插入顺序维护元素，而HashMap中元素默认是无序的。

  （参考：[Difference between ArrayList and HashMap in Java](<https://beginnersbook.com/2013/12/difference-between-arraylist-and-hashmap-in-java/>)）

- HashSet也不保证其内部元素的顺序为插入顺序

  （参考：[Difference between HashSet and HashMap](<https://beginnersbook.com/2014/08/hashset-vs-hashmap-java/>)）

- 使用泛型的好处：

  - 在编译期间有更强的类型检查（保证类型安全）
  - 避免强制类型转换（增加代码可读性并减少出错可能）
  - 提升性能（使类型转换工作全部在编译器中完成）

  （参考：[3. 泛型](<https://github.com/EasonAndLily/JavaTrainingCamp/blob/master/JavaSE/Java%E9%AB%98%E7%BA%A7%E7%89%B9%E6%80%A7/3.%E6%B3%9B%E5%9E%8B.md>)）

