# HashMap（基于 Jdk1.8）

## 1.HashMap 的主体数据结构
数组+链表（树）

## 2.是如何计算 hash 值的

```java
return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
```
key 的值或运算 key的hash值无符号右移 16位

> 源码中解释了这种简单方式散列的原因：
> 1.效率高
> 2.基本分散
> 3.使用了树解决 hash 碰撞


## 3.是如何做扩容的？
扩容是指 key 的数量大于了阈值，将整个 key 值的数组大小变为 2 倍，并移动需要改变下标的 value 到新的下标。

## 4.如何解决 hash 冲突的
hash 冲突就是指两个不同的 key 有相同 hash 值，发生冲突时会将 value 放入对映的链表后。

## 5.满足什么条件后将链表转化成红黑树？
```java
static final int TREEIFY_THRESHOLD = 8;
if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     treeifyBin(tab, hash);
```
节点个数大于 8 时，链表会变成红黑树