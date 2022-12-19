import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] memo = new long[1000001];
        memo[1] = 1;
        memo[2] = memo[1] + 1;
        memo[3] = memo[1] + memo[2] + 1;
        for (int i = 4; i < 1000001; i++) {
            memo[i] = (memo[i - 3] + memo[i - 2] + memo[i - 1]) % 1000000009;
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(memo[n]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
