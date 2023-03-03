import java.io.*;
import java.util.*;

public class RGB거리 {
    static int N;
    static int[][] arr;
    static int[][] dp;
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

        getDP();

        int min = Math.min(Math.min(dp[N - 1][0],dp[N - 1][1]),dp[N - 1][2]);
        System.out.println(min);
    }

    private static void getDP() {
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i = 1; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

    }
}
