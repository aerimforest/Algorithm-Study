import java.util.*;
import java.io.*;

/*
B -> E
 */
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int max = 0;
    static int[] dr = {0, -1, 1, 0};
    static int[] dc = {1, 0, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // ㅡ ㄱ ㅁ z
                dfs(i, j, 0, 0);
                // ㅗ
                func(i, j);
            }
        }
        System.out.print(max);
    }

    public static void dfs(int r, int c, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (check(nr, nc) && !v[nr][nc]) {
                v[r][c] = true;
                dfs(nr, nc, cnt + 1, sum + map[r][c]);
                v[r][c] = false;
            }
        }
    }

    public static void func(int r, int c) {
        if ((r == 0 || r == N - 1) && (c == 0 || c == M - 1)) return;
        int sum = map[r][c];
        boolean out = false;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!check(nr, nc)) {
                out = true;
                continue;
            }
            sum += map[nr][nc];
        }

        if (!out) {
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                max = Math.max(max, (sum - map[nr][nc]));
            }
        } else max = Math.max(sum, max);
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}