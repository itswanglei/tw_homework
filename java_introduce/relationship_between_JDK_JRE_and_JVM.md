# JDK、JRE、JVM 之间的关系

## 基本概念

### JDK

Java Development Kit 是用于开发 Java 应用程序的软件开发工具，包括了 Java 运行时的环境（JRE）、解释器（Java）、编译器（javac）、Java 归档（jar ——一种软件包文件格式）、文档生成器（Javadoc）等工具。

### JRE

Java Runtime Enviroment 提供 Java 应用程序执行时所需的环境，由 Java 虚拟机（JVM）、核心类、支持文件组成。

### JVM

Java Virtual Machine（Java 虚拟机）有三层含义，分别是：

- JVM规范要求
- 满足 JVM 规范要求的一种具体实现（一种计算机程序）
- 一个 JVM 运行实例，在命令提示符下编写 Java 命令以运行 Java 类时，都会创建一个 JVM 实例。

## 关系

JDK = JRE + 开发工具

JRE = JVM + 类库

![](https://cdn2.howtodoinjava.com/wp-content/uploads/2018/05/JDK-JRE-JVM.png)

### JDK 与 JRE 之间的交互

- 首先 JDK 中的编译器（javac）对代码进行编译——存储在`.java`文件中的源代码被编译成字节码存储在`.class`文件中
-  运行过程发生在 JRE 中：
  1. Class Loader 加载执行程序所需的全部类
  2. Byte Code Verifier 验证代码的格式和合法性
  3. Interpreter 加载并执行字节码

![上述操作之间的关系](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/JRE_JDK_JVM_2.jpg)

![](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/JRE_JDK_JVM_4.jpg)

### JVM 的工作方式

Java 程序运行时 JVM 是 JRE 的一个实例，也就是 runtime interpreter。它执行的是`.class`文件，它会将字节码翻译为平台可以执行的机器码。

## 总结

Java程序的开发过程为：

- 我们利用 JDK （调用 Java API）编写出 Java 源代码，存储于 `.java` 文件中
- JDK 中的编译器 javac 将 Java 源代码编译成 Java 字节码，存储于 `.class` 文件中
- JRE 加载、验证、执行 Java 字节码
- JVM 将字节码解析为机器码并映射到 CPU 指令集或 OS 的系统调用。