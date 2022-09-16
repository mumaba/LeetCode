//给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。 
//
// 在执行上述操作后，返回包含相同字母的最长子字符串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由大写英文字母组成 
// 0 <= k <= s.length 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 673 👎 0

  
package leetcode.editor.cn;
import java.io.*;
import java.util.*;
public class LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
       Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        //替换字母形成的重复的字串 满足 字串里面最长的字母个数 + k = 字串的长度，当字串的长度 》  字串里面最长的字母个数 + k 说明形成不了连续重复
        //重复字串，缩小字串，
        int ans = 0;
        int[] count = new int[128];
        int right = 0;
        int left = 0;
        int maxCount = 0; //保存当前窗口的出现次数最多的字母
        while (right < s.length()){
            //加入
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount,count[s.charAt(right) - 'A']);
            right++;

            if(maxCount + k < right - left){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            //如果满足条件会一直扩张
            ans = Math.max(ans,right-left);
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}