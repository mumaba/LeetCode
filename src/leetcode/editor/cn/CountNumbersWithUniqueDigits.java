//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10ⁿ 。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：1
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 数学 动态规划 回溯 👍 297 👎 0

  
package leetcode.editor.cn;
public class CountNumbersWithUniqueDigits{
    public static void main(String[] args) {
       Solution solution = new CountNumbersWithUniqueDigits().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans = 0;
    boolean[] used = new boolean[10];
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;

        for (int i = 1; i < 10; i++) {
            used[i] = true;
            backtrack(i,1,n);
            used[i] = false;
        }

        return ans + 1;

    }
    public void backtrack(int num,int start,int n) {
        if(num >=0) ans++;
        if(start == n) return;
        for (int i = 0; i < 10; i++) {
           if(used[i]) continue;
           used[i] = true;
           backtrack(i,start+1,n);
           used[i] = false;
       }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}