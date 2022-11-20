import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.valueOf(str.nextToken());
        int k = Integer.valueOf(str.nextToken());

        int[][] dp = new int[num + 1][k + 1];

        for(int i = 0 ; i <= num; i++){
            dp[i][1] = 1;
        }

        for(int i = 0; i <=num; i++){
            for(int j = 2; j <= k; j++){
                int sum = 0;
                for(int a = 0; a <= i; a++){
                    sum += dp[a][j-1];
                    sum %= MOD;
                }
                dp[i][j] = sum;
            }
        }
        bw.write(String.valueOf(dp[num][k]));
        bw.flush();
    }

}
