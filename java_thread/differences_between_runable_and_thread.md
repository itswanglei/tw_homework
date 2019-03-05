# 使用Runable接口和Thread类实现线程的异同

## 相同之处

- 在实现Runable接口的类和继承Thread的类中均需要重写`run()`方法
- 在启动线程时均通过调用`start()`方法来执行`run()`方法中的语句

## 不同之处

- Runable是接口、Thread是类，使用时语法不同

  ```java
  // 实现Runable接口
  public class MyThreadByRunable implements Runable {
      @Override
      public void run() {
          ...
      }
  }
  
  // 继承Thread类
  public class MyThreadByThread extends Thread {
      private String name;
      
      public MyThread(String name) {
          this.name = name;
      }
      
      @Override
      public void run() {
          ...
      }
  }
  
  // --------------------------------------------------------------
  public class Main {
      public static void main(String[] args) {
          Runable myThread1 = new MyThreadByRunable();
          new Thread(myThread1, "my_thread_impl_Runable").start();
          
          MyThreadByThread myThread2 = new MyThreadByThread("my_thread_extends_Thread");
          myThread2.start();        
      }
  }
  ```

- 由于java单继承的特性，使用Runable接口使自定义的线程类具有更好的拓展性，而继承Thread类的自定义线程类无法实现其他的继承

- 使用Runable接口易于实现资源共享，而继承Thread类不易于实现资源共享

  示例1：使用Runable接口

  ```java
  public class MyThreadByRunable implements Runnable {
      private int count = 7;
  
      @Override
      public void run() {
          for (int i = 0; i < 3; i++) {
              System.out.println(Thread.currentThread().getName() + "is running, count = " + count--);
              try {
                  Thread.sleep((int) (Math.random() * 10));
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  
  public class Main {
  
      public static void main(String[] args) {
          Runnable myThread1 = new MyThreadByRunable();
          new Thread(myThread1, "Thread_1").start();
          new Thread(myThread1, "Thread_2").start();
          new Thread(myThread1, "Thread_3").start();
      }
  }
  ```

  !![](http://ww1.sinaimg.cn/large/98792392ly1g0rpmdtfk4j20p404zjre.jpg)

  可以看到三个线程共享了count值，因为它们是从同一个实例myThread1开启的

  

  示例2：使用Thread类

  ```java
  public class MyThreadByThread extends Thread {
      private String name;
  
      public int count = 7;
  
      public MyThreadByThread(String name) {
          this.name = name;
      }
  
      @Override
      public void run() {
          for (int i = 0; i < 3; i++) {
              System.out.println(this.name + " is running, count = " + count--);
              try {
                  Thread.sleep((int) (Math.random() * 10));
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  
  public class Main {
  
      public static void main(String[] args) {
          MyThreadByThread myThread4 = new MyThreadByThread("Thread_4");
          // 如果用同一个线程对象开启多个线程会报异常
          myThread4.start();
          myThread4.start();
      }
  }
  ```

  ![](http://ww1.sinaimg.cn/large/98792392ly1g0rptx3za1j20rg02s749.jpg)

  ```java
  // 使用Thread类来开启多个线程的正确写法
  public class Main {
  
      public static void main(String[] args) {
          MyThreadByThread myThread4 = new MyThreadByThread("Thread_4");
          MyThreadByThread myThread5 = new MyThreadByThread("Thread_5");
          MyThreadByThread myThread6 = new MyThreadByThread("Thread_6");
          myThread4.start();
          myThread5.start();
          myThread6.start();
  
      }
  }
  ```

  ![](http://ww1.sinaimg.cn/large/98792392ly1g0rpvm7u3pj20s404wmx6.jpg)

  可以看到三个线程并没有共享资源，因为它们必须由不同线程对象开启。
  
  ---
  ### 参考
  - [多线程——继承Thread 类和实现Runnable 接口的区别](https://blog.csdn.net/u010926964/article/details/74962673)