import java.io.*;
import java.util.*;

public class 앱 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int[] memory = new int[N];
        int[] cost = new int[N];
        int[][] dp = new int[N][10_001];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            memory[i] = Integer.valueOf(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cost[i] = Integer.valueOf(str.nextToken());
        }

        int result = Integer.MAX_VALUE;

        for(int j = 0; j <= 10_000; j++){
            if(j >= cost[0]) dp[0][j] = memory[0];
            if(dp[0][j] >= M) result = Math.min(result, j);
        }


        for(int i = 1; i < N; i++){
            for(int j = 0; j <= 10_000; j++){
                if(j >= cost[i]) dp[i][j] = Math.max(dp[i - 1][j - cost[i]] + memory[i], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];

                if(dp[i][j] >= M) result = Math.min(result, j);
            }
        }

        System.out.println(result);
    }
}
