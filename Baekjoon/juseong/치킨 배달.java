import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, C, ans;
    static int[][] board, chicken;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        chicken = new int[N*N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void calculation(int[] arr) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    int d = Integer.MAX_VALUE;
                    for (int c: arr) {
                        d = Math.min(d, Math.abs(i - chicken[c][0]) + Math.abs(j - chicken[c][1]));
                    }
                    sum += d;
                }
            }
        }

        ans = Math.min(ans, sum);
    }

    static void rec_func(int k, int cnt, int flag) {
        if (cnt == M) {
            int[] c = new int[M];
            int idx = 0;
            for (int i = 0; i < C; i++) {
                if ((flag & 1 << i) > 0) {
                    c[idx] = i;
                    idx++;
                }
            }
            calculation(c);
        }

        if (k == C) return;
        rec_func(k + 1, cnt + 1, flag | 1 << k);
        rec_func(k + 1, cnt, flag);
    }

    static void pro() {
        C = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 2) {
                    chicken[C][0] = i;
                    chicken[C][1] = j;
                    C++;
                }
            }
        }
        ans = Integer.MAX_VALUE;
        rec_func(0 ,0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}