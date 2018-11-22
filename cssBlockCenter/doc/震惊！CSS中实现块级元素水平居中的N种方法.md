# 震惊！CSS中实现块级元素水平居中的N种方法

首先声明我不是标题党，这篇博客还是干货满满的~

最近写作业的时候遇到这么一道题：

> 网页由box1、box2、box3、box4四个盒子组成，请实现如下效果：
>
> - 1、2、3号盒子在一行；
>
> - 4号盒子在2号盒子的正下方。

最简单的想法是四个盒子均用绝对定位，但是这种实现方法代码量大、需要计算每个盒子的位置、不灵活（如果盒子的大小改变了难以修改）。

另一种想法是，三个盒子排在一行可以用float实现，第四个盒子用绝对定位，但是依然存在上述问题。

因此如果能让这些盒子自己在页面居中，那无论盒子的尺寸和数目如何改变均可轻松实现想要的效果了。

学习了一下网上大牛们给出的方法，发现块级元素的水平居中可以通过N种方式实现！

## 1. 利用margin-left&right=auto实现元素居中

对于单个块级元素的水平居中可以通过将`margin-left`和`margin-left`设置为`auto`来实现。

以一个box为例，CSS部分具体代码为：

```css
div {
    background: grey;
    color: white;
    text-align: center;
    width: 400px;
    height: 400px;
    margin-left: auto;
    margin-right: auto;
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx6vbl7962j211y0he3yf.jpg)

**注意**：该方法需要元素的宽度已知。

另外，如果需要水平居中多个块级元素，就要使用另外的方法了。

## 2. 利用inline-block实现元素居中

将需要居中的块级元素的`display`属性设置为`inline-block`，并将其**父元素**的`text-align`属性设置为`center`即可实现多个块级元素的水平居中。

这里用到了**行级格式化上下文（IFC）**的概念。这种方法实际上是通过`inline-block`将三个box组成一个整体，此时`<body>`作为一个行盒可以通过`text-align`属性设置其内部元素的水平分布。

以三个box为例，HTML部分代码为：

```html
<body>
    <div id="box1">
        <p>box1</p>
    </div>
    <div id="box2">
        <p>box2</p>
    </div>
    <div id="box3">
        <p>box3</p>
    </div>    
</body>
```

CSS部分代码为：

```css
div {
    height: 200px;
    width: 200px;
    background: grey;
    color: white;
    display: inline-block;
}        
body {
    text-align: center;
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx6vikt5jej211y0he0so.jpg)

## 3. 利用fit-content实现元素居中

该方法需要将box块设置为浮动布局（`float`），并将其**父元素**的宽度设定为自适应（`width:fit-content`），再结合方法一即可实现效果。

仍以上述三个box为例，CSS部分具体代码为：

```css
div {
    background: grey;
    color: white;
    text-align: center;
    width: 200px;
    height: 200px;
    margin: 10px;
    float: left;
}
body {
    width: fit-content;
    margin-left: auto;
    margin-right: auto;
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx6vpc3v0jj211y0he0so.jpg)

## 4. 利用float+relative实现元素水平居中

这种方式分为两步：

1. 将需要居中的块级元素设置为`float`布局，采用相对定位方式（`position:relative`)，并相对现在的位置**向右（或向左）**移动50%；
2. 将需要居中的块级元素的**父元素**设置为`float`布局，采用相对定位方式（`position:relative`)，并相对现在的位置**向左（即其子元素移动的反方向）**移动50%。

仍以上述三个box为例，CSS部分具体代码为：

```css
div {
    height: 200px;
    width: 200px;
    background: grey;
    color: white;
    text-align: center;
    margin: 10px;
    float: left;
    position: relative;
    right: 50%;
}        
body {
    float: left;
    position: relative;
    left: 50%; /*一定要与子元素移动方向相反*/
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx7bl7zoi6j211y0hewef.jpg)

## 5. 利用float+absolute实现元素居中

这种方式也分两步实现：

- 第一步与方法四（float+relative）相同；

- 第二步中，需要居中的块级元素的**父元素**应采用绝对定位方式（`position:absolute`）、向其子元素移动的反方向移动50%，并将文本对齐方式设置为居中（`text-align: center`）。

以上述三个box为例，CSS部分具体代码为：

```css
div {
    height: 200px;
    width: 200px;
    background: grey;
    color: white;
    text-align: center;
    margin: 10px;
    float: left;
    position: relative;
    right: 50%;
}        
body {
    position: absolute; /*这里与方法四不同*/
    left: 50%; /*一定要与子元素移动方向相反*/
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx7bquv55aj211y0hewef.jpg)

## 6. 利用flex实现元素居中

对于需要所有元素均在一排并且居中的情况，`flex`非常好用。只用将需要居中的块级元素的**父元素**的`display`属性设置为`flex`，`justify-content`属性设置为`center`即可。

以上述三个box为例，CSS部分具体代码为：

```css
div {
    background: grey;
    color: white;
    text-align: center;
    width: 200px;
    height: 200px;
    margin: 10px;
}
body {
    display: flex;
    justify-content:center;
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx7c1acdz7j211y0he0so.jpg)

## 7. 使用伪元素模拟float:center效果

最后一种方法比较复杂但是可以实现文字环绕图片的效果（对于分栏排版的段落很有效）。

（实际上对于单栏文字环绕图片的效果通过设置图片的`float`属性即可实现，因此思考一下也很容易将这种方法拓展到多栏文字上）

目前CSS中没有`float:center`这种效果，但是可以利用伪元素进行模拟。该方法分为两步：

1. 使用伪元素`:before`分别在多栏文字上用**空内容占位**，并通过设置不同的`float`方向使段落的文字重新布局，产生环绕的效果。(**注意**：占位符的大小不能小于所插入图片的大小。)
2. 采用绝对定位将需要插入的图片移动到占位符处。

举一个例子看具体实现。

HTML部分代码为：

```html
<body>
    <div id="leftText">
        <p>
            第一栏...（此处省略内容）
        </p>
    </div>
    <div id="rightText">
        <p>
            第二栏...（此处省略内容）
        </p>
    </div>
    <div>
        <img src=".\我是一张图片（大小为：160*160px）.png">
    </div>
</body>
```

CSS部分代码为：

```css
#leftText {
    float: left;
    width: 40%;
    margin-left: 120px;
}
#rightText {
    float: right;
    width: 40%;
    margin-right: 120px;
}
/*两栏内容需要两个占位符，以使图片位于两栏内容中间*/
#leftText:before, #rightText:before { 
    content: ""; /*以空内容占位*/
    width: 102px; /*宽度大于图片宽度的一半*/
    height: 180px; /*高度大于图片高度*/
} 
#leftText:before { 
    float: right; /*第一栏占位符右浮动*/
} 
#rightText:before { 
    float: left; /*第一栏占位符左浮动*/
}
img {
    position: absolute; /*用绝对定位的方式调整图片的位置*/
    top: 30px;
    left: 44%;
    transform: -50%;
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx7dvs7nw2j211y0hewid.jpg)

这种方法虽然步骤略复杂，但是效果还是蛮好的。



## 回到最初的问题

那对于开头的作业比较好的实现方式是什么呢？

对于这道题，我目前觉得最好的方式是`inline-block`。

可以看一下具体实现。

HTML部分代码为：

```html
<body>
    <div id="box123"> 
        <div id="box1">
            <p>box1</p>
        </div>
        <div id="box2">
            <p>box2</p>
        </div>
        <div id="box3">
            <p>box3</p>
        </div>    
    </div>    
    <div id="box4">
        <p>box4</p>
    </div>    
</body>
```

CSS部分代码为：

```css
#box1, #box2, #box3 {
    height: 200px;
    width: 200px;
    background: gray;
    color: white;
    display: inline-block;            
}
#box4 {
    height: 200px;
    width: 200px;
    background: gray;
    color: white;
    display: inline-block;
    margin-top: 5px;            
}
body {
    text-align: center;
}
```

实现的效果为：

![](http://ww1.sinaimg.cn/large/98792392ly1fx7e8zvzi7j211y0he749.jpg)

---

参考文章：

- [六种实现元素水平居中的方法](https://www.w3cplus.com/css/elements-horizontally-center-with-css.html)

- [使用CSS伪元素模拟float:center效果](https://www.w3cplus.com/css/float-center.html)