[621. 任务调度器](https://leetcode-cn.com/problems/task-scheduler/)


## 题解
如任务 AAAA BBBB CCC D

安排任务时：
1. 优先安排任务最多的代码 A,则多出的冷却时间为 (p - 1) * n，可以用来安排剩余的任务
2. 某个任务和 A 出现的次数相同，任务 B。此时我们只能让 B 占据 p - 1 个空闲时间，而在非空闲时间里额外安排一个时间给 B 执行；
   某个任务比 A 出现的次数少 1，任务 C。此时我们可以让 C 占据 p - 1 个空闲时间，就可以全部执行完；
   某个任务比 A 出现的次数少 2 或更多，任务 D。此时我们可以按照列优先的顺序，将 D 填入空闲时间中。因为 D 出现的次数少于 p - 1，因此无论从哪个位置开始按照列优先的顺序放置，都可以保证相邻的两个 D 之间满足冷却时间的要求。
   

任务安排完成后：
1. 若还有空闲时间，答案即为（任务的总数 + 剩余的空闲时间）
2. 若空闲时候不够，答案为 任务的总数

## 代码

```java
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int maxValue = map[25] - 1;
        int reminder = maxValue * n;

        for (int i = map.length - 1; i >= 1; i--) {
            reminder -= Math.min(map[i], maxValue);
            if(map[i]==0){
                break;
            }
        }

        return reminder > 0 ? reminder + tasks.length : tasks.length;
    }
}
```