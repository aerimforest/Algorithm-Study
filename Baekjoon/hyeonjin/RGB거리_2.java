import java.io.*;
import java.util.*;

public class RGB거리_2 {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        for(int i = 0; i < 3; i++){
            getDP(i);
        }

        System.out.println(min);
    }

    private static void getDP(int target) {
        for(int i = 0; i < 3; i++){
            if(i == target) dp[0][i] = arr[0][i];
            else dp[0][i] = 1_000 * 1_000;
        }

        for(int i = 1; i < N; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + arr[i][2];
        }

        for(int i = 0; i < 3; i++){
            if(i != target) min = Math.min(min, dp[N - 1][i]);
        }
    }
}
