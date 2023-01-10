import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, k;
    static int[][] stone;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stone = new int[20][2];
        memo = new int[21][2];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stone[i][0] = Integer.parseInt(st.nextToken());
            stone[i][1] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            memo[i][0] = 1000000;
            memo[i][1] = 1000000;
        }
        memo[1][0] = 0;
        memo[2][0] = stone[1][0];
        memo[3][0] = Math.min(memo[2][0] + stone[2][0], stone[1][1]);
        for (int i = 4; i <= N; i++) {
            memo[i][0] = Math.min(memo[i-1][0] + stone[i-1][0], memo[i-2][0] + stone[i-2][1]);
            memo[i][1] = Math.min(Math.min(memo[i-1][1] + stone[i-1][0], memo[i-2][1] + stone[i-2][1]), memo[i-3][0] + k);
        }
        System.out.println(Math.min(memo[N][0], memo[N][1]));
    }
}
