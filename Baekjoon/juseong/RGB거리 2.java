import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] A, dp;
    static int max = 1000 * 1000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = max;
        for (int s = 0; s < 3; s++) { // 0번 집의 색칠값
            dp = new int[n][3]; // dp[i][j] := A[i][j] 를 칠했을 때의 최소 비용
            for (int j = 0; j < 3; j++) { // 0번째 집을 s색 으로 고정
                if (j == s) dp[0][s] = A[0][s];
                else dp[0][j] = max;
            }

            for (int i = 1; i < n; i++) {
                // #1 0번 색을 칠했을 때의 최소 비용
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + A[i][0];

                // #2 1번 색을 칠했을 때의 최소 비용
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + A[i][1];

                // #3 2번 색을 칠했을 때의 최소 비용
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + A[i][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j == s) continue; // 0 번째 집의 색과 같을때
                ans = Math.min(ans, dp[n-1][j]);
            }
        }
        System.out.println(ans);
    }
}
