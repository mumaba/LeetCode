//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2815 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class GenerateParentheses{
    public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,new StringBuilder(),n);
        return ans;
    }

    public void backtrack(int leftcount, int rightcount, StringBuilder sb,int n) {
        if(sb.length() == 2 * n){
            ans.add(sb.toString());
            return;
        }
        if(leftcount + 1 <=n ){
            sb.append("(");
            backtrack(leftcount+1,rightcount,sb,n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(rightcount + 1 <= n && rightcount + 1 <= leftcount){
            sb.append(")");
            backtrack(leftcount,rightcount+1,sb,n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}