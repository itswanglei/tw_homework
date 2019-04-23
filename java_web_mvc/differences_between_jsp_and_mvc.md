# JSP和MVC的异同

## 相同之处

JSP和MVC是实现过程是相似的，基本来说都会经过以下几个步骤：

- 接收用户的页面请求
- 调用相应数据
- 生成对应的页面
- 呈现给用户

## 不同之处

JSP和MVC最大的不同之处在于设计结构：

- JSP中上述步骤统一由后端服务器完成，不对业务逻辑和展示逻辑加以区分，因而JSP也具有维护性差的缺点
- MVC中通过Model、View、Controller三个层次对上述步骤进行划分，每个层次具有不同的职责，业务逻辑和展示逻辑耦合性低，代码复用率更高，因而MVC相比JSP更易于维护

![](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/MVC-Process.svg/800px-MVC-Process.svg.png)

## 参考

- [Model–view–controller](<https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller>)

