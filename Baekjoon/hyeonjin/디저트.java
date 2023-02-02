import java.io.*;
import java.util.*;

public class 디저트 {
    static int N;
    static int M;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        dp = new int[M][N];
        arr = new int[M][N];
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        for(int j = 0; j < M; j++) {
            dp[j][0] = arr[j][0];
        }


        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int preMax = getMax(i, j);
                dp[j][i] = Math.max(preMax + arr[j][i], dp[j][i-1] + (arr[j][i] / 2));
            }
        }

        int result = 0;
        for(int j = 0; j < M; j++) {
            result = Math.max(result, dp[j][N - 1]);
        }
        System.out.println(result);
    }

    private static int getMax(int day, int except) {
        int max = 0;
        for(int i = 0; i < M; i++) {
            if(i == except) continue;

            max = Math.max(max, dp[i][day - 1]);
        }
        return max;
    }
}
