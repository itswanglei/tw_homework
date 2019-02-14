# java中的自动装箱和拆箱机制

## 概念

- 自动装箱：将基本数据类型转换为包装器类型
- 自动拆箱：将包装器类型转换为基本数据类型

## 包装器类型

包装器类型即基本数据类型对应的对象类型，对应关系如下：

| 基本数据类型 | 包装器类型 |
| ------------ | ---------- |
| boolean      | Boolean    |
| byte         | Byte       |
| char         | Character  |
| int          | Integer    |
| short        | Short      |
| long         | Long       |
| float        | Float      |
| double       | Double     |

通过将基本类型包装成对象后，扩大了基本类型的操作（即可作为对象操作，如添加至collection中），且方便与String对象相互转换。

包装器类型的方法有：

- 构造函数：可用于将基本类型转换为包装器类型
- `valueOf()`：可用于将基本类型转换为包装器类型
- `byteValue()、shortValue()`等`xxxValue()`方法：可用于将包装器类型转换为基本数据类型
- `parseInt()`等`parseXxx()`方法：可用于将String对象转换为基本数据类型
- `toString()`方法：由Object对象继承而来，用于将包装器类型转换为String类型

## 自动装箱

装箱时编译器调用包装类型的`valueOf()`方法将基本数据类型转换为包装器类型

```java
// 示例：
// 1. 赋值时会发生自动装箱
int x = 1;
Integer y = x; // autoboxing

// 2. 调用方法时会发生自动装箱
public void test(Integer para) {}
int x = 1;
test(x); // autoboxing
```

## 自动拆箱

拆箱时编译器调用包装器类型的`xxxValue()`方法将包装器类型转换为基本数据类型

```java
// 示例：
Integer x = new Interger(1);
int y = x; // unboxing;
```

## 应注意的问题

由于包装器类型为对象，在进行比较时用`equals()`方法，而不要用`==`

```java
// 例如：
Integer x = 1;
Interer y = 1;
System.out.println("x == y : " + (x == y)); // true，原因是为了节省内存JVM会缓存-128-127的Integer对象，当值在该范围内时，对象会复用，即x和y指向同一个内存空间。

x = 200;
y = 200;
System.out.println("x == y : " + (x == y)); // false，此时值超出范围，不存在对象复用，因而x和y指向不同的内存空间。
System.out.println("x == y : " + (x.equals(y))); // true
```

