# Algorithms-in-Java
>java版数据结构与算法

## 第几天？

Problem Description

给定一个日期，输出这个日期是该年的第几天。
 

Input

输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成，具体参见sample input ,另外，可以向你确保所有的输入数据是合法的。
 

Output

对于每组输入数据，输出一行，表示该日期是该年的第几天。
 

Sample Input
- 1985/1/20
- 2006/3/12
 

Sample Output
- 20
- 71 

[TheDay](https://github.com/mohong/Algorithms-in-Java/blob/master/TheDay.java)

----------

## 18岁生日

Problem Description

Gardon的18岁生日就要到了，他当然很开心，可是他突然想到一个问题，是不是每个人从出生开始，到达18岁生日时所经过的天数都是一样的呢？似乎并不全都是这样，所以他想请你帮忙计算一下他和他的几个朋友从出生到达18岁生日所经过的总天数，让他好来比较一下。
 

Input

一个数T，后面T行每行有一个日期，格式是YYYY-MM-DD。如我的生日是1988-03-07。
 

Output

T行，每行一个数，表示此人从出生到18岁生日所经过的天数。如果这个人没有18岁生日，就输出-1。
 

Sample Input
- 1
- 1988-03-07
 

Sample Output
- 
- 6574

[AgeEighteen](https://github.com/mohong/Algorithms-in-Java/blob/master/AgeEighteen.java)


----------

## ZOJ

Problem Description

读入一个字符串，字符串中包含ZOJ三个字符，个数不一定相等，按ZOJ的顺序输出，当某个字符用完时，剩下的仍然按照ZOJ的顺序输出。
 

Input

题目包含多组用例,每组用例占一行，包含ZOJ三个字符，当输入“E”时表示输入结束。
1<=length<=100。
 

Output

对于每组输入,请输出一行，表示按照要求处理后的字符串。
具体可见样例。
 

Sample Input

- ZZOOOJJJ
- ZZZZOOOOOJJJ
- ZOOOJJ
- E
 

Sample Output
- ZOJZOJOJ
- ZOJZOJZOJZOO
- ZOJOJO


----------

## 愚人节的礼物

Problem Description

四月一日快到了，Vayko想了个愚人的好办法——送礼物。嘿嘿，不要想的太好，这礼物可没那么简单，Vayko为了愚人，准备了一堆盒子，其中有一个盒子里面装了礼物。盒子里面可以再放零个或者多个盒子。假设放礼物的盒子里不再放其他盒子。

用()表示一个盒子，B表示礼物，Vayko想让你帮她算出愚人指数，即最少需要拆多少个盒子才能拿到礼物。
 

Input

本题目包含多组测试，请处理到文件结束。
每组测试包含一个长度不大于1000,只包含'(',')'和'B'三种字符的字符串，代表Vayko设计的礼物透视图。
你可以假设，每个透视图画的都是合法的。
 

Output

对于每组测试，请在一行里面输出愚人指数。
 

Sample Input

- ((((B)()))())
- (B)
 

Sample Output

- 4
- 1

[FoolsDayGifts_skill](https://github.com/mohong/Algorithms-in-Java/blob/master/FoolsDayGifts_skill.java)
[FoolsDayGifts_Stack](https://github.com/mohong/Algorithms-in-Java/blob/master/FoolsDayGifts_stack.java)

## 参考博客：[JINKELA_](http://blog.csdn.net/GoodLuckAC/article/category/5665809)