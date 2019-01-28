# Java 中的 this 和 super 关键字

## this 的用法

`this`指向的是当前对象，是当前对象的引用，利用`this`关键字可以访问当前对象的字段和方法，其用法为：

1. 访问当前对象的字段

   尤其是形参和当前对象字段同名时，使用`this`能将二者进行区分

   例如：

   ```java
   public class Animal() {
     private int age;
     private double weight;
   
     public Animal(int age, double weight) {
       this.age = age; // 其中，this.age指代Animal的字段、age指代Animal构造函数的形参
       this.weight = weight;
     }
   }
   ```

2. 调用当前对象的方法

   在当前的对象的方法中可以使用`this`关键字调用该对象的其他方法

   ```java
   public class Calc() {
     private int result;
   
     public Calc(int initial) {
       this.result = initial;
     }
     
     public add() {
       return this.result + 1;
     }
     
     public printResult() {
       System.out.println(this.add()); // 调用Calc的add()方法
     }
   }
   ```

3. 调用当前对象的构造函数

   当对象的构造函数的参数较多时，可以利用`this`关键字将构造函数进行拆分

   ```java
   public class User {
     public String username;
     public String password;
     public String email;
     
     public User(String username, String password) {
       this.username = username;
       this.password = password;
     }
     
     public User(String username, String password, String email) {
       this(username, password); // 调用另一个构造函数
       this.email = email;
     }
   }
   ```

   

## super 的用法

`super`指向的是父类对象，是父类对象的引用，其用法主要有：

1. 访问父类的字段和方法

   - 当子类中的字段和父类同名时，父类中对应的字段会被隐藏（及时两个字段的类型不同）；
   - 当子类重写了父类的方法时，父类中对应的方法会被隐藏。

   在这两种情况下，如果想在子类中访问父类中的字段和方法可以利用`super`关键字。

   例如：

   ```java
   public class Animal() {
     public Animal() {}
     public void cry() {
       System.out.pintln("嗷呜");
     }
   }
   
   public class Cat extends Animal() {
     pulic Cat() {}
     public void cry() {
       super.cry(); // 调用父类Animal的cry()方法
       System.out.println("喵呜");
     }
   }
   ```

   

2. 调用父类的构造函数

   如果父类的构造函数是带参数的，子类需要通过`super`关键字显式的调用父类的构造函数来继承父类。

   例如：

   ```java
   public class Animal() {
     private int age;
     private double weight;
   
     public Animal(int age, double weight) {
       this.age = age;
       this.weight = weight;
     }
   }
   
   public class Cat extends Animal() {
     public Cat(int age, double weight) {
       super(age, weight); // 调用父类的构造函数
     }
   }
   ```

   