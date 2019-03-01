# Lambda 表达式和流

## 什么是Lambda表达式

Lambda表达式是一种简洁的语法形式

### 语法

```java
(Type1 param1, Type2 param2, ..., TypeN paramN) -> {
    statement1;
    statement2;
    //.............
    return statementM;
}
```

- **单参数语法：** 当Lambda表达式的参数个数只有一个，可以省略小括号
- **单语句语法：** 当Lambda表达式只包含一条语句时，可以省略大括号、return和语句结尾的分号
- **方法的引用：** 可以使用`Class or instance :: method`的形式更简洁的引用方法。
- 参数类型可以省略

### 注意

- Lambda表达式的上下文是包含该表达式的域，因此Lambda表达式中的`this`指向的是包含Lambda表达式的类，例如：

  ```java
  public class useLambda {
      public String value = "Enclosing scope value";
      
      public String scopeExperiment() {
          Function<String, String> fn = parameter -> {
              String value = "Lambda value";
              return this.value; // 返回的是"Enclosing scope value"
          };
      }
  }
  ```

- 尽量让Lambda表达式简洁，能直接看出其想要执行的操作，理想的Lambda表达式只有一行

  - 正例：

    ```java
    Foo foo = parameter -> buildString(parameter);
    
    private String buildString(String parameter) {
        String result = "Something " + parameter;
        //many lines of code
        return result;
    }
    ```

  - 反例：

    ```java
    Foo foo = parameter -> { String result = "Something " + parameter; 
        //many lines of code 
        return result; 
    };
    ```

- 在Lambda表达式中访问非常量的变量会导致编译错误

  

## 什么是流？

流是一系列的对象的流动序列，可以对它们进行顺序或并行操作。

## 流的特征

- 流不是一种数据结构，只是一系列对象的序列
- 流不改变原有的数据结构，只返回每个对象执行某个操作的结果
- 流的操作分为中间操作（只返回流）和最终操作

## 流操作

### 常用中间操作举例

- `map`：基于某种规则将集合中的元素映射成另一个元素

  ```java
  // 集合A中每个元素翻倍
  Integer[] array = new Integer[]{1, 3, 5, 4, 9};
  List<Integer> list = Arrays.asList(array);
  List<Integer> processedList = list.stream()
      .map(item -> item * 2)
      .collect(Collectors.toList());
  ```

- `filter`：基于某种规则对集合中的元素进行筛选

  ```java
  // 求集合中的偶数
  Integer[] array = new Integer[]{1, 2, 3, 4, 5};
  List<Integer> list = Arrays.asList(array);
  List<Integer> evenList = list.stream()
      .filter(item -> 0 == item % 2)
      .collect(Collectors.toList());
  ```

- `sorted`：基于某种规则对集合中的元素排序

  ```java
  // 元素从小到大排序
  Integer[] array = new Integer[]{3, 2, 4, 5, 1};
  List<Integer> list = Arrays.asList(array);
  List<Integer> sortedList = integers.stream()
      .sorted((a, b) -> a.compareTo(b))
      .collect(Collectors.toList());
  ```

- `distinct`：去除集合中的重复元素

  ```java
  Integer[] array = new Integer[]{1, 1, 2, 2, 3, 3};
  List<Integer> list = Arrays.asList(array);
  List<Integer> unrepeatedList = integers.stream()
      .distinct()
      .collect(Collectors.toList());
  ```

- `max`和`min`：求集合中元素的最大值和最小值

  ```java
  Integer[] array = new Integer[]{1, 5, 7, 2, 8, 9, 3, 2};
  List<Integer> list = Arrays.asList(array);
  int maximum = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
  int minimum = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
  ```

### 常用最终操作举例

- `collect`：由中间操作的结果创建集合

  ```java
  List<Integer> evenList = list.stream()
      .filter(item -> 0 == item % 2)
      .collect(Collectors.toList());
  ```

- `forEach`：对流中的每个元素进行某种操作

  ```java
  // 打印集合中的所有元素
  Integer[] array = new Integer[]{1, 2, 3, 4, 5};
  List<Integer> list = Arrays.asList(array);
  list.forEach(System.out::println);
  ```

- `reduce`：对流中的每个元素累计操作，返回累计结果

  ```java
  // 求集合中所有元素的和
  Integer[] array = new Integer[]{1, 2, 3, 4, 5};
  List<Integer> list = Arrays.asList(array);
  int summary = list.stream().reduce(0, (acc, cur) -> acc + cur);
  ```

---

### 参考

- [Lambda Expressions and Functional Interfaces: Tips and Best Practices](https://www.baeldung.com/java-8-lambda-expressions-tips)
- [Stream In Java](https://www.geeksforgeeks.org/stream-in-java/)

