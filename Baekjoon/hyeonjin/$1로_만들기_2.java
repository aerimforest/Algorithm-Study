import java.io.*;
import java.util.*;

public class $1로_만들기_2 {
    static int N;
    static Node[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.valueOf(br.readLine());
        dp = new Node[N + 1];
        dp[1] = new Node(0,0);

        for(int i = 2; i <= N; i++){
            int num = Integer.MAX_VALUE;
            int preIndex = -1;

            if(i % 3 == 0){
                num = dp[i / 3].dp;
                preIndex = i / 3;
            }

            if(i % 2 == 0){
                if(num > dp[i / 2].dp){
                    num = dp[i / 2].dp;
                    preIndex = i / 2;
                }
            }

            if(num > dp[i - 1].dp){
                num = dp[i - 1].dp;
                preIndex = i - 1;
            }

            dp[i] = new Node(num + 1, preIndex);
        }

        bw.write(String.valueOf(dp[N].dp));
        bw.newLine();
        bw.write(outputString());
        bw.flush();
    }

    private static String outputString() {
        StringBuffer sb = new StringBuffer();

        while(N > 0){
            sb.append(N).append(" ");
            N = dp[N].prev;
        }

        return sb.toString();
    }

    public static class Node{
        int dp;
        int prev;

        public Node(int dp, int prev){
            this.dp = dp;
            this.prev = prev;
        }
    }
}
