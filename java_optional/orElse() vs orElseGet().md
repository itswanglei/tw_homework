# Java Optional 的 orElse() 和 orElseGet() 的区别

### 1. 接收的参数不同

`orElse()`方法以一个自定义类型的数据作为参数

```java
public T orElse(T t)
```

`orElseGet()`方法以一个`Supplier`类型的数据作为参数

```java
public T orElseGet(Supplier<? extends T> other)
```

### 2. 程序的执行过程不同

以下面一段代码为例：

```java
public static void main(String[] args) {
    String[] names = new String[]{"zhang", "wang", "li", "zhao", "wu"};
    Optional.of("wang").orElse(getRandomName(names)); // 执行该句时会打印"Generating a name..."
    Optional.of("wang").orElseGet(() -> getRandomName(names));
}

public static String getRandomName(String[] names) {
    System.out.println("Generating a name...");
    Random random = new Random();
    return names[random.nextInt(5)];
}
```

在上述代码在运行`Optional.of("wang").orElse(getRandomName(names))`时会打印"Generating a name..."，而在运行`Optional.of("wang").orElseGet(() -> getRandomName(names))`时没有任何输出，这说明了`orElse()`中的函数`getRandomName`被调用了，而`orElseGet()`中的Lambda表达式没有执行。

产生上述现象的原因是，无论Optional对象中的值是否为空，`orElse()`函数都会执行；而由于`orElseGet()`中的参数为一个`Supplier`方法，该方法的特点是仅在必要的时候执行，因此只有在Optional对象中的值为空时，`orElseGet()`中的`Supplier`方法才会执行。

### 3. 性能差异

由于`orElse()`和`orElseGet()`执行过程的差异，`orElseGet()`方法的执行效率相对而言也更快，这是因为他会跳过不必要的方法调用。

因此，**只有当默认值已经事先定义的情况下，才使用`orElse()`，否则使用`orElseGet()`更好**。

---
### 参考
- [Java Optional – orElse() vs orElseGet()](https://www.baeldung.com/java-optional-or-else-vs-or-else-get)