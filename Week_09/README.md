# 动态规划

模版代码
```
# 初始化 base case
dp[0][0][...] = base
# 进行状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2...)
```

动态规划的题目难点在于
- 如何定义dp 方程
- 如何写状态转移方程


# 字符串

## 字符串操作

## 异位词

## 回文串

## 最长子串、子序列

## 字符串匹配算法


### 2.KMP
计算 P `abaacababcac` 是否包含 T `ababc`
- 计算 T 每一位的前缀和后缀的最大匹配数 q `[-1,0,0,1,2]`
- T 和 P 逐位比较，若第 n 位不匹配着移动 q[n]


