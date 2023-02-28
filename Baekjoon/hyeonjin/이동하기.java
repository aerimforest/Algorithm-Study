import java.io.*;
import java.util.*;

public class 이동하기 {
    static int N;
    static int M;
    static int max = 0;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j - 1], dp[i - 1][j]));
                dp[i][j] += arr[i][j];
            }
        }

        System.out.println(dp[N][M]);
    }
}
