import java.io.*;
import java.util.*;

public class 좋은수열 {
    static int N;
    static String result = "";
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());

        dfs("");
        System.out.println(result);
    }

    private static void dfs(String s) {
        if(!result.isEmpty()) return;

        if(s.length() == N) {
            result = s;
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(checkBadSeq(s + i)) continue;
            dfs(s + i);
        }
    }

    private static boolean checkBadSeq(String s) {
        for(int i = 1; i <= s.length() / 2; i++){
            if(s.substring(s.length() - i).equals(s.substring(s.length() - (i * 2), s.length() - i))){
                return true;
            }
        }

        return false;
    }
}
