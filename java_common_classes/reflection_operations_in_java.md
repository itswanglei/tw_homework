# 【转】Java编程学习之反射技术及其应用

（原文链接：[java编程学习之反射技术及其应用](https://www.jianshu.com/p/2072013aa577))

说明：原文中给出的代码示例由于格式问题不易阅读，本文进行了整理，并修改了部分例子。

另，本文未整理“泛型的本质”和“动态代理和AOP”这两节，这些内容请参考原文。

---

翻阅了很多资料想查看一个比较通俗易懂的关于Java反射机制的理解，但是想要从概念中去理解一项技术，可能有点困难，所以先将理论型知识贴出来，后面，慢慢来理解。

> 反射是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制。

注意：要理解Java的反射机制，先要了解以下基本概念：运行时，编译时，编译型，解释型，类加载器，动态加载类。

## Class类的使用

### 概念理解

在Java中，每个class都有一个相应的Class对象。也就是说，当我们编写一个类，编译完成后，在生成的.class文件中，就会产生一个Class对象，用于表示这个类的类型信息。

### 获取Class实例的方式

不能直接创建Class的实例对象，因为Class类的构造方法是私有的，只有jvm可以去创建，因此获取Class实例的几种方式为：

- 利用对象调用`getClass()`方法获取该对象的Class实例；

- 使用Class类的静态方法`forName()`，用类的名字获取一个Class实例；

- 运用`.class`的方式获取Class实例，对于基本数据类型的封装类，还可以采用TYPE来获取对应的基本数据类型的Class实例；
- 使用类的加载器ClassLoader的`loadClass()`方法获取一个Class实例；

综上所述，其实我们代码中创建的每一个类都是一个对象，只不过它是Class类的实例对象，这个对象我们称为该类的类类型。并且一个类只可能是Class类的一个实例对象，即获取的类类型是相同的

那么，如何去创建Class的实例呢？

首先，过程要理解，源文件经过编译（javac.exe）以后，得到一个或多个`.class`文件。`.class`文件经过运行（java.exe）这步，就需要进行类的加载（通过JVM的类的加载器），记载到内存中的缓存。每一个放入缓存中的`.class`文件就是一个Class的实例！下面是创建Class实例的三种方法。

实例如下：

```java
public class ReflectTest {     
    public static void main(String[] args){ 
        ReflectTest reflectTest = new ReflectTest();
        
        // 类实例的getClass()方法
        Class clazz1 = reflectTest.getClass();
        
        // 类的.class
        Class clazz2 = ReflectTest.class; 
        
        // Class类的forName()方法
        Class clazz3 = null; 
        try { 
            clazz3 = Class.forName("com.william.test.ReflectTest"); 
        } catch (ClassNotFoundException e) { 
            e.printStackTrace(); 
        } 
        
        // 类加载器
        ClassLoader loader = this.getClass().getClassLoader(); 
        Class clazz4 = null; 
        try { 
            clazz4 = loader.loadClass("com.william.test.ReflectTest"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

### 根据类类型去创建类的实例

```java
ReflectTest reflectTest1 = null;
try { 
    reflectTest1 = (ReflectTest) clazz1.newInstance();//需要类有无参的构造方法
} catch (InstantiationException e | IllegalAccessException e) { 
    e.printStackTrace();
}
```

### 动态加载类

`Class.forName("类的全称")`表示类的类类型，还代表了动态加载类

区分上面所说的“编译”和“运行”，编译时刻加载类是静态加载类，运行时刻加载类是动态加载类

关于动态加载类的实例代码请参考：[2-1 Java动态加载类](http://www.imooc.com/video/3733)

### 获取方法信息

获取方法的信息，主要通过Method类数组来接受`getMethods()`方法的返回值，然后进行遍历解析。

```java
/*打印类的信息，包括类的成员函数，成员变量*/
public class ClassUtil {
    public static void printMethodMessage(Object object) { 
        //获取类的类类型 
        Class clazz = object.getClass();
        System.out.println("类的名称是：" + clazz.getName());
        
        /* Method类，方法对象 
         * 一个成员方法就是一个Method对象 
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的 
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不论访问权限 */ 
        Method[] methods = clazz.getDeclaredMethods(); 
        for (int i = 0; i < methods.length; i++) { 
            //1. 获取注解 
            Annotation[] ann = methods[i].getAnnotations(); 
            for (Annotation a : ann) { 
                System.out.println(a); 
            } 
            //2. 获取权限修饰符 
            String str = Modifier.toString(methods[i].getModifiers()); 
            System.out.print(str + " "); 
            //3. 得到方法的返回值类型的类类型 
            Class returnType = methods[i].getReturnType(); 
            System.out.print(returnType.getName() + " "); 
            //4. 得到方法的名称 
            System.out.print(methods[i].getName() + "("); 
            //5.获取参数类型-->得到的是参数列表的类型的类类型 
            Class[] paramTypes = methods[i].getParameterTypes(); 
            //解析数组 
            for (int j = 0; j < paramTypes.length; j++) { 
                if (j == 1 || j == paramTypes.length - 1) {
                    System.out.print(paramTypes[j].getName() + " args" + j); 
                } else { 
                    System.out.print(paramTypes[j].getName() + " args" + j + ","); 
                } 
            } 
            System.out.print(")"); 
            //6.获取异常类型 
            Class[] exps = methods[i].getExceptionTypes(); 
            if (exps.length != 0) { 
                System.out.print(" throws "); 
            } 
            for (int k = 0; k < exps.length; k++) {
                System.out.print(exps[k].getName() + " "); 
            } 
            System.out.println(); 
        } 
    } 
}

public class Person {
    private final String name;
    private final int age;
    private List<Person> friends;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "[name: " + this.name + ", age: " + this.age + "]";
    }

    public void beFriend(Person person) {
        this.friends.add(person);
    }
}

//测试
public class Main {

    public static void main(String[] args) {
        Person person = new Person("zhang", 23);

        ClassUtil classUtil = new ClassUtil();
        ClassUtil.printMethodMessage(person);
    }
}

//output
类的名称是：main.java.company.model.Person
public java.lang.String toString()
public void beFriend(main.java.company.model.Person args0)
```

### 获取成员变量信息

获取成员变量的信息，同获取方法的信息类似，只不过使用Field类数组来接收`getFieldss()`方法的返回值，然后进行解析。

```java
/*获取成员变量*/
public static void printFieldMessage(Object object) {
    //获取类的类类型 
    Class clazz = object.getClass();
    System.out.println("类的名称是：" + clazz.getName()); 
    
    /* 成员变量也是对象 
     * java.lang.reflect.Field 
     * Field类封装了关于成员变量的操作 
     * getFields()方法获取的是所有的public的成员变量的信息 
     * getDeclaredFields获取的是该类自己声明的成员变量的信息 */ 
    Field[] fields = clazz.getDeclaredFields(); 
    for (Field field : fields) { 
        //获取每个属性的权限修饰符 
        int i = field.getModifiers(); 
        String modifier = Modifier.toString(i); 
        //得到成员变量的类型的类类型 
        Class fieldType = field.getType(); 
        String typeName = fieldType.getName(); 
        //得到成员变量的名称 
        String fieldName = field.getName(); 
        System.out.println(modifier + " "+ typeName + " " + fieldName); 
    }
}

//测试
public class Main {

    public static void main(String[] args) {
        Person person = new Person("zhang", 23);

        ClassUtil classUtil = new ClassUtil();
        ClassUtil.printFieldMessage(person);
    }
}

//output
类的名称是：main.java.company.model.Person
private final java.lang.String name
private final int age
private java.util.List friends
```

### 获取构造函数

```java
/*获取对象的构造函数的信息*/
public static void printConMessage(Object object) { 
    //获取类的类类型 
    Class clazz = object.getClass();
    System.out.println("类的名称是：" + clazz.getName());
    
    /* 构造函数也是对象 
     * java.lang.Constructor中封装了构造函数的信息 
     * getConstructors获取所有的public的构造函数 
     * getDeclaredConstructors得到所有的构造函数 */ 
    Constructor[] constructors = clazz.getConstructors(); 
    for (Constructor constructor : constructors) {
        System.out.print(constructor.getName() + "("); 
        //获取构造函数的参数列表--->得到的是参数列表的类类型 
        Class[] paramTypes = constructor.getParameterTypes(); 
        for (Class clazz1 : paramTypes) { 
            System.out.print(clazz1.getName() + ","); 
        } 
        System.out.println(")"); 
    }
}

//测试
public class Main {

    public static void main(String[] args) {
        Person person = new Person("zhang", 23);

        ClassUtil classUtil = new ClassUtil();
        ClassUtil.printConMessage(person);
    }
}

//output
类的名称是：main.java.company.model.Person
main.java.company.model.Person(java.lang.String,int,)
```

## 方法的反射

方法的**名称**和方法的**参数列表**才能唯一决定某个方法

### 方法反射的操作

`method.invoke(对象，参数列表)`

示例：

```java
public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("zhang", 23);
        Person person2 = new Person("wang", 23);

        Class clazz = person1.getClass();
        try {
            Method method = clazz.getMethod("beFriend", Person.class);
            Object object = method.invoke(person1, person2);
        } catch (NoSuchMethodException | 
                 IllegalAccessException | 
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(person1.getFriends());

    }
}
```

## 成员变量的反射

```java
try {
    Class personClass = Class.forName("main.java.company.model.Person");
    Object personObject = personClass.newInstance();
    Person person = (Person) personObject;

    Field name = personClass.getDeclaredField("name");
    name.setAccessible(true);
    name.set(person, "li");

    Field age = personClass.getDeclaredField("age");
    age.setAccessible(true);
    age.set(person, 20);

    System.out.println(person);
} catch (ClassNotFoundException |
         IllegalAccessException |
         InstantiationException |
         NoSuchFieldException e) {
    e.printStackTrace();
}
```

## 构造函数的反射

```java
Class clazz2 = Person.class;
try {
    Constructor constructor = clazz2.getConstructor(String.class, int.class);
    Person person3 = (Person) constructor.newInstance("zhao", 19);
    System.out.println(person3);
} catch (NoSuchMethodException |
         IllegalAccessException |
         InstantiationException |
         InvocationTargetException e) {
    e.printStackTrace();
}
```

## 反射应用之动态代理

动态代理是指客户通过代理类来调用其他对象的方法，并且是在程序运行时根据需要动态创建目标类的代理对象。

```java
interface Subject {
    void action();
}

//被代理类
class SubjectImpl implements Subject {
    @Override 
    public void action() {
        System.out.println("我是被代理类"); 
    }
}

class MyInvocationHandler implements InvocationHandler {
    Object object;
    
    //给被代理的对象实例化，并返回一个代理类的对象
    public Object blind(Object object) {
        this.object = object; 
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this); 
    } 
    
    //当通过代理类的对象发起对被重写的方法的调用时，都会转化为对如下的invoke方法的调用 
    @Override 
    public Object invoke(Object proxy, Method method, Object[] args) 
        throws Throwable {
        //method方法的返回值是returnVal 
        return method.invoke(object, args); 
    }
}

public class ProxyTest { 
    public static void main(String[] args){ 
        //1. 创建被代理类对象 
        SubjectImpl realSubject = new SubjectImpl(); 
        //2. 创建一个实现了InvocationHandler接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler(); 
        //3. 调用blind()方法，返回一个同样实现了Subject接口的代理类的对象
        Object object = handler.blind(realSubject); 
        Subject subject = (Subject) object;
        subject.action();
    }
}
```

说明，了解动态代理和静态代理的区别，所谓的静态代理，其代理类和目标对象的类在编译期间就确定下来，不利于程序的扩展。即，每一个代理类只能为一个接口服务，也就是说程序开发中会产生很多代理类。

## 相关概念

**什么是编译？**

答：将原程序翻译成计算机语言，就是二进制代码。在Java中是将.java文件翻译成.class的字节码

**什么是编译时？**

答：将原程序翻译成计算机语言的过程中。将.java翻译为.class文件的过程

**什么是运行时？**

答：就是在启动这个程序的时候。在Java中是，类加载器加载.class文件，并交给JVM处理

**什么是编译型语言？**

答：将原程序一次性全部转换为二进制代码，然后执行程序

**什么是解释型语言？**

答：转换一句，执行一句，Java是既编译又解释的语言

**编译型语言和解释型语言的区别：**

答：编译型语言效率高，依赖于编译器，但是跨平台差，解释型的效率低，依赖于解释器，但跨平台强

**什么是类加载器？**

答：类加载器就是JVM中的类装载器，作用就是将编译好的.class字节码运到检查器进行安全检查的，检查通过后开始解释执行

**什么是运行时动态加载类？**

答：反射就是可以将一个程序（类）在运行的时候获得该程序（类）的信息的机制，也就是获得在编译期不可能获得的类的信息，因为这些信息是保存在Class对象中的，而这个Class对象是在程序运行时动态加载的

它就是可以在程序运行的时候动态装载类，查看类的信息，生成对象，或操作生成对象。类在运行的时候，可以得到该类的信息，并且可以动态的修改这些信息，自己能看到自己，跟照镜子一样，class对象是在运行的时候产生的，通过class对象操作类的信息是在运行时进行的，当运行程序的时候，类加载器会加载真正需要的类，什么是真正需要的呢？就是该类真正起作用，如：有该类的对象实例，或该类调用了静态方法属性等。

