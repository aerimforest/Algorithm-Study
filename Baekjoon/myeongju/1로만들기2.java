import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] path = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {

            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                    path[i] = i / 3;
                }
            }

            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                    path[i] = i / 2;
                }
            }

            if (dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                path[i] = i - 1;
            }
        }

        sb.append(dp[N]+"\n");

        while (N > 0) {
            sb.append(N+" ");
            N =path[N];
        }

        System.out.println(sb.toString());
    }
}