import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3][2]; //0: 최대 저장, 1 : 최소 저장

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        getScore();

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < 3; i++){
            max = Math.max(max, dp[N - 1][i][0]);
            min = Math.min(min, dp[N - 1][i][1]);
        }

        System.out.println(max + " " + min);
    }

    private static void getScore() {
        //기본 값 넣기
        for(int i = 0; i < 3; i++){
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
        }


        for(int i = 1; i < N; i++){
            //최대값 넣기
            dp[i][0][0] = arr[i][0] + Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][0][1] = arr[i][0] + Math.min(dp[i - 1][0][1], dp[i - 1][1][1]);

            dp[i][1][0] = arr[i][1] + Math.max(dp[i - 1][0][0], Math.max(dp[i - 1][1][0], dp[i - 1][2][0]));
            dp[i][1][1] = arr[i][1] + Math.min(dp[i - 1][0][1], Math.min(dp[i - 1][1][1], dp[i - 1][2][1]));

            dp[i][2][0] = arr[i][2] + Math.max(dp[i - 1][1][0], dp[i - 1][2][0]);
            dp[i][2][1] = arr[i][2] + Math.min(dp[i - 1][1][1], dp[i - 1][2][1]);
        }
    }
}
