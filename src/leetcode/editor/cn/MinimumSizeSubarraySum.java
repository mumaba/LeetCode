//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1306 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
       Solution solution = new MinimumSizeSubarraySum().new Solution();
        solution.solution1(7, new int[]{2,3,1,2,4,3});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return  solution1(target,nums);

    }
    public  int solution(int target, int[] nums){
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length){
            sum+= nums[right];
            right++;
            while (sum >= target){
                ans = Math.min(ans,right - left);
                sum = sum - nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public  int solution1(int target, int[] nums){
        int ans = Integer.MAX_VALUE;
        int [] preSum = new int[nums.length + 1];  //前缀和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(preSum));
        for (int i = 0; i < preSum.length; i++) {
            int t = preSum[i] + target;
//            二分查找（）有序
            int pos = Arrays.binarySearch(preSum, t);
            //如果没有找到 返回 -（insertpos） - 1
            if(pos < 0){
                pos = -( pos + 1);
            }
            if(pos <= nums.length){
                ans = Math.min(ans,pos - i );
            }



        }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}