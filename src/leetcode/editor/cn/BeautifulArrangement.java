//假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ： 
//
// 
// perm[i] 能够被 i 整除 
// i 能够被 perm[i] 整除 
// 
//
// 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：
//第 1 个优美的排列是 [1,2]：
//    - perm[1] = 1 能被 i = 1 整除
//    - perm[2] = 2 能被 i = 2 整除
//第 2 个优美的排列是 [2,1]:
//    - perm[1] = 2 能被 i = 1 整除
//    - i = 2 能被 perm[2] = 1 整除
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 15 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 317 👎 0

  
package leetcode.editor.cn;
public class BeautifulArrangement{
    public static void main(String[] args) {
       Solution solution = new BeautifulArrangement().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        dfs(nums,0,used,1);
        return ans;
    }

    public void dfs(int[] nums,int indx, boolean[] used,int level) {
        if(indx == nums.length){
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            if(nums[i] % level == 0 || level % nums[i] == 0){
                used[i] = true;
                dfs(nums, indx + 1,used,level + 1);
                used[i] = false;
            }


        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}