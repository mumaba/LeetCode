//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 1074 👎 0

  
package leetcode.editor.cn;
import java.io.*;
import java.util.*;
public class CombinationSumIi{
    public static void main(String[] args) {
       Solution solution = new CombinationSumIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> lb = new ArrayList<>();
        Arrays.sort(candidates);
        boolean [] used = new boolean[candidates.length];
        dfs(0,candidates,0,target,used,lb);
        return ans;
    }
    public void dfs(int sum,int[] candidates,int start,int target,boolean[]used,List<Integer> tem) {
        if(sum == target){
            ans.add(new ArrayList<>(tem));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(used[i]) continue;
            if(i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) continue;
            if(sum + candidates[i] > target) break;

            tem.add(candidates[i]);
            used[i] = true;
            dfs(sum + candidates[i],candidates,i,target,used,tem);
            used[i] = false;
            tem.remove(tem.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}