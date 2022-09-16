import java.io.*;
import java.util.*;
public class pa {
    static long ans = 0;
    public static void main(String[] args) {
        //判断图是否联通
        int[][] ints ={{}



        };
        System.out.println(ints.length);
        long solution = solution(ints, 4, 2);
        System.out.println(solution);



    }
    public static long solution(int[][] re,int n,int start){
        //
        int[][] graph = new int[n][n];
        for (int[] ints : re) {
            graph[ints[0]-1][ints[1]-1] = ints[2];
        }
        int[] visited = new int[n];
        //广度优先遍历计算树的高度
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start-1);
        visited[start-1] = 1;
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < n; j++) {
                    if(graph[poll][j] != 0 && visited[j] == 0){
                        queue.add(j);
                        visited[j] = 1;
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) return -1;
        }
        return count - 1;


    }

}
