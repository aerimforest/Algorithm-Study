import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] P;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 카드의 개수 (1 ≤ N ≤ 1,000)
        P = new int[N+1]; // 카드팩의 가격 (1 ≤ Pi ≤ 10,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) P[i] = Integer.parseInt(st.nextToken());
        memo = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) { // 카드팩
            for (int j = 1; j <= N; j++) { // 카드개수
                if (j - i >= 0) {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-i] + P[i]);
                } else {
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        System.out.println(memo[N][N]);
    }
}
