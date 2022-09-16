//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 977 👎 0

  
package leetcode.editor.cn;

import java.util.List;
import java.io.*;
import java.util.*;

public class FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd","abc");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return  solutio3(s,p);
    }
    public List<Integer> solution(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> pmap = new HashMap<>();
        char[] pchars = p.toCharArray();

        for (int i = 0; i < pchars.length; i++) {
            pmap.put(pchars[i],pmap.getOrDefault(pchars[i],0) + 1);
        }
        HashMap<Character,Integer> smap = new HashMap<>();
        int right = 0;
        int count = 0;
        int left = 0;
        while (right < s.length()){
            char t = s.charAt(right);
            //加入窗口
            smap.put(s.charAt(right),smap.getOrDefault(s.charAt(right),0) + 1);
            //更新窗口里有效的字符个数
            if(smap.get(s.charAt(right)).equals(pmap.getOrDefault(s.charAt(right),0)))  count++;
            right++;
            if(right - left == p.length()){
                char c = s.charAt(left);
                if(count == pmap.size()) ans.add(left);
                left++;
                if(smap.get(c).equals(pmap.getOrDefault(c,0)))  count--;
                smap.put(c,smap.get(c) - 1);

            }

        }

        return ans;
    }
    public List<Integer> solutio2(String s, String p) {
        char[] chars = p.toCharArray();
        Arrays.sort(chars);

        List<Integer> ans = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        for (int i = 0; i <= slen - plen; i++) {
            String substring = s.substring(i, i + plen);
            char[] chars_sub = substring.toCharArray();
            Arrays.sort(chars_sub);
            if( Arrays.equals(chars,chars_sub)) ans.add(i);
        }
        return ans;
    }

    public List<Integer> solutio3(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] pcount = new int[26];
        int[] scount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pcount[p.charAt(i) - 'a']++;
        }
        int right = 0;
        int left = 0;

        while (right < s.length()){
            scount[s.charAt(right) - 'a']++;
            right++;
            if(right - left == p.length()){
                if( Arrays.equals(scount,pcount)) ans.add(left); //比较相等
                scount[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}