import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static long[] dp = new long[1000001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++)
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }

        System.out.print(sb);
    }
}
