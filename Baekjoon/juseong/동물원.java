import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memo = new int[100001][3];
        memo[1][0] = 1;
        memo[1][1] = 1;
        memo[1][2] = 1;
        for (int i = 2; i <= 100000; i++) {
            memo[i][0] = (memo[i-1][0] + memo[i-1][1] + memo[i-1][2]) % 9901;
            memo[i][1] = (memo[i-1][0] + memo[i-1][2]) % 9901;
            memo[i][2] = (memo[i-1][0] + memo[i-1][1]) % 9901;
        }
        n = Integer.parseInt(br.readLine());
        System.out.println((memo[n][0] + memo[n][1] + memo[n][2]) % 9901);
    }
}
