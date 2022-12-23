import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = map[i][j];
                if (dp[i][j] == 0 || map[i][j] == 0) continue;
                if (i + n < N)
                    dp[i + n][j] += dp[i][j];
                if (j + n < N)
                    dp[i][j + n] += dp[i][j];
            }
        }
        System.out.print(dp[N - 1][N - 1]);
    }
}