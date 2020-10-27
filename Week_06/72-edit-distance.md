[72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)

## 题解


## 代码
```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if(m*n==0){
            return m+n;
        }

        int [][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }

        for(int i=0;i<n+1;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
             int top=dp[i-1][j];
             int left=dp[i][j-1];
             int top_left=dp[i-1][j-1];
             // 此处的 i 比 word 的下标多 1，所以要 -1
             if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    top_left -= 1;
             }
            dp[i][j]=Math.min(top,Math.min(left,top_left))+1;
            }
        }

        return dp[m][n];
    }
}
```