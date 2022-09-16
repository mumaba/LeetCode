package test;
import java.io.*;
import java.util.*;
public class P01 {
    public static StreamTokenizer in = new  StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //        读取整数，回车，空格，tab停止
    public static int nextInt() {
        try {
            in.nextToken();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (int) in.nval;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int vol = nextInt();
        int[] ws = new int[n];
        int[] val  = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = nextInt();
            val[i] = nextInt();
        }

        int[] dp = new int[vol + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) { //对于新的到来的每一件物品来说，都可以来更新 在一定容量下的最优解
            for(int j = vol; j >= ws[i]; j--){
                dp[j] = Math.max(dp[j -ws[i]] +val[i],dp[j]) ;
            }
        }
        System.out.println(dp[vol]);

    }

    public void ans1(){
//        int[][] dp = new int[n + 1][vol + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= vol; j++) {
//                if(ws[i -1] <= j){
//                    dp[i][j] = Math.max(dp[i-1][j] , dp[i - 1][j - ws[i - 1]] + val[i - 1]);
//                }
//            }
//        }
//
//        System.out.println(dp[n][vol]);
    }
}
