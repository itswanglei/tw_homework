## LinkedList用法总结

```java
public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable
```

双链表可以从头部或尾部双向遍历。

## 构造函数

- `LinkedList()`：创建一个空链表

  ```java
  LinkedList<String> linkedList = new LinkedList<>();
  ```

- `LinkedList(Collection c)`：由给定集合创建一个链表

  ```java
  List<String> list = new ArrayList<>();
  list.add("a");
  list.add("b");
  list.add("c");
  LinkedList<String> linkedList = new LinkedList<>(list);
  ```

## 常用方法

### 增添元素

- `boolean add(E e)`：将指定元素添加到链表末尾
- `void add(int index, E e)`：将指定元素插入到链表的指定位置
- `boolean addAll(Collection c)`：将指定集合中的所有元素添加到链表末尾
- `boolean addAll(int index, Collection c)`：将指定集合中的所有元素从指定位置开始插入链表
- `void addFirst(E e)`：将指定元素插入到链表的开始
- `void addLast(E e)`：将指定元素添加到链表的末尾

### 删除元素

- `void clear()`：移除链表中的所有元素
- `E remove()`：移除链表的第一个元素，并返回该元素
- `E remove(int index)`：移除链表中指定位置处的元素，并返回该元素
- `boolean remove(E e)`：若元素存在则从链表中该元素第一次出现的位置移除该元素
- `E removeFirst()`：移除链表的第一个元素，并返回该元素
- `boolean removeFirstOccourence(E e)`：从链表中移除指定元素第一次出现位置处的元素（以正序遍历）
- `E removeLast()`：移除链表最后一个元素，并返回该元素
- `boolean removeLastOccourence(E e)`：从链表中移除指定元素最后一次出现位置处的元素（以正序遍历）

### 查找元素

- `boolean contains(E e)`：判断链表中是否存在指定元素
- `E get(int index)`：返回链表中指定位置的元素
- `E getFirst()`：返回链表的第一个元素
- `E getLast()`：返回链表的最后一个元素
- `int indexOf(E e)`：返回指定元素在链表中第一次出现的位置，若未找到则返回-1
- `int lastIndexOf(E e)`：返回指定元素在链表中最后一次出现的位置，若未找到则返回-1

### 修改元素

- `E set(int index, E e)`：将链表中指定位置处的元素修改为指定的元素，返回被替换的元素

### 其他方法

- `int size()`：返回链表中包含的元素的数量

- `Object clone()`：返回该链表的浅拷贝
- `Object[] toArray()`：以适当的顺序（从第一个元素到最后一个元素）返回包含此链表中所有元素的数组

```java
// 示例
LinkedList<String> linkedList = new LinkedList<>(); // linkedList: []
boolean result = linkedList.add("a"); // result: true, linkedList: ["a"]
linkedList.addFirst("z"); // linkedList: ["z", "a"]
linkedList.add(1, "b"); // linkedList: ["z", "b", "a"]

List<String> list = new ArrayList<>();
list.add("c");
list.add("d");
list.add("a"); // list: ["c", "d", "a"]
result = linkedList.addAll(list); // linkedList: ["z", "b", "a", "c", "d", "a"]

String firstElement = linkedList.remove(); // linkedList: ["b", "a", "c", "d", "a"]
String specifiedIndexElement = linkedList.remove(3); // linkedList: ["b", "a", "c", "a"]
result = linkedList.remove("a"); // linkedList: ["b", "c", "a"]

result = linkedList.contains("b"); // result: true
String specifiedElement = linkedList.get(2); // specifiedElement: "a"
String lastElement = linkedList.getLast(); // lastElement: "a"
int index = linkedList.indexOf("b"); // index: 0

String element = linkedList.set(1, "a"); // element: "c", linkedList: ["b", "a", "a"]
int sizeOfLinkedList = linkedList.size(); // sizeOfLinkedList: 3
Object[] elements = linkedList.toArray(); // 返回长度为3的Object数组
```

## 遍历方式

- for循环

  ```java
  for (int i = 0; i < linkedList.size(); i++) {
  		System.out.println(linkedList.get(i));
  }
  ```

- 自动增强for循环

  ```java
  for (String s : linkedList) {
  		System.out.println(s);
  }
  ```

- 迭代器遍历

  ```java
  Iterator<String> it = linkedList.iterator();
  while (it.hasNext()) {
  		System.out.println(it.next());
  }
  ```

  