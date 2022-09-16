package test;
import java.io.*;
import java.util.*;
public class xiaomi3 {
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
        //不重合覆盖区间的总长度
        int n = nextInt();
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            ints[i][0] = nextInt();
            ints[i][1] = nextInt();
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int count = 0;
        int[] dp = new int[n];
        dp[0] = ints[0][1] - ints[0][0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(ints[i][0] >= ints[j][1]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + ints[i][1] - ints[i][0];
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }

}
