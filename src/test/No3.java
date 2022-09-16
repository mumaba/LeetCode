package test;

import java.util.*;

public class No3 {
    public static  char[] change(char[] line){
        for (int i = 0; i < line.length; i++) {
            if(Character.isDigit(line[i])) continue;
            if(Character.isLetter(line[i])) continue;
            if(line[i] == '-') {
                //是否是连接符（前后都是有效字母）
                if(i+1 < line.length && i - 1 >= 0){
                    char pre  = line[i -1];
                    char post  = line[i + 1];
                    //是连接符
                    if((Character.isDigit(pre) || Character.isLetter(pre)) && (Character.isDigit(post) || Character.isLetter(post))){
                        continue;
                    }else if((Character.isDigit(pre) || Character.isLetter(pre)) && post == '-'){
                        if(i+2 < line.length){
                            char postB  = line[i + 2];
                            //是间隔符
                            if((Character.isDigit(postB) || Character.isLetter(postB))){
                                line[i] = ' ';
                                line[i + 1] = ' ';
                                i++;
                                continue;
                            }
                        }
                    }else {
                        line[i] = ' ';
                    }
                }
                //是否是间隔符（有且只有2个，且前后都是有效字母）
            }else {
                line[i] = ' ';
            }
        }
        return line;
    }
    public static void print(char[] line){
        ArrayList<String> ans = new ArrayList<>();
        int i;
        int j;
        for( i = 0,j = 0; i < line.length && j < line.length; j++){
            if(line[j] == ' '){
                ans.add(new String(line,i,j - i));
                for(int k = j + 1; k < line.length; k++){
                    if(line[k] != ' '){
                        i = k;
                        j = k;
                        break;
                    }
                }
            }
        }
        ans.add(new String(line,i,j - i));
        Collections.reverse(ans);
        for (int i1 = 0; i1 < ans.size(); i1++) {
            if(i1 != ans.size() - 1){
                System.out.print(ans.get(i1) + " ");
            }else {
                System.out.print(ans.get(i1));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chars = sc.nextLine();
        //1:变换格式
        char[] line = change(chars.toCharArray());
        //2 答应输出
        print(line);


    }


}
