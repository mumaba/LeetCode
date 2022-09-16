//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1349 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;

public class TargetSum{
    public static void main(String[] args) {
       Solution solution = new TargetSum().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(Math.abs(target) > sum) return 0;

        if((sum + target) % 2 != 0 ) return 0;
        int n = (sum + target)/ 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for(int j = n; j >= nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[n];

//        int[] postSum = new int[nums.length];
//        int[] postSum_n = new int[nums.length];
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if(i == nums.length - 1){
//                postSum[i] = nums[i];
//                postSum_n[i] = -nums[i];
//                continue;
//            }
//            postSum[i] = nums[i] + postSum[i + 1];
//            postSum_n[i] = -nums[i] + postSum_n[i + 1];
//        }
//        dfs(nums,target,0,0,postSum,postSum_n);
//        return ans;

    }
    public void dfs(int[] nums, int target,int sum,int indx,int[] postSum,int[] postSum_n) {
        if(indx == nums.length){
            if(sum == target) ans++;

            return;
        }
        if(indx +1 < nums.length && (sum + postSum[indx + 1] < target || sum + postSum_n[indx + 1] > target)) return;
        dfs(nums,target,sum + -1 * nums[indx],indx + 1,postSum,postSum_n);
        dfs(nums,target,sum + 1 * nums[indx],indx + 1,postSum,postSum_n);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}