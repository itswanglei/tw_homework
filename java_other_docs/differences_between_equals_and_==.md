# Java 中 equals 和 == 的区别和联系

## 概述

### 相等操作符==

- `==`是一种操作符，比较左右操作数的值是否相同；

- 在使用`==`时要注意左右操作数的可比性，即左右操作数应为相同数据类型或子类和父类的关系，例如：

  ```java
  Thread t = new Thread(); 
  Object o = new Object(); 
  String s = new String("GEEKS"); 
  
  System.out.println(t == o); // false（t与o可比，因为Thread类是Object类的子类）
  System.out.println(o == s); // false（s与o可比，因为String类是Object类的子类）
  System.out.println(t == s); // error: incomparable types: Thread and String
  ```

### equals方法

- `equals()`是Object类的方法，由于Java中所有的类都是Object类的子类，因而所有的类均继承了`equals()`方法。Object中`equals()`方法的实现为：

  ```java
  public boolean equals(Object obj){
  		return (this == obj);
  }
  ```

  即原始的`equals()`方法使用`==`操作符比较两对象的地址，但我们可以通过重写`equals()`方法实现我们所需的比较方法，例如：

  ```java
  // 例1：
  class People {
      private String name;
      private int age;
       
      public People(String name,int age) {
          this.name = name;
          this.age = age;
      }  
      
      @Override
      public boolean equals(Object obj) {
          return this.name.equals(((People)obj).name) && this.age == ((People)obj).age; // 即通过比较属性值判断两对象是否相等
      }
  }
  // --------------------------------------------------------------------------------
  // 例2：String的equals()方法
  public boolean equals(Object anObject) {
     // 首先判断两个对象的内存地址是否相同
     if (this == anObject) {
         return true;
     }
     // 判断传入的对象是否为String类型
     if (anObject instanceof String) {
         String anotherString = (String)anObject;
         int n = value.length; // 获得原字符串长度
         //长度相同的情况下逐一比较 char 数组中的每个元素是否相同
         if (n == anotherString.value.length) {
             char v1[] = value; // 获得原字符串存储的字符数组
             char v2[] = anotherString.value; // 获得传入字符串存储的字符数组
             int i = 0;
             while (n-- != 0) {
                 if (v1[i] != v2[i])
                     return false;
                 i++;
             }
             return true;
         }
     }
     return false;
  }
  ```

- 重写`equals()`方法时需要注意的原则：

  > - 自反性（reflexive）：对于任意不为 null 的引用值 x，`x.equals(x)` 一定是 true。
  >
  > - 对称性（symmetric）：对于任意不为 null 的引用值 x 和 y ，当且仅当`x.equals(y)`是 true 时，`y.equals(x)`也是true。
  > - 传递性（transitive）：对于任意不为 null 的引用值x、y和z，如果 `x.equals(y)` 是 true，同时 `y.equals(z)` 是 true，那么`x.equals(z)`一定是 true。
  > - 一致性（consistent）：对于任意不为null的引用值x和y，如果用于equals比较的对象信息没有被修改的话，多次调用`equals()`方法返回值应保持一致。
  > - 对于任意不为 null 的引用值 x，`x.equals(null)` 返回 false。

## 相等操作符和equals方法的区别

1. `equals()`是方法，而`==`是操作符

2. 基本数据类型的比较使用`==`，对象的比较推荐使用`equals()`

   - 原因是：对象是引用数据类型，对象变量保存的是对象的存储地址，因而使用`==`比较对象实际上比较的是地址是否相同（即，是否指向同一处内存空间），而使用重写后的`equals()`方法可以比较两个对象的内容是否相同。

   例如：String是一种对象，我们在比较两个字符串时，希望比较的是字符串的内容而非存储的地址，因此String类重写了`equals()`方法

   ```java
   String s1 = new String("HELLO"); 
   String s2 = new String("HELLO"); 
   System.out.println(s1 == s2); // false：因为s1和s2是两个对象，存储的地址不同
   System.out.println(s1.equals(s2)); // true：因为s1和s2存储的内容相同
   ```

   

## 补充：hashcode方法

### hash算法

- 概念：hash算法也成散列算法，其作用是通过特定的运算将对象的键值映射成对象在集合中存储的位置。

- 用途：利用hash算法可以根据元素内容获得其存储位置，避免了遍历，方便在集合中查找特定元素。

- 举例：以一个简单的hash算法——除留余数法为例。

  （除留余数法：将需要存入数组除以某个常数（如数组的长度）后，以余数作为索引。）

  如，将 323 ，458 ，25 ，340 ，28 ，969， 77 使用「除留余数法」存储在长度为11的数组中，则每个数字在数组中存放的位置为：

  | 值   | 77   | 969  |      | 25   | 323  |      | 28   | 458  |      |      | 340  |
  | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
  | 索引 | 0    | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   |

  需要注意的是，不同元素经过hash后可能获得相同的散列值，在这种情况下需要进一步进行散列。

  因此可以知道，**不同散列值对应的元素一定是不同的，但不同元素的散列值可能相同**，**利用hash算法可以判断元素是否不相等**。

### hashCode方法

- 概念：Java中的`hashCode()`方法就是一种hash算法，它根据一定的规则将与对象相关的信息（比如对象的存储地址，对象的字段等）映射成一个数值，这个数值称作为散列值，其返回值为一个int型值。

- `hashCode()`方法和`equals()`方法的关系：

  - `hashCode()`方法和`equals()`方法是一套对应的方法

  - 对于两个对象，

    如果调用`equals()`方法得到的结果为true，则两个对象的`hashCode()`返回值必定相等；

    如果`equals()`方法得到的结果为false，则两个对象的`hashCode()`返回值不一定不同；

    如果两个对象的`hashCode()`返回值不等，则`equals()`方法得到的结果必定为false；

    如果两个对象的`hashCode()`返回值相等，则`equals()`方法得到的结果未知。

  - 原始的`hashCode()`方法返回的是对象的存储地址，**在重写`equals()`方法的同时，必须重写`hashCode()`方法**。

```java
// 示例：
class People{
    private String name;
    private int age;
     
    public People(String name,int age) {
        this.name = name;
        this.age = age;
    }  
    
  	// 只重写equals()方法
    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((People)obj).name) && this.age == ((People)obj).age;
    }
}
 
public class Main {
 
    public static void main(String[] args) {
        People p1 = new People("Jack", 12);
        System.out.println(p1.hashCode());
             
        HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
        hashMap.put(p1, 1);
         
        System.out.println(hashMap.get(new People("Jack", 12))); // 输出：null
    }
}
```

上述代码期望的输出为“1”，但实际的输出为`null`，发生上述现象的原因是：main函数最后一行实例化了另一个People对象，该对象的存储地址与p1不同，由于People类中只重写了`equals()`方法而未重写`hashCode()`方法，则hashMap的get方法无法根据hash值查找到对应的对象，因而返回`null`。如果希望上述代码按照期望输出“1”，则需要重写`hashCode()`方法，**使`equals()`方法和`hashCode()`方法在逻辑上保持一致**，例如：

```java
public int hashCode() {
		return name.hashCode()*37+age;
}
```



