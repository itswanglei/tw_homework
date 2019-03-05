# thenApply()和thenCompose()的异同

## 相同之处

`thenApply()`和`themCompose()`都是用于连接多个`CompletableFuture`调用，通过类似于流的操作来处理`CompletableFutrue`的结果

## 不同之处

- `thenApply()`接收一个函数作为参数，使用该函数处理上一个`CompletableFuture`调用的结果，并返回一个具有处理结果的`Future`对象

  ```java
  CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello").thenApply(string -> string + " world");
  
  try {
      System.out.println(completableFuture.get());
  } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
  }
  ```

  可以看到`thenApply()`适用于对`CompletableFuture`调用的结果进行一些转换。

- `thenCompose()`的参数为一个返回`CompletableFuture`实例的函数，该函数的参数是先前计算步骤的结果

  ```java
  CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello").thenCompose(string -> CompletableFuture.supplyAsync(() -> string + " world"));
          
  try {
      System.out.println(completableFuture.get());
  } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
  }
  ```

  可以看到`thenCompose()`会将内部的`CompletableFuture`调用展开来并使用上一个`CompletableFutre`调用的结果在下一步的`CompletableFuture`调用中进行运算，因此`thenCompose()`更适用于多个`CompletableFuture`调用的连接。
  
  ---
  ### 参考
  - [Guide To CompletableFuture](https://www.baeldung.com/java-completablefuture)