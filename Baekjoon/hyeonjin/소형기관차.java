import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int[] sumArray = new int[N + 1];
        int[][] dp = new int[4][N + 1];
        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.valueOf(str.nextToken());
            sumArray[i] = num + sumArray[i - 1];
        }
        int K = Integer.valueOf(br.readLine());

        for(int i = 1; i < 4; i++){
            for(int j = i * K; j <= N; j++){
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - K] + (sumArray[j] - sumArray[j - K]));
            }
        }

        System.out.println(dp[3][N]);
    }
}
