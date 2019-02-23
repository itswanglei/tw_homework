# Externalizable的用法

实现了Externalizable接口的类需要重写`wirteExternal()`方法和`readExternal()`方法，，这样可以实现自定义方式的序列化和反序列化，而不受限于JVM。

## 序列化与反序列化

- 语法：

  - 类实现Externalizable接口

    ```java
    public class className implements Externalizable {}
    ```

  - 为类添加表示序列化版本号的静态变量，即

    ```java
    private static final long serialVersionUID；
    ```

  - 重写`wirteExternal()`方法和`readExternal()`方法，即

    ```java
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        ...
    }
    
    @Override
    public void readExternal(ObjectInput in) 
    	throws IOException, ClassNotFoundException {
       ...
    }
    ```

  - 建立文件流并对该类的实例对象调用`writeExternal()`方法和`readExternal()`方法，即

    ```java
    object.writeExternal(objectOutputStream);
    object.readExternal(objectInputStream);
    ```

- 示例：

  实现Externalizable的类：

  ```java
  public class Person implements Externalizable {
      private static final long serialVersionUID = 1L;
  
      private String name;
      private int age;
  
      public void setName(String name) {
          this.name = name;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      public String getName() {
          return this.name;
      }
  
      public int getAge() {
          return this.age;
      }
  
      @Override
      public void writeExternal(ObjectOutput out) throws IOException {
          out.writeUTF(this.name);
          out.writeInt(this.age);
      }
  
      @Override
      public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
          this.name = in.readUTF();
          this.age = in.readInt();
      }
  }
  ```

  对上述类进行序列化和反序列化：

  ```java
  public static void main(String[] args) {
        Person person = new Person();
        person.setName("Wang");
        person.setAge(25);
  
    		// 序列化
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("./docs/Person.txt")))) {
            person.writeExternal(objectOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
  
    		// 反序列化
        Person personFromFile = new Person();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("./docs/Person.txt")))){
            personFromFile.readExternal(objectInputStream);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        System.out.println(personFromFile.getName().equals(person.getName()) && personFromFile.getAge() == person.getAge());
  }
  
  ```

## Externalizable接口和Serializable接口的区别

- 责任差异：

  实现Serializable接口的类是由JVM负责序列化其实例对象的，

  而实现Externalizable接口的类由编程人员负责序列化和反序列化

- 使用情况差异

  当需要序列化整个对象时，使用Serializable接口更方便

  当需要序列化部分对象时，使用Externalizable接口更方法（它可以更便捷的控制如何序列化对象）

- 性能差异

  Serializable接口性能较差，而Externalizable接口的性能可控

- 实现自定义序列化方式的差异

  在实现Serializable接口时，通过给字段添加`transient`关键字可使JVM不序列化该字段，但JVM仍会将该字段的默认值加载进文件中