# undefined 和 null

## 1. undefined

### 定义

undefined 是 JavaScript 中的一个数据类型。

- 可以将其当作全局对象的一个属性，该属性的值为`undefined`，即：`window.undefined: undefined`。

- 也可以将其当作一个全局变量，该变量的唯一值为`undefined`。

  > 从这个意义上讲，用`typeof`操作`undefined`变量会返回一个`"undefined"`字符串，即
  >
  > ```javascript
  > typeof undefined === "undefined"; // true
  > ```

### 含义

`undefined`是一个**空值**，表示“缺少值”，即——此变量应有值，但未定义。

### 用法

1. 变量被声明了，但未赋值，此时该变量的默认初始值为`undefined`（即访问未初始化的变量会得到`undefined`）；
2. 对象中未赋值的属性或方法，此时该属性/方法的默认初始值为`undefined`（即访问未赋值/不存在的对象属性/方法会得到`undefined`）；
3. 当访问不存在（超出索引）的数组元素是会得到`undefined`；
4. 调用函数时未传入的参数，此时该参数的默认初始值为`undefined`；
5. 当函数无返回值时，默认返回值为`undefined`。

（另外，undefined也可以作为局部变量使用，可以给其赋一个新值，如`var undefined = "not undefined"`。）

### 判断

`undefined`可以用两种方式判断：

1. 标准相等操作符`===`；
2. 类型判断函数`typeof`。

但考虑到 undefined 可能被赋予了另外的值，采用`===`判断可能不靠谱，因此可以使用`void 0`替代`undefined`。

> `void`运算符的含义是：对给定的表达式进行求值，然后返回 undefined。

## 2. null

### 定义

null 也是 JavaScript 中的一个数据类型，表示一个空对象指针，指示变量未指向任何对象。

### 含义

`null`是一个空值，表示“变量未指向任何对象”，此处无值。

### 用法

1. 当定义的变量未来会被用作保存对象时，最好将该变量初始化为`null`；
2. 当变量不再需要被使用时，可将其设置为`null`来解除引用；
3. 作为对象原型链的终点。

### 判断

- `null`只能用严格相等操作符`===`判断。而不能用类型判断函数`typeof`判断，因为：

  >在JavaScript最初的实现中，JavaScript中的值由一个表示类型的标签和实际数据值表示。`object`的类型标签为0，又由于`null`代表空指针（空值针在大多数平台下值为0x00），致使`null`的类型标签也为0，进而使用`typeof null`会错误的返回`object`。

## 3. 空值与假值

- `undefined`和`null`均为**空值**。

- 与**空值**相对应的概念为**假值**，`0`、`""`、`false`均为**假值**，即：

  ```javascript
  console.log(0 == false); // true 
  console.log("" == false); // true 
  ```

- **空值**与**假值**在`if`语句的条件分支中均被视为`false`，但`空值 !== 假值`，即：

  ```javascript
  console.log(undefined == false); // false
  console.log(null == false); // false
  ```

- 由于`undefined`实际上是`null`的派生，因此有

  ```javascript
  console.log(undefined == null); // true
  ```

  但由于二者属于不同的数据类型，则有

  ```javascript
  console.log(undefined === null); // false
  ```

## 4. 8个处理 undefined 的 Tips

1. **声明变量时，推荐使用`const`**（尤其对于只赋值一次且不再改变的变量）、**其次`let`，拒绝`var`**

   - 好处：JavaScript 语法规定`const`定义时必须赋初值，因而使用`const`可以避免意外访问到`undefined`。

2. **将变量的声明尽可能移到使用位置之前**以增强内聚

   > 高内聚和[低耦合](https://en.wikipedia.org/wiki/Loose_coupling)是设计良好的系统的特点。
   >
   > 高内聚代码的优势：
   >
   > - 专注易理解
   > - 可维护易重构
   > - 易重用
   > - 易测试

   - 好处：
     - 变量不会暴露为未初始化的状态，因而不会意外访问到`undefined`；
     - 增强了代码的可读性；
     - 更易于重构和提取为函数。

3. **使用对象时首先检查属性是否存在**

   - 两种推荐的检查方法：
     - 使用`in`，即`prop in obj`（可用于自身的或继承的属性）；
     - 使用`hasOwnProperty`，即`obj.hasOwnProperty(prop)`（可用于自身的属性）。

4. **解构访问对象属性**

   - 实现：`const {prop = 'default'} = object`

   > [对象解构](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment#Object_destructuring)允许将值从对象属性直接提取到变量中，并在属性不存在时设置默认值，是一种避免直接处理`undefined`的方法。

5. **使用默认属性填充对象**

   - 可以将源对象的属性赋给目标对象，两种实现方法：

     - `assign`函数：`object.assign(targetObj, sourceObj1, sourceObj2, ...)`

     - 在对象初始化器中扩展属性：

       ```javascript
       const sourceObj1 = {
           obj1Prop1: "default";
           ...
       }
       const sourceObj2 = {
           obj2Prop1: "default";
           ...
       }
       const targetObj = {
           sourceObj1;
           sourceObj2;
           ...
       }
       ```

6. **创建函数时为参数提供默认值**
   - `function fun(variable1, variable2 = "default") {...}`

7. **不要依赖[自动分号插入](http://www.ecma-international.org/ecma-262/6.0/index.html#sec-automatic-semicolon-insertion)(ASI)机制**
   - 下列语句必须自动插入分号：
     - 空语句
     - `let`、`const`、`var`、`import`、`export`的声明语句
     - 表达式
     - `debugger;`
     - `continue;`
     - `break;`
     - `throw`语句
     - `return`语句
8. **避免使用稀疏数组**
   - 访问稀疏数组的空隙时会得到`undefined`。

---

参考：

- [JavaScript深入理解之undefined与null](https://juejin.im/post/5aa4f7cc518825557e780256)

- [undefined与null的区别](http://www.ruanyifeng.com/blog/2014/03/undefined-vs-null.html)

- [Javascript 中的false,零值,null,undefined和空字符串对象](https://my.oschina.net/friendship/blog/644352)

- [【译】7个处理javascript的`undefined`的tips](https://futu.im/posts/2017-05-20-7-tips-to-handle-undefined-in-JavaScript/)

