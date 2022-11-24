import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(br.readLine());

        int[][] dp = new int[num + 1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 1; i <= num; i++){
            dp[i][0] = 1;
        }


        for(int i = 2; i <= num; i++){
            for(int j = 1; j < 10; j++){
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10_007;

            }
        }

        int sum = 1;

        for(int i = 1; i < 10; i++){
            sum += dp[num][i];
            sum %= 10_007;
        }

        System.out.println(sum);
    }
}
