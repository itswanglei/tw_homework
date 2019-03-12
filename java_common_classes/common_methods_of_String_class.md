# String 类的常用方法

## compareTo方法

- 用途：比较两字符串，返回值为整型

- 源码：

  ```java
  public int compareTo(String anotherString) {
      int len1 = value.length;
      int len2 = anotherString.value.length;
      int lim = Math.min(len1, len2); // 取两字符串中较短字符串的长度
      char v1[] = value;
      char v2[] = anotherString.value;
  
    	// 在上述长度区间内依次对比各字符是否相等 
    	int k = 0;
      while (k < lim) {
      		char c1 = v1[k];
      		char c2 = v2[k];
      		if (c1 != c2) {
      				return c1 - c2; // 当某位置处两字符串中的字符不相等时，返回不相等字符的ASCII码差值
      		}
      		k++;
      }
      return len1 - len2; // 若上述长度区间内所有字符均相等则返回两字符串长度的差
  }
  ```

- 举例：

  ```java
  public class CompareToExample {
     public static void main(String args[]) {
         String str1 = "String method tutorial";
         String str2 = "compareTo method example";
         String str3 = "String method tutorial";
         String str4 = "String method ";
  
         int var1 = str1.compareTo(str2);
         System.out.println(var1); // -16（返回字符S和字符c的ASCII码差值：83 - 99）
  
         int var2 = str1.compareTo(str3);
         System.out.println(var2); // 0
  
         int var3 = str2.compareTo("compareTo method example");
         System.out.println(var3); // 0
         
         int var4 = str3.compareTo(str4);
         System.out.println(var4); // 8（返回两字符串长度差）
     }
  }
  ```

## concat方法

- 用途：拼接字符串，返回值为String

- 源码：

  ```java
  public String concat(String str) {
      int otherLen = str.length(); // 获得待拼接字符串的长度
      if (otherLen == 0) {
      		return this; // 若传入的字符串长度为0则返回原字符串
      }
      int len = value.length; // 获得原字符串的长度
      char buf[] = Arrays.copyOf(value, len + otherLen); // 定义一个大小为原字符串和传入字符串长度之和的char数组，并将原字符串存储到该数组中
      str.getChars(buf, len); // 将传入字符串放入char数组存储的原字符串字符之后
      return new String(buf, true); // 由char数组生成新字符串并返回
  }
  ```

- 举例：

  ```java
  String s1 = "Hello";
  String s2 = " ";
  String s3 = "world";
  
  String s4 = s1.concat(s2).concat(s3);
  System.out.println(s4); // Hello world
  ```

## equals方法

- 用途：比较两字符串是否相同，返回值为布尔值

- 源码：

  ```java
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

- 举例：

  ```java
  String s1 = new String("HELLO"); 
  String s2 = new String("HELLO"); 
  System.out.println(s1.equals(s2)); // true
  ```

## equalsIgnoreCase方法

- 用途：在忽略大小写的前提下比较两字符串是否相同，返回值为布尔值

- 举例：

  ```java
  String s1 = new String("apple);
  String s2 = new String("Apple");
  System.out.println(s1.equalsIgnoreCase(s2)); // true
  ```

## contentEquals方法

- 用途：比较字符串和传入的对象的内容是否相同，返回值为布尔值

  - 该方法与equals和equalsIgnoreCase方法的区别在于，equals和equalsIgnoreCase方法首先检查传入的参数是否为字符串再进行比较，而contentEquals方法仅比较两者的内容

- 源码：

  ```java
  // 先判断传入参数的类型，当传入参数为字符串时，使用equals方法比较，当传入参数不为字符串时仅比较传入参数的内容与原字符串是否相同
  public boolean contentEquals(CharSequence cs) {
      // Argument is a StringBuffer, StringBuilder
      if (cs instanceof AbstractStringBuilder) {
          if (cs instanceof StringBuffer) {
              synchronized(cs) {
                 return nonSyncContentEquals((AbstractStringBuilder)cs);
              }
          } else {
              return nonSyncContentEquals((AbstractStringBuilder)cs);
          }
      }
      // Argument is a String
      if (cs instanceof String) {
          return equals(cs);
      }
      // Argument is a generic CharSequence
      char v1[] = value;
      int n = v1.length;
      if (n != cs.length()) {
          return false;
      }
      for (int i = 0; i < n; i++) {
          if (v1[i] != cs.charAt(i)) {
              return false;
          }
      }
      return true;
  }
  
  private boolean nonSyncContentEquals(AbstractStringBuilder sb) {
      char v1[] = value;
      char v2[] = sb.getValue();
      int n = v1.length;
      if (n != sb.length()) {
          return false;
      }
      for (int i = 0; i < n; i++) {
          if (v1[i] != v2[i]) {
              return false;
          }
      }
      return true;
  }
  ```

- 举例：

  ```java
  String s = "hello world";
  StringBuilder sb = new StringBuilder("hello world");
  
  System.out.println(s.equals(sb)); // false
  System.out.println(s.contentEquals(sb)); // true
  ```

## join方法

- 用途：用特定符号连接字符串，返回值为字符串

- 方法签名：

  ```java
  // 第一个参数为指定的连接符号，其余参数为待连接字符串
  public static String join(CharSequence delimiter,
                            CharSequence... elements)
  ```

- 举例：

  ```java
  String message = String.join("-", "This", "is", "a", "String"); // This-is-a-String
  
  List list<String> = Arrays.asList("Steve", "Rick", "Peter", "Abbey");
  String names = String.join(" | ", list); // Steve | Rick | Peter | Abbey
  ```

## split方法

- 用途：用特定符号分割字符串，返回值为字符串数组

- 方法签名：

  ```java
  // 第一个参数为正则表达式
  // 第二个参数为可选参数，用于指定分割处的子字符串的数量；当其为0时将返回除末尾空字符串外的所有子字符串；当其为负数时将返回全部子字符串
  String[] split(String regex, int limit)
  ```

- 举例：

  ```java
  String s = "bbaaccaa";
  Sting arr1[] = s.split("a"); // arr1 = ["bb", "cc", ""]
  Sting arr2[] = s.split("a", 1); // arr2 = ["bb"]
  String arr3[]= s.split("a", -1); // arr3 = ["bb", "cc", ""]
  String arr4[]= s.split("a", 0); // arr4 = ["bb", "cc"]
  ```

## trim方法

- 用途：去除字符串首尾的空格，返回值为字符串

- 举例：

  ```java
   String str = new String("    How are you??   ");
   System.out.println("String after trim: "+str.trim()); // How are you??
  ```

## isEmpty方法

- 用途：判断字符串是否为空，返回值为布尔值

- 举例：

  ```java
  String str1="";  
  String str2="hello";  
  
  System.out.println(str1.isEmpty()); // true
  System.out.println(str2.isEmpty()); // false
  ```

  