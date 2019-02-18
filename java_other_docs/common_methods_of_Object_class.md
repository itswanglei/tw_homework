# Object类的常用方法

## clone方法

- 用途：使自定义对象可复制

- 使用：在自定义类中实现Cloneable接口的clone方法

- 注意事项：当对象的字段存在引用类型时应注意浅拷贝和深拷贝的问题

  - 浅拷贝仅复制变量的值，则对于引用字段来说复制了其地址，因而修改clone出的对象会影响原对象
  - 深拷贝则会对对象的引用字段实现拷贝

- 举例：

  **浅拷贝**

  ```java
  public class Student implements Cloneable {
      
      private String name;
      
      private Professor professor; // 引用类型字段
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public Professor getProfessor() {
          return professor;
      }
  
      public void setProfessor(Professor professor) {
          this.professor = professor;
      }
  
  		// 实现clone方法
      public Object clone() throws CloneNotSupportedException{
          return super.clone();
      }
  }
  
  public class Professor {
  
      private String name;
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  
  // 浅拷贝
  public class ShadowCopy {
  
      public static void main(String[] args) {
          Professor p1 = new Professor();
          p1.setName("Professor Zhang");
  
          Student s1 = new Student();
          s1.setName("xiao ming");
          s1.setProfessor(p1);
  
          try {
              Student s2 = (Student) s1.clone(); // clone
              Professor p2 = s2.getProfessor();
              p2.setName("Professor Li"); // s1和s2的引用字段指向的是同一个professor对象，修改s2的引用字段会影响s1的引用字段
              s2.setProfessor(p2);
          } catch (CloneNotSupportedException e) {
              e.printStackTrace();
          }
      }
  }
  ```

  **深拷贝**

  ```java
  public class Professor implements Cloneable {
  
      ...
  		
  		// 实现clone方法
      public Object clone() throws CloneNotSupportedException{
          return super.clone();
      }
  }
  
  public class Student implements Cloneable {
      
      ...
      
      // 实现clone方法
      public Object clone() throws CloneNotSupportedException{
          Student newStudent = (Student) super.clone();
          newStudent.professor = (Professor) professor.clone(); // 对student对象的引用字段进行clone
          return newStudent;
      }
  
  }
  ```

## equals方法

- 用途：比较两个对象

- 使用：使用由Object类继承而来的equals方法或在自定义类中重写equals方法

  - 若不重写，则equals方法默认使用==比较对象

- 注意事项：

  - equals方法和相等操作符的区别
  - 重写equals方法后必须重写hashCode方法，二者应在逻辑上保持一致

- 举例：

  ```java
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
  
  public class Main {
   
      public static void main(String[] args) {
          People p1 = new People("Jack", 12);
          People p2 = new People("Jack", 12);
          System.out.println(p1.equals(p2)); // true
      }
  }
  ```

## hashCode方法

- 用途：将对象的相关信息映射成散列值，用于在集合中快速查找

- 使用：使用由Object继承而来的hashCode方法或在自定义类中重写hashCode方法

  - 若不重写，hashCode方法默认返回对象的存储地址

- 注意实现：

  - equals方法和hashCode方法的关系
  - 重写hashCode方法后必须重写equals方法，二者应在逻辑上保持一致

- 举例

  ```java
  class People{
      private String name;
      private int age;
       
      public People(String name,int age) {
          this.name = name;
          this.age = age;
      }  
      
      @Override
      public boolean equals(Object obj) {
          return this.name.equals(((People)obj).name) && this.age == ((People)obj).age;
      }
      
      @Override
      public int hashCode() {
  				return name.hashCode()*37+age;
  		}
  }
   
  public class Main {
   
      public static void main(String[] args) {
          People p1 = new People("Jack", 12);
          System.out.println(p1.hashCode());
               
          HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
          hashMap.put(p1, 1);
           
          System.out.println(hashMap.get(new People("Jack", 12))); // 输出：1
      }
  }
  ```

## getClass方法

- 用途：获得对象对应的类名

- 注意事项：getClass方法和class方法的区别

  - getClass方法类的实例的方法（即获得的是运行时对象所属的类）
  - class方法是类的方法（在编译时即可确定）

- 举例：

  ```java
  class A {}
  
  public class Test {
  
      public static void main(String[] args) {
          A a = new A();
          System.out.println(a.getClass()); // class A
          System.out.println(A.class()); // class A
      }
  }
  
  ```

## toString方法

- 用途：返回对象的字符串表示

- 使用：

  - Object的toString方法的返回值为类名+@+十六进制的对象的哈希值，等价于：

    `getClass().getName() + '@' + Integer.toHexString(hashCode())`

  - 推荐在自定义类中重写toString方法以将对象包含的信息以直观的方式展示

- 举例：

  ```java
  // 例1：
  Integer i = new Integer(50);
  
  ArrayList list = new ArrayList();
  
  list.add(50);
  list.add("Hello World");
  
  System.out.println("" + i.toString()); // 50
  System.out.println("" + list.toString()); // [50, Hello World]
  
  // -------------------------------------------------------------------
  // 例2：
  public class Student implements Cloneable {
      
      private String name;
      
      private int age;
      
      public void setName(String name) {
          this.name = name;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "Student [name=" + name + ", age=" + age + "]";
      }
  }
  
  public class Main {
    	public static void main(String[] args) {
        	Student student = new Student();
        	student.setName("Xiao Ming");
        	student.setAge(20);
        	System.out.println(student.toString()); // Student [name = Xiao Ming, age = 20]
    	}
  }
  ```

  