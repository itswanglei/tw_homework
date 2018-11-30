# JSON

JSON（JavaScript Object Notation）是一种 **轻量级数据交换格式**，用来序列化对象、数组、数值、字符串、布尔值和 `null`。

## 特点

- JSON 是纯文本
- JSON 具有“自我描述性”（人类可读）
- JSON 具有层级结构（值中存在值）
- JSON 可通过 JavaScript 进行解析
- JSON 数据可使用 AJAX 进行传输

## 语法

JSON 是键值对的集合，其基本形式为：

- 数据在名称/值对中
- 数据由逗号分隔
- 花括号保存对象
- 方括号保存数组

```json
{
    "key1": "value1",
    "key2": "value2",
    "key3": "value3"
}
/* 注：
1. 最后一个键值对后面没有逗号
2. 键和值均用 "" 括起来 */
```

JSON 值可以是：

- 数字（整数或浮点数）
- 字符串（在双引号中）
- 逻辑值（true 或 false）
- 数组（在方括号中）
- 对象（在花括号中）
- null

是否是 JSON 字符串取决于上下文，在string上下文里使用带有大括号的 JavaScript 对象，那它就是 JSON 字符串，而如果在对象字面量上下文里使用的话，那它就是对象字面量。

```javascript
// 这是JSON字符串
var foo = '{ "prop": "val" }';
 
// 这是对象字面量
var bar = { "prop": "val" };
```

## 方法

- `JSON.parse()`：解析 JSON 字符串并返回对应的值。

- `JSON.stringify()`：返回与指定值对应的 JSON 。

## JSON 和 JavaScript 的关系

JSON 基于JavaScript 语法，但 JavaScript不是JSON，JSON也不是 JavaScript。

- JSON 最后一个键值对后面不能加逗号
- JSON 的键和值均须用`""`括起来
- 任何 JSON 文本都是有效的 JavaScript 表达式——但仅限于已实施 ECMA-262 的 JavaScript 引擎。JSON 中的字符串文字和属性键允许使用 U + 2028 LINE SEPARATOR 和 U + 2029 PARAGRAPH SEPARATOR，但在尚未实施 ECMA-262 的引擎中，会报语法错误。

