# Object

由一系列 **键值对** 组成的变量。其基本形式为：

```javascript
var object = {
    key1: value1,
    key2: value2,
    key3: value3,
}
```

键值对的值可以是任何数据类型，包括：number, string, array, boolean, object, function 等。这些键值对称为对象的 **属性**，其中function也称为对象的 **方法**。对象的名字称为 **命名空间**。

## JavaScript 中的常见对象

- `String`
- `Array`
- `Function`
- `Window`
- `Document`
- `Math`
- `Date`

## 创建对象的方法

1. `var object = {};`

2. `var object = new Object;`

3. 使用自定义构造函数创建对象

   ```javascript
   function constructorFunction() {
       this.key = value;
       ...
   }
   var object = new constructorFunction();
   ```

4. `var object = Object.creat(protoObject);`

   即以`protoObject`为原型创建一个新对象`object`，`object`会继承`protoObject`的属性。

   ```javascript
   object.__proto__; // return protoObject
   ```

5. 利用`constructor`属性创建对象：

   ```javascript
   var object = new existingObject.constructor(value1, value2, ...)
   ```

## 为对象增加属性

`object.key = value;`

## 删除对象的属性

`delete object.key;` 

## 访问对象的属性

1. 用`.`来访问对象的属性：`object.key`
2. 用`[]`来访问对象的属性：`object['key']`

## this 对象

`this` 指代的是当前代码行的上下文。

> The `this` keyword refers to the current object the code is being written inside.
>
> It will always ensure that the correct values are used when a member's context changes.

## 面向对象编程（Object-oriented programming）

> The basic idea of OOP is that we use objects to model real world things that we want to represent inside our programs, and/or provide a simple way to access functionality that would otherwise be hard or impossible to make use of.

- 抽象：创建一个简单的模型来描述一个复杂的事物
- 实例化：可以利用类的 **构造函数** 来将对象实例化
- 多态性：可以通过一个基类来创建很多子类，子类可以继承基类的属性

### 构造函数

构造函数具有函数的形式，但不返回任何值。可以按照如下方式创建一个构造函数：

```javascript
function constructorFunction() {
    this.property1 = value1;
    this.property2 = value2;
    this.property3 = function() {};
}
```

利用构造函数创建对象的方式为：

`var object = new constructorFunction();`

## 对象原型（Object prototype）

属性和方法是在对象的构造函数的原型属性上定义的，而不是对象实例本身。

- 对象的原型：指每个对象实例的原型
- 构造函数的原型属性：指构造函数上的属性

对象会继承其原型的所有属性（*该对象并不是复制了其原型的属性，而是通过原型链访问了原型的属性*）。

利用 `__proto__`可以访问对象的构造函数的原型对象。

继承链是动态更新的，即当原型的属性被修改后，所有该原型派生出的对象实例都能访问到该修改。

### 原型属性

对于`Object`这个对象来说，其能够被继承的属性是定义在它的原型上的属性，即可以以`Object.prototype.`来访问的属性。这些属性是定义在`Object()`构造函数上的属性。

### 构造函数的属性

每个构造函数都有一个原型属性，其值是一个包含`constructor`属性的 **对象**。该属性指向原始构造函数。

- 由对象实例获得其构造函数：`object.constructor()`
- 获得对象实例的构造函数的名称：`object.constructor.name`

**在构造函数中定义属性是比较好的方式**。实际上，对象定义的一个最常见模式是 **在构造函数内定义属性、在原型上定义方法**。这样可以使代码更易读。

```javascript
// 定义属性
function constructorFunction () {
    // property definitions
    ...
}
// 定义方法
constructorFunction.prototype.fun1 = function () {...};
constructorFunction.prototype.fun2 = function () {...};
...
```

## 继承

可以利用已有的构造函数派生新的构造函数

1. 利用`call()`函数继承已有构造函数的属性

   ```javascript
   // 已有的构造函数
   function originFunction() {
       this.property1 = value1;
       this.property2 = value2;
       ...
   }
   // 新构造函数
   function newFunction() {
       originFunction.call(this, [...arguments]);
       this.newProperty1 = newValue1;
       ...
   }
   ```

   通过这种方式即定义一个新的构造函数，它有一个原型属性，默认情况下它只包含对构造函数本身的引用，而不包含`originFunction()`构造函数的原型属性。

2. 利用`create()`函数继承已有构造函数的方法

   ```javascript
   newFunction.prototype = Object.create(originFunction.prototype);
   ```

   通过这种方式`newFunction`构造函数将`originFunction`构造函数的原型作为了自己的原型，并继承了其所有的方法。

   但`newFunction.prototype.constructor`现在为 `originFunction()`，因为我们将`newFunction.prototype` 指向了一个继承了`originFunction.prototype`属性的对象。

   为了修正这一问题，需要进行如下操作，以将`newFunction.prototype.constructor`修正为`newFunction()`。

   ```js
   Object.defineProperty(newFunction.prototype, 'constructor', { 
       value: newFunction, 
       enumerable: false, // so that it does not appear in 'for in' loop
       writable: true });
   ```

