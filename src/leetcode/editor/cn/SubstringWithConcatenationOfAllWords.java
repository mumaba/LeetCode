//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 799 👎 0

  
package leetcode.editor.cn;

import java.util.List;
import java.io.*;
import java.util.*;

public class SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
       Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String,Integer> wmap = new HashMap<>();
        for (String word : words) {
            wmap.put(word,wmap.getOrDefault(word,0) + 1); //快捷代码
        }
        int size = words.length;
        int len = words[0].length();
        for (int i = 0; i <= s.length() - size * len; i++) {
            String subs = s.substring(i, i + len * size);
            HashMap<String,Integer> smap = new HashMap<>();
            for (int j = 0; j < subs.length(); j+= len) {
                String w = subs.substring(j,j+len);
                smap.put(w,smap.getOrDefault(w,0) + 1); //快捷代码
            }
            if(smap.equals(wmap)){
                ans.add(i);
            }

        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}