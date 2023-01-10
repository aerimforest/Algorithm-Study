import java.io.*;
import java.util.*;

public class 징검다리_건너기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());

        if(N == 1){
            System.out.println(0);
            return;
        }

        List<Stone> stone = new ArrayList<>();
        int[][] dp = new int[N][2];
        for(int i = 1; i < N; i++){
            str = new StringTokenizer(br.readLine());
            stone.add(new Stone(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken())));
        }
        int K = Integer.valueOf(br.readLine());

        dp[0][0] = 0;
        dp[1][0] = stone.get(0).small;
        dp[0][1] = 0;
        dp[1][1] = 0;

        for(int i = 2; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][0] + stone.get(i-1).small, dp[i-2][0] + stone.get(i-2).large);
            if(i < 3) continue;

            dp[i][1] = Math.min(dp[i-3][0] + K,
                    Math.min(dp[i-1][1] > 0 ? dp[i-1][1] + stone.get(i - 1).small : Integer.MAX_VALUE,
                            dp[i-2][1] > 0 ? dp[i-2][1] + stone.get(i-2).large : Integer.MAX_VALUE));
        }

        if(N > 3) System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
        else System.out.println(dp[N-1][0]);

    }

    static class Stone{
        int small;
        int large;

        public Stone(int s, int l){
            this.small = s;
            this.large = l;
        }
    }
}
