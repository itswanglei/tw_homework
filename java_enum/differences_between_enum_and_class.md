# 枚举类和类的异同

## 相同之处

- 枚举类也是类，同样具有成员变量、成员方法、构造器

  ```java
  public enum Week {
    	SUNDAY("星期日"), MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六");
      
      // 成员变量
      private String day;
      
      // 构造器
      Week(String day) {
          this.day = day;
      }
      
      // 成员方法
      @Override
      public String toString(){
          return day;
      }
  }
  ```

- 枚举类可以实现接口

  ```java
  public enum Week implements Workable {
    ...
  }
  ```

  

## 不同之处

- 枚举类的所有实例(枚举值)必须在枚举类的第一行显式地列出，否则这个枚举类将永远不能产生实例。所有的枚举值都是 public static final 的，列出这些枚举值时，系统会自动添加 public static final 修饰，无需程序员显式添加。

  ```java
  public enum Week {
  		// 枚举值
    	SUNDAY("星期日"), MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六");
      
     ...
  }
  ```

- 构造器只能使用 private 访问修饰符（且默认为 private），所以无法从外部调用构造器，构造器只在构造枚举值时被调用。这样做可以保证数据的安全性，使枚举值一定是由内部定义的，拒绝外部传入。

  ```java
  public enum Week {
    	SUNDAY("星期日"), MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六");
      
      private String day;
      
    	// 默认访问权限为private的构造器
      Week(String day) {
          this.day = day;
      }
  }
  ```

- 枚举类不能再派生子类，也不能再继承其他父类

  因为枚举类编译后生成一个 class 并且继承 Enum 类，反编译可以看到：

  ```java
  // final关键字限定枚举类不能派生子类，extends意味着枚举类已经继承了Enum类，因而不能继承其他父类
  final class Week extends Enum {
    ...
  }
  ```

- 枚举类自动拥有 values（用于获得包含全部枚举类实例的数组） 和 valueOf （返回指定的枚举类实例）方法

  ```java
  Week sunday = Week.valueOf("SUNDAY"); //返回Week类的SUNDAY实例
  Week[] days = Week.values(); // 返回Week的所有枚举值构成的数组，可用于遍历枚举类
  for(Week week : Week.values()) {
    ...
  }
  ```

- 枚举类可以有抽象方法，抽象方法可以由枚举值实现，使枚举值具有自己的特性

  ```java
  public enum Week {
    SUNDAY {
      String getSituation() {
        return "Good day!";
      }
    };
    
    abstract public String getSituation();
  }
  ```

