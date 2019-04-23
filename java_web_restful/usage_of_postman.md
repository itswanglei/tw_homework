# Postman 用法总结

## 界面介绍

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpabwis3j20z80k2mzj.jpg)

## 发送 GET 请求

1. 选择 GET 方式
2. 输入 URL
3. 在 Params 里填项所需参数，填写的参数会出现在 URL 上
4. 点击 Send 发送请求

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpdymmkwj20nv068jrf.jpg)

相应状态为 `200`表明请求被成功响应

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpiaenquj20q807gt8w.jpg)

## 发送 POST 请求

### 表单提交

1. 选择 POST 方式
2. 输入 URL
3. 在 Body 中选择 `x-www-form-urlencoded`方式，并输入参数，Postman 会自动设置相应的 Header

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpw3ylexj20hy067749.jpg)

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpmzkoevj20hz05q749.jpg)

### JSON 提交

1. 选择 POST 方式
2. 输入 URL
3. 在 Body 中选择 `raw`方式，设置格式为 `JSON(application/json)`
4. 输入参数，Postman 会自动设置相应的 Header

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpvbzp1bj20j506gq2x.jpg)

![](http://ww1.sinaimg.cn/large/98792392ly1g2bppyizrbj20ht056dfr.jpg)

### XML 提交

1. 选择 POST 方式
2. 输入 URL
3. 在 Body 中选择 `raw`方式，设置格式为 `XML(text/xml)`
4. 输入参数，Postman 会自动设置相应的 Header

![](http://ww1.sinaimg.cn/large/98792392ly1g2bptajd39j20i105sglm.jpg)

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpu033x0j20ht05d748.jpg)

### 二进制文件提交

1. 选择 POST 方式
2. 输入 URL
3. 在 Body 中选择 `binary`方式
4. 上传二进制文件

![](http://ww1.sinaimg.cn/large/98792392ly1g2bpykrtjuj20fo04wdfr.jpg)

## 测试请求

使用 `Tests`可以通过断言来处理请求

![](http://ww1.sinaimg.cn/large/98792392ly1g2bq121dt5j20qd0a0aao.jpg)

我们可以基于 Postman 提供的断言实现想要的处理

例如：

- `Status code is 200`：断言响应状态为200
- `Response body: Contains string`：断言响应内容为一个String
- `Response body: JSON value check`：处理响应中的JSON

在 Test Results 中可以查看测试结果

![](http://ww1.sinaimg.cn/large/98792392ly1g2bq8j68ubj20pw085gms.jpg)

例如上图表明一个断言成功、两个失败

## 请求集

使用 Collections 可以将多个请求管理起来

1. 创建集合

![](http://ww1.sinaimg.cn/large/98792392ly1g2bqb1e4zgj20850bgdfx.jpg)

![](http://ww1.sinaimg.cn/large/98792392ly1g2bqc96va6j208805oq2s.jpg)

2. 保存请求到一个集合

![](http://ww1.sinaimg.cn/large/98792392ly1g2bqduqxikj20q202zwed.jpg)

![1555939697072](C:\Users\DELL\AppData\Roaming\Typora\typora-user-images\1555939697072.png)

4. 可以创建文件夹整理集合内的请求

![](http://ww1.sinaimg.cn/large/98792392ly1g2bqg27nyrj20850craa5.jpg)

5. 运行一个集合内的请求

![](http://ww1.sinaimg.cn/large/98792392ly1g2bqhuamdej20hy0g2jrl.jpg)

## 参考

- [Postman使用详解](<https://www.jianshu.com/p/549ff9f922d6>)
- [Postman 使用方法详解](<https://blog.csdn.net/fxbin123/article/details/80428216>)