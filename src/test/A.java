package test;
import java.io.*;
import java.util.*;
public class A {
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
    static  int ans = 0;
    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }
        boolean[] used = new boolean[n];
        dfs(nums,used,k,1,0);
        System.out.println(ans);
    }
    public static void dfs(int[] nums,  boolean[] used, int k,long count,int len) {

        if(len > 2) return;
        if(count >=k && len == 2) {
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            dfs((nums),used,k,count*nums[i],len + 1);
            used[i] = false;
        }
    }
}
