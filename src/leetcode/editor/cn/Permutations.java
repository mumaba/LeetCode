//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2177 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class Permutations{
    public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> lb = new ArrayList<>();
        dfs(nums,used,lb);
        return ans;
    }

    public void dfs(int[] nums, boolean[] used, ArrayList<Integer> lb) {
        if(lb.size() == nums.length){
            ans.add(new ArrayList<>(lb));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            lb.add(nums[i]);
            used[i] = true;
            dfs(nums, used,lb);
            lb.remove(lb.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}