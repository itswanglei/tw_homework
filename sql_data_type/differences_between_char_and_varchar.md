# CHAR和VARCHAR的区别

CHAR和VARCHAR的主要区别有三方面：

- 最大长度
- 有效长度
- 存储方式
- 是否保留末尾空格

## 最大长度

- CHAR的长的范围为0~255
- VARCHAR的长度范围为0~65535

## 有效长度

- CHAR的长度按照声明的长度保持不变
- VARCHAR的长度是可变的，VARCHAR数据的有效长度应在声明时指定的长度范围内
- 当插入的数据超出CHAR或VARCHAR声明的长度时，非严格模式会报警告并截断数据，严格模式下会报错
- 当插入的数据超出CHAR或VARCHAR声明的长度，且当超出的部分仅为数据末尾空格时，无论何种模式下，CHAR型数据会截断数据且不提示任何信息，而VARCHAR型数据会截断数据但报警告

## 存储方式

- CHAR型数据仅存储数据本身；

  VARCHAR型数据的存储方式为：1~2字节的长度前缀 + 数据；

- CHAR型数据存储时，若数据的长度小于声明的长度，则会自动在该数据的右侧用空格补全长度；

  VARCHAR型数据存储时，若数据长度小于声明的长度，不会用空格补全；

以长度为4的CHAR和VARCHAR举例：

| 值        | CHAR(4) | 所需存储空间 | VARCHAR(4) | 所需存储空间 |
| :-------- | :------ | :----------- | :--------- | :----------- |
| ''        | '    '  | 4byte        | ''         | 1byte        |
| 'ab'      | 'ab  '  | 4byte        | 'ab'       | 3byte        |
| 'abcd'    | 'abcd'  | 4byte        | 'abcd'     | 5byte        |
| 'abcdefg' | 'abcd'  | 4byte        | 'abcd'     | 5byte        |

## 是否保留末尾空格

- CHAR型数据检索时，会去除数据末尾的所有空格

- VARCHAR型数据检索时，会保留数据末尾的所有空格

举例：

```sql
CREATE TABLE varchar_and_char (v VARCHAR(4), c CHAR(4));
INSERT INTO varchar_and_char VALUES ('ab  ', 'ab  ');
SELECT CONCAT('(', v, ')'), CONCAT('(', c, ')') FROM varchar_and_char;
```

输出：

![](http://ww1.sinaimg.cn/large/98792392ly1g1anvjvl6qj20bn02q3ya.jpg)



