# JavaScript 中的数据类型

JavaScript 是一种弱类型语言，在 JavaScript 中一共有7种数据类型，分别是：

- 原始数据类型（6种）：
  - Boolean
  - Number
  - String
  - Null
  - Undefined
  - Symbol
- 自定义数据类型（1种）：
  - Object

除Object外，所有数据类型的原始值是不会改变的（无论进行了何种操作）。

---

## 原始数据类型

### Boolean

- 取值：`true`和`false`

- 获得方法：
  1. 直接定义
  2. 布尔运算（`&&`、`||`、`!`）
  3. 比较运算（`>`、`<`、`===`）
- 用途：常用于**判断**语句中。

### Number

JavaScript不区分整数与浮点数。

- 格式：双精度64位二进制格式

  > 双精度浮点数：使用64位（8字节）存储一个浮点数，范围为：$${[2.23^{-308}, 1.79^{308}]}$$。
  >

- 取值：$$[-2^{63}+1, 2^{63}-1]$$、`-Infinity`、`+Infinity`、`NaN`

- 用途：可做四则运算。

### String

- 格式：16位无符号整数值，用单引号`' '`和双引号`" "`标记。
- 字符串创建之后不可修改，但是可以进行截取字串`String.substr()`、拼接`String.contact()`等操作。

### Null

- 含义：空。
- `null`不等于`0`或`" "`。

### Undefined

- 含义：未定义。
- 未赋值的变量会具有一个`undefined`的默认初值。

### Symbol

- 性质：唯一且不可修改。
- 用途：常用于Object的健的值，类似于C语言中的枚举类型。

---

## 自定义数据类型

### Object

- 定义：内存中可被标识符引用的一块区域；是一组属性的集合。
- 属性：
  - 数据属性：由多个 **键-值** 对表示，其中 **键** 为`String`类型或`Symbol`类型，**值** 可为任意数据类型。
    - 特性：`Value`、`Writable`、`Enumberable`、`Configurable`
  - 访问器属性：
    - 特性：`Get`、`Set`、`Enumberable`、`Configurable`