# HTML 本地存储

本地存储有两类存储对象：

- `window.localStorage`：用于存储没有截至日期的数据
- `window.sessionStroage`：针对一个 session 来存储数据（当关闭浏览器标签页时数据会丢失）

## 属性

- `Storage.length`：返回存储对象中保存的数据项的个数

## 方法

- `Storage.key([number])`：返回第[number]项的键名
- `Storage.getItem([key])`：返回对应的值
- `Storage.setItem([key], [value])`：设置一个新的存储项，或更改现有存储项的值
- `Storage.removeItem([key])`：删除一个存储项
- `Storage.clear()`：清空全部存储项

