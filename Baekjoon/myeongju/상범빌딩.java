import java.io.*;
import java.util.*;

public class Main {

    static int L, R, C;
    static char[][][] map;
    static Point start;
    static int[] dl = {0, -1, 0, 1, 0, 0};
    static int[] dr = {1, 0, -1, 0, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String l = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = l.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start = new Point(i, j, k, 0);
                            map[i][j][k] = '#';
                        }
                    }
                }
                br.readLine();
            }

            bfs();

        }

        System.out.println(sb);
    }

    private static void bfs() {

        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            Point now = q.poll();

            for (int d = 0; d < 6; d++) {

                int nl = now.l + dl[d];
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (!check(nl, nr, nc)) continue;

                if (map[nl][nr][nc] == 'E') {
                    sb.append("Escaped in ").append(now.cnt + 1).append(" minute(s).\n");
                    return;
                }

                q.add(new Point(nl, nr, nc, now.cnt + 1));
                map[nl][nr][nc] = '#';

            }

        }

        sb.append("Trapped!\n");
    }

    private static boolean check(int l, int r, int c) {
        return l >= 0 && l < L && r >= 0 && r < R && c >= 0 && c < C && map[l][r][c] != '#';
    }

    public static class Point {
        int l;
        int r;
        int c;
        int cnt;

        public Point(int l, int r, int c, int cnt) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

}