# 学习笔记-BFS/DFS/贪心/二分
[TOC]

## 解题套路

### 深度优先搜索和广度优先搜索

- DFS: 深度优先搜索 Depth-First-Search 
- BFS: 广度优先搜索 Breadth-First-Search 

#### 1.代码模版

**DFS 代码模版**

```python
visited = set()
def dfs(node, visited):
    # terminator
    if node in visited:  
    # already visited 
        return
    visited.add(node)
    # process current node here.
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```


**BFS 代码模版**
```python
def BFS(graph, start, end):
    queue = [] 
    queue.append([start]) 
    visited.add(start)
    while queue:
        node = queue.pop() visited.add(node)
        process(node) nodes = generate_related_nodes(node) queue.push(nodes)
    # other processing work ...
```

#### 2.特征识别
在一个树或者二维数组中去查找某个值，或者需要遍历

#### 3.题型变化

模版很简单，只是题目会由于需求变得复杂。所以核心的记住模版，再在基础上变形

### 贪心算法

#### 1.特征识别

通常用于求最优问题，子问题的最优就是整体最优
使用贪心算法不能回退，一旦能用贪心算法求解就是最优解

### 二分查找

#### 1.代码模版
```python
left, right = 0, len(array) - 1 
while left <= right:
    mid = (left + right) / 2 
    if array[mid] == target:
        # find the target!!
            break or return result 
    elif array[mid] < target:
        left = mid + 1 
    else:
        right = mid - 1
```

#### 2.特征识别
二分查找的前提
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

#### 3.题型变化
- 遇见数据量特大时，使用位运算找中间值：mid = low + ((high - low) >> 1);
- 有序数组被旋转了，此时 array[mid] 需要和 array[right] 进行比较，找出无序的段
```java
    public int find(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            //使用位运算计算中间点
            int mid = low + ((high - low) >> 1);
            //说明右侧有序，无序点在左侧
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                //否则，无序点在左侧
                low = mid + 1;
            }

        }

        return nums[low];
    }
```


## 题目

| 编号 | 题目 | 难度 | 分类 | 题解 |
|----|----|----|----|----|
|  860  | [柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/)   |  简单  |  贪心  |  [贪心算法](./860.lemonade-change.md)  |
|  122  | [买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)    |  简单  |  贪心  |  [贪心算法](./122-best-time-to-buy-and-sell-stock-ii.md)  |
|  455  | [分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/)  |  简单  |  贪心  |  [贪心算法](./455.assign-cookies.md)  |
|  874  | [模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/)   |  简单  |  贪心  |  [贪心算法](./847-walking-robot-simulation.md)  |
|  127  | [单词接龙](https://leetcode-cn.com/problems/word-ladder/description/)   |  中等  |  BFS/DFS  |  [BFS](./127-word-ladder.md)  |
|  200  | [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)   |  中等  |  BFS/DFS  |  [BFS](./200-number-of-islands.md)  |
|  529  | [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/)   |  中等  |  BFS/DFS  |  [DFS](./529-minesweeper.md)  |
|  55  | [跳跃游戏](https://leetcode-cn.com/problems/jump-game/)   |  中等  |  贪心  |  [贪心算法](./200-number-of-islands.md)  |
|  33  | [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)   |  中等  |  二分  |  [二分法](./33-search-in-rotated-sorted-array.md)  |
|  74  | [搜索二维矩阵 ](https://leetcode-cn.com/problems/search-a-2d-matrix/)  |  中等  |  二分  |  [二分法](./74-search-a-2d-matrix.md)  |
|  153  | [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)   |  中等  |  二分  |  [二分法](./153-find-minimum-in-rotated-sorted-array.md)  |
|  126  | [单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/description/)  |  困难  |  BFS/DFS  |  TODO  |
|  45  | [跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)  |  困难  |  贪心  |  [贪心算法](./45-jump-game-ii.md)  |


