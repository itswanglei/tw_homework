# Java 数组

## 定义

数组是固定长度的、存储相同类型变量的有序集合

## 声明数组

```java
dataType[] arrayRefVar; // 推荐
dataType arrayRefVar[]; // 不推荐

// 二维数组
dataType[][] arrayRefVar;
```

## 创建数组

即指定数组的大小，为数组开辟内存空间

```java
arrayRefVar = new dataType[arraySize];
arrayRefVar = {value0, value1, ..., valuek};
```

arrayRefVar保存了数组的引用，即数组第一个元素存储的地址

## 遍历数组

- for循环

  ```java
  double[] myList = {1.9, 2.9, 3.4, 3.5};
  for (int i = 0; i < myList.length; i++) {
  		System.out.println(myList[i]);
  }
  ```

- foreach循环

  ```java
  for (double element: myList) {
  		System.out.println(element);
  }
  ```

  foreach 循环时，不能对循环变量赋值

## 常用方法

- `binarySearch`：在数组中搜索，若找到则返回索引值，若未找到返回-1

- `equals`：比较两个数组

- `fill`：以某个值填充数组
- `sort`：给数组中的元素排序