//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 740 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class PermutationInString{
    public static void main(String[] args) {
       Solution solution = new PermutationInString().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }
        int[] s2Count = new int[26];
        int right = 0, left = 0;
        while (right < s2.length()){
            s2Count[s2.charAt(right) - 'a']++;
            right++;
            if(right - left == s1.length()){
                if(Arrays.equals(s2Count,s1Count)) return true;
                s2Count[s2.charAt(left) - 'a']--;
                left++;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}