import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }
        dp[0][0] = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(dp[i][j] == 0 || arr[i][j] == 0) continue;

                for(int k = 0; k < 2; k++){
                    int x = i + dx[k] * arr[i][j];
                    int y = j + dy[k] * arr[i][j];
                    if(x < 0 || x >= N || y < 0|| y >= N) continue;

                    dp[x][y] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
