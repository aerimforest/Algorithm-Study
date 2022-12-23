import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] memo;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        memo = new long[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0, index = 0; j < N; j++, index+=2) {
                A[i][j] = s.charAt(index) - '0';
            }
        }
        memo[0][A[0][0]] = 1; // 시작점이 오른쪽으로 이동
        memo[A[0][0]][0] = 1; // 시작점이 아래쪽으로 디동
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (memo[i][j] == 0 || A[i][j] == 0) continue; // 이동할 수 없는 칸이면
                if (j + A[i][j] < N) { // 오른쪽으로 이동이 가능하면
                    memo[i][j + A[i][j]] += memo[i][j]; // 오른쪽으로 이동
                }
                if (i + A[i][j] < N) { // 아래쪽으로 이동이 가능하면
                    memo[i + A[i][j]][j] += memo[i][j]; // 아래쪽으로 이동
                }
            }
        }
        System.out.println(memo[N-1][N-1]);
    }
}
