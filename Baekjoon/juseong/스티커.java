import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] A;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            A = new int[n][2];
            memo = new int[n][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) A[j][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) A[j][1] = Integer.parseInt(st.nextToken());
            memo[0][0] = A[0][0];
            memo[0][1] = A[0][1];
            if (n > 1) {
                memo[1][0] = memo[0][1] + A[1][0];
                memo[1][1] = memo[0][0] + A[1][1];
            }
            for (int j = 2; j < n; j++) {
                memo[j][0] = Math.max(Math.max(memo[j-2][0], memo[j-2][1]), memo[j-1][1])  + A[j][0];
                memo[j][1] = Math.max(Math.max(memo[j-2][0], memo[j-2][1]), memo[j-1][0]) + A[j][1];
            }
            sb.append(Math.max(memo[n-1][0], memo[n-1][1])).append("\n");
        }
        System.out.print(sb.toString());

    }
}
