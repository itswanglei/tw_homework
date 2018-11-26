## for 循环

```javascript
for(初值; 循环结束条件; 增量) {
    循环主体
}
```

特点：先判断、后循环。

即，当未达到循环结束条件时才执行循环主体的语句。且语句执行的顺序为：

```flow
st=>start: 开始
cond=>condition: 是否满足循环结束条件
op1=>operation: 变量赋初值
op2=>operation: 执行循环主体
op3=>operation: 变量值改变
e=>end: 结束

st->op1->cond
cond(no)->op2(right)->op3(right)->cond
cond(yes)->e
```

## while 循环

```javascript
while(进入循环的条件) {
    循环主体
}
```

特点：先判断、后循环

即，当满足进入循环条件时才执行循环主体中的语句。该循环的逻辑为：

```flow
st=>start: 开始
cond=>condition: 是否满足进入循环的条件
op1=>operation: 执行循环主体
e=>end: 结束

st->cond
cond(yes)->op1(left)->cond
cond(no)->e
```

## do-while 循环

```javascript
do {
    循环主体
} while(再次循环的条件)
```

特点：先循环、再判断

即，先执行一次循环主体语句，再判断是否再次进入循环。该循环的逻辑为：

```flow
st=>start: 开始
cond=>condition: 是否满足进入循环的条件
op1=>operation: 执行循环主体
e=>end: 结束

st->op1->cond
cond(yes)->op1
cond(no)->e
```

