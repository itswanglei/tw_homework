# Ajax 请求中的回调

1. 创建 Ajax 对象（可以通过函数创建）

2. 指定结果处理器

   `ajax.onreadystatechange = [函数名];`

3. 发送数据

   `ajax.open('GET'/'POST', [url], true);`

   `ajax.setRequestHeader([报头], [值])`

   `ajax.send([data]);`

4. 中止请求

   `ajax.abort();`



