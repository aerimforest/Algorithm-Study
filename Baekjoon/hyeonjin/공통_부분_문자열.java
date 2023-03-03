import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int max = 0;

        int[][] dp = new int[s1.length()][s2.length()];

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(0)) dp[i][0] = 1;
        }

        for(int i = 0; i < s2.length(); i++){
            if(s1.charAt(0) == s2.charAt(i)) dp[0][i] = 1;
        }


        for(int i = 1; i < s1.length(); i++){
            for(int j = 1; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
