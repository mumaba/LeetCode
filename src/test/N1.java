package test;
import java.io.*;
import java.util.*;
public class N1 {
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
        //将a转换成b需要的最少步数
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }

            int count = 1;
            int cnt = 3;
            while (a * Math.pow(2, cnt) <b){
                count++;
                cnt = cnt + 3;

            }
            System.out.println(count);
        }
//        int[] dp = new int[b + 1];
//        dp[a] = 0;
//        if(a * 2 <= b){
//            dp[a * 2] = 1;
//        }
//        if(a * 4 <= b){
//            dp[a * 4] = 1;
//        }
//        if(a * 8 <= b){
//            dp[a * 8] = 1;
//        }
//
//
//
//        for(int i = a * 8 +1; i <= b; i++){
//
//            if( i % 8 == 0 && i % 4 == 0 &&i % 2 == 0){
//                int[] ints = new int[3];
//                ints[0] = dp[i / 8] == 0 ? 0: dp[i / 8] + 1;
//                ints[1] = dp[i / 4] == 0 ? 0: dp[i / 4] + 1;
//                ints[2] = dp[i / 2] == 0 ? 0: dp[i / 2] + 1;
//                Arrays.sort(ints);
//                int r = 0;
//                for (int anInt : ints) {
//                    if(anInt != 0) {
//                        r = anInt;
//                        break;
//                    }
//                }
//                 dp[i] =  r  == 0 ? r : r + 1;
//                break;
//
//            }else if( i % 4 == 0 &&i % 2 == 0){
//                int[] ints = new int[2];
//                ints[0] = dp[i / 4] == 0 ? 0: dp[i / 4] + 1;
//                ints[1] = dp[i / 2] == 0 ? 0: dp[i / 2] + 1;
//                Arrays.sort(ints);
//                int r = 0;
//                for (int anInt : ints) {
//                    if(anInt != 0) {
//                        r = anInt;
//                        break;
//                    }
//                }
//                dp[i] =  r  == 0 ? r : r + 1;
//            }else if(i % 2 == 0 ){
//                dp[i] = dp[i / 2]  == 0 ? dp[ i / 2] : dp[ i / 2] + 1;
//            }
//        }
//        System.out.println(dp[b]);




    }
}
