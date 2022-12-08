import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A, dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        Queue<Integer> Q = new LinkedList<>();
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Q.add(0);
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            for (int k = 1; k <= A[cur]; k++) {
                if (cur + k >= N) continue;
                if (dp[cur + k] == Integer.MAX_VALUE) {
                    dp[cur + k] = dp[cur] + 1;
                    Q.add(cur + k);
                } else {
                    if (dp[cur] + 1 < dp[cur + k]) {
                        dp[cur + k] = dp[cur] + 1;
                        Q.add(cur + k);
                    }
                }
            }
        }
        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
