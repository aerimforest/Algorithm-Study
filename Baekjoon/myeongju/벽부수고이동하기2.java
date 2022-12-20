import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0, 0, -1};
    static char[][] map;
    static boolean[][][] v;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        v = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        v[0][0][0] = true;
        System.out.print(bfs());
    }

    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.r == N - 1 && now.c == M - 1) return now.cnt;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (map[nr][nc] == '1' && now.k < K && !v[nr][nc][now.k + 1]) {
                    v[nr][nc][now.k + 1] = true;
                    queue.add(new Point(nr, nc, now.k + 1, now.cnt + 1));
                } else if (map[nr][nc] == '0' && !v[nr][nc][now.k]) {
                    v[nr][nc][now.k] = true;
                    queue.add(new Point(nr, nc, now.k, now.cnt + 1));
                }
            }
        }
        return -1;
    }

    public static class Point {
        int r;
        int c;
        int k;
        int cnt;

        public Point(int r, int c, int k, int cnt) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.cnt = cnt;
        }
    }
}