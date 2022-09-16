//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 563 👎 0

  
package leetcode.editor.cn;
public class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
       Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        solution.movingCount(2,3,1);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans = 0;
    int [][] d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        dfs(0,0,used,k,m,n);
        return ans;
    }
    public void dfs(int x,int y,boolean[][] used,int k,int m,int n){//x y 新的坐标 来判断
        if(vaild(x,y,k)){
            ans++;
            //讲当前坐标标记以访问 开始访问下一个坐标
            used[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int indx = x + d[i][0];
                int indy = y + d[i][1];
                //新坐标 判断是否越界 （不越界，可以做下去dfs）
                if( indx >=0 && indx < m && indy >=0 && indy < n ){
                    if(used[indx][indy]) continue;
                    dfs(indx,indy,used,k,m,n);
                }
            }
        }



    }
    public boolean vaild(int x,int y,int k){
        String xs = x + "";
        String ys = y + "";
        long sumx = 0;
        long sumy = 0;
        for (int i = 0; i < xs.length(); i++) {
            sumx+= Integer.parseInt(xs.charAt(0) + "");
        }
        for (int i = 0; i < ys.length(); i++) {
            sumy+= Integer.parseInt(ys.charAt(0) + "");
        }
        if(sumx +sumy <= k) return true;

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}