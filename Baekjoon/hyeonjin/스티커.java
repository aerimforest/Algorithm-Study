import java.io.*;
import java.util.*;

public class 스티커 {
    static int[][] arr;
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.valueOf(br.readLine());
            arr = new int[2][N];
            dp = new int[2][N];
            for(int i = 0; i < 2; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.valueOf(str.nextToken());
                }
            }

            issueSticker();
        }
    }

    private static void issueSticker() {
        //i,j를 뜯었을때 최대 값
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];

        if(N > 1) {
            dp[0][1] = arr[0][1] + arr[1][0];
            dp[1][1] = arr[1][1] + arr[0][0];

            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[0][i - 2], Math.max(dp[1][i - 2], dp[1][i - 1])) + arr[0][i];
                dp[1][i] = Math.max(dp[1][i - 2], Math.max(dp[0][i - 2], dp[0][i - 1])) + arr[1][i];
            }
        }

        System.out.println(String.valueOf(Math.max(dp[0][N-1], dp[1][N-1])));
    }
}
