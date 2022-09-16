//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 2072 👎 0

  
package leetcode.editor.cn;
import java.io.*;
import java.util.*;
public class MinimumWindowSubstring{
    public static void main(String[] args) {
       Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("ADOBECODEBANC","ABC");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        return  solution2(s,t);

    }
    public String solution(String s,String t){
        if(s.length() < t.length()) return "";
        if(s == null) return "";
        int count = Integer.MAX_VALUE;
        int left_ans = -1;
        int right_ans = -1;
        HashMap<Character,Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0) + 1);
        }
        int left = 0, right = 0;
        int valite = 0;
        HashMap<Character,Integer> smap = new HashMap<>();
        while (right < s.length()){
            //加入
            char k = s.charAt(right);
            smap.put(k,smap.getOrDefault(k,0) + 1);
            right++;
            if(smap.get(k).equals(tmap.get(k)) ) {
                valite++;
            }
            //加入后满足条件
            while (valite == tmap.size()){
                //更新结果
                if(right - left < count){
                    count = right - left;
                    left_ans = left;
                    right_ans = right;
                }
                char c = s.charAt(left);
                left++;
                if(smap.get(c).equals(tmap.getOrDefault(c,0))) valite--;
                smap.put(c,smap.get(c) - 1);

            }

        }
        return count == Integer.MAX_VALUE ?"":s.substring(left_ans,right_ans);
    }
    public String solution2(String s,String t){
        HashMap<Character, Integer> tcount = new HashMap<>();
        HashMap<Character, Integer> scount = new HashMap<>();
        String ans = "";

        for(int i = 0; i < t.length();i++){
            tcount.put(t.charAt(i),tcount.getOrDefault(t.charAt(i),0) + 1);
        }

        int left = 0;
        int right = 0;
        int cnt = 0;


        for(right = 0; right < s.length();right ++){
            //1：将left 位置所在的字符 加入到当前窗口。
            char tem = s.charAt(right);
            scount.put(tem,scount.getOrDefault(tem,0) + 1);
            //2：更新窗口
            if(scount.get(tem) <=tcount.getOrDefault(tem,0)){
                cnt++;
            }
            //3，当左边字符的数量大于tcount中的计数说明是冗余的应当删除
            while (left <= right && (scount.get(s.charAt(left)) > tcount.getOrDefault(s.charAt(left),0))){
                scount.put(s.charAt(left),scount.get(s.charAt(left))-1);
                left++;
            }

            if(cnt == t.length()){
                if(ans.length() == 0 || ans.length() > right -left + 1)
                    ans = s.substring(left,right + 1);
            }
        }

        return  ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}