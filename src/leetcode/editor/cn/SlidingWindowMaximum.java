//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1788 👎 0

  
package leetcode.editor.cn;
import java.io.*;
import java.util.*;
public class SlidingWindowMaximum{
    public static void main(String[] args) {
       Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6},5);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int right = 0,left = 0;
        while (right < nums.length){
            while (deque.size() > 0 && deque.peekLast() < nums[right]) deque.removeLast();
            deque.offerLast(nums[right++]);

            if(right - left == k){
                ans.add(deque.peekFirst());
                if(nums[left] == deque.peekFirst()){
                    deque.remove(nums[left]);
                }
                left++;
            }
        }


        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}