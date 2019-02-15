# Java 面向对象的三大特性

## 封装

- 将类的某些信息隐藏在类内部，不允许外部程序直接访问，而是通过该类提供的方法来实现对隐藏信息的操作和访问。

- 好处：
  - 只能通过规定的方法访问数据。
  - 隐藏类的实例细节，增加安全性、方便修改和实现。　

```java
public class Person {
  private String name;
  private int age;
  
  public Person(String name, int age) {
    this.name = name;
    this age = age;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getAge() {
    return this.age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
}
```

## 继承

- 好处：子类拥有父类的所有属性和方法（除了private修饰的属性不能拥有）从而实现了实现代码的复用

  ```java
  public class Student extends Person {
  	privete long studentId;
  	
    public Student(String name, int age, long studentId) {
      super(name, age);
      this.studentId = studentId;
    }
    
    public long getStudentId() {
      return this.studentId;
    }
    
    public void setStudentId(long studentId) {
      this.studentId = studentId;
    }
  }
  ```

- 继承的方式：
  - 普通类继承普通类、继承抽象类、实现接口
  - 抽象类继承普通类、继承抽象类、实现接口
  - 接口继承接口

## 多态

- 不同子类的相同属性的值不同、相同方法的实现不同（通过方法的重写）

```java
public abstract class Animal {
  public void cry();
}

public class Cat extends Animal {
  public void cry() {
    System.out.println("喵喵喵");
  }
}

public class Dog extends Animal {
  public void cry() {
    System.out.println("汪汪汪");
  }
}
```

