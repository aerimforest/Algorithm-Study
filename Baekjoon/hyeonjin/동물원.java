import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.valueOf(br.readLine());
        int mod = 9901;
        int[][] dp = new int[num][3];

        dp[0][0] = 1; //O X
        dp[0][1] = 1; //X O
        dp[0][2] = 1; //X X

        for(int i = 1; i < num; i++){
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
        }

        bw.write(String.valueOf( (dp[num - 1][0] + dp[num -1][1] + dp[num - 1][2]) % mod));
        bw.flush();
    }
}
