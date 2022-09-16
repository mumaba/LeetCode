//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
// Related Topics 数学 动态规划 组合数学 👍 1529 👎 0

  
package leetcode.editor.cn;
public class UniquePaths{
    public static void main(String[] args) {
       Solution solution = new UniquePaths().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int ans = 0;
    public int uniquePaths(int m, int n) {
//        return dp(m,n);
//        boolean[][] used = new boolean[m][n];
//        dfs(0,0,m,n,used);
//        return ans;
       return fib(0,0,m,n);
    }
    public int dp(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) dp[0][i] = 1;
        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public void dfs(int x, int y,int m, int n,boolean [][] used){
        if(y >=n || x >=m) return;
        if(x == m - 1 && y == n - 1) {
            ans++;
            return ;
        }
        used[x][y] = true;
        dfs(x, y+1,m,n,used);
        used[x][y] =false;

        used[x][y] = true;
        dfs(x+1, y,m,n,used);
        used[x][y] =false;

    }
    public int  fib(int x, int y,int m, int n){
        if(y >=n || x >=m) return 0;
        if(x == m - 1 && y == n - 1) {
            return 1;
        }
        return fib(x,y+1,m,n) + fib(x + 1,y,m,n);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}