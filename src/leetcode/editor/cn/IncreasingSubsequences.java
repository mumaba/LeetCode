//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 👍 499 👎 0

  
package leetcode.editor.cn;
import java.io.*;
import java.util.*;
public class IncreasingSubsequences{
    public static void main(String[] args) {
       Solution solution = new IncreasingSubsequences().new Solution();
        solution.findSubsequences(new int[]{4,6,7,7});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        boolean[] used = new boolean[nums.length];
        dfs(nums,0,new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums,int idx,List<Integer> tem) {

        if(tem.size() >= 2) ans.add(new ArrayList<>(tem));
        if(idx == nums.length) return;

        Set<Integer> used = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            //如果
            if(used.contains(nums[i])) continue;
            //如果当前小于上一个元素 剪枝
            if(tem.size() > 0 && nums[i] <  tem.get(tem.size() - 1) ) continue;
            used.add(nums[i]);
            tem.add(nums[i]);
            dfs(nums,i + 1,tem);
            tem.remove(tem.size() - 1);

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}