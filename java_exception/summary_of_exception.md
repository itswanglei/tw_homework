# 异常

## 概念

异常是程序运行过程中可能发生的一类事件。

当方法中发生错误时，该方法会创建一个对象——异常对象——并将其交给runtime system（该过程称为 **抛出异常**）。

异常对象包含了错误信息，包括错误发生时的类型和程序状态。

当异常被抛出时，runtime system会从调用堆栈里寻找可以处理该异常的方法（exception handler)，当找到合适的exception handler时，即称为catch the exception；如果runtime system找不到合适的exception handler，则程序终止。

## 异常的处理与声明规则

- 使用`try-catch-finally`语句来捕获和处理异常

  - `try`块包含可能抛出异常的语句

    `catch`块是异常的接收者，用于处理异常

    `finally`块包含无论是否发生异常均需要运行的语句

  例如：

  ```java
  public int getNumberFromArray(int[] array, int index) {
    try {
      return array[index];
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("数组越界异常：" + e);
    }
  }
  ```
  - `try-catch-finally`规则：
    - 必须在 try 之后添加 catch （至少一个）或 finally 块。
    - 必须遵循块顺序：若同时使用 catch 和 finally 块，则顺序为：try-catch-finally
    - 当一个 try 块有多个 catch 时，执行第一个能匹配的块。
    - 可嵌套 try-catch-finally 结构。
    - 在 try-catch-finally 结构中，可重新抛出异常。
    - 除了下列情况，总将执行 finally 做为结束：
      - JVM 过早终止（调用 System.exit(int)）；
      - 在 finally 块中抛出一个未处理的异常；
      - 计算机断电、失火、或遭遇病毒攻击。

- 使用`throw`语句声明异常

  例如：

  ```java
  public int getNumberFromArray(int[] array, int index) throws ArrayIndexOutOfBoundsException {
    if (index > array.length) {
      throw new ArrayIndexOutOfBoundsException("数组越界异常");
    }
    return array[index];
  }
  ```

  - `throw`规则：
    - 必须声明方法可抛出的任何checked exception。
    - error和runtime exception不是必须声明的。
    - 调用方法必须遵循任何checked exception的处理和声明规则。声明的任何异常必须是被覆盖方法所声明异常的同类或子类。

但并非所有异常都适用于上述规则。

## 三类异常

- checked exception

  该类异常是可预测、可修复的

  如：`FileNotFoundException`、`ArrayIndexOutOfBoundException`

  checked exceptions适用于前述异常处理与声明规则，该类异常如果没有经过遵循前述规程的exception handler处理，则会编译不通过。

- error

  该类异常是发生于应用程序外部的特例，往往无法预测和修复

  如：`IOError`、`OutOfMemoryError`

  errors不适用于前述异常处理与声明规则

- runtime exception

  该类异常是发生于应用程序内部的特例，同样难以预测和修复。该类异常通常表示程序存在bug，例如逻辑bug或API的不当使用。

  如：`NullPointerException`、`ArithmeticException`

  runtime exceptions不适用于前述异常处理与声明规则

除以上三种类型外，还可以自定义异常。

## 常见异常举例

- `Java.lang.NullPointException`

  ```java
  public class Main {
  
    public static void main(String[] args) {
      int[][] arr = new int[2][];
      try {
        arr[0][1] = 1;
      } catch (NullPointerException e) {
        System.out.println("发生异常：" + e.getMessage());
      }
    }
  }
  // 输出：
  // 发生异常：null
  ```

- `Java.lang.ClassNotFoundException`

  ```java
  public class Main {
  
    public static void main(String[] args) {
      try {
        Class.forName("anotherPackage");
      } catch (ClassNotFoundException e) {
        System.out.println("发生异常：" + e.getMessage());
      }
    }
  }
  // 输出：
  // 发生异常：anotherPackage
  ```

- `Java.lang.ArithmeticException`

  ```java
  public class Main {
  
    public static void main(String[] args) {
      int a = 1;
      int b = 0;
      try {
        int result = a / b;
      } catch (ArithmeticException e) {
        System.out.println("发生异常：" + e.getMessage());
      }
    }
  }
  // 输出：
  // 发生异常：/ by zero
  ```

- ` Java.lang.ArrayIndexOutOfBoundsException`

  ```java
  public class Main {
  
    public static void main(String[] args) {
      int[] arr = new int[4];
      try {
        for (int i = 0; i < arr.length + 1; i++) {
          arr[i] = 1;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("发生异常：" + e.getMessage());
      }
    }
  }
  // 输出：
  // 发生异常：4
  ```

- `Java.lang.IllegalArgumentException`

  ```java
  import java.lang.reflect.Array;
  
  public class Main {
  
    public static void main(String[] args) {
      try {
        int arr = 0;
        Array.getLength(arr);
      } catch (IllegalArgumentException e) {
        System.out.println("发生异常：" + e.getMessage());
      }
    }
  }
  // 输出：
  // 发生异常：Argument is not an array
  ```

  