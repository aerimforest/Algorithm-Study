import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][] v;
    static String answer = "IMPOSSIBLE";
    static Queue<Point> fire = new LinkedList<>();
    static Queue<Point> que = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[R][C];

        int r, c;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char point = line.charAt(j);
                if (point == 'J'){
                    if (i == 0 || i == R-1 || j == 0 || j == C-1) {
                        answer = String.valueOf(1);
                        System.out.println(answer);
                        return;
                    }
                    que.add(new Point(i, j, 1));
                    v[i][j] = true;
                }
                else if (point == 'F')
                    fire.add(new Point(i, j));

                map[i][j] = point;
            }
        }

        bfs();


        System.out.println(answer);
    }

    private static void bfs() {

        while (!que.isEmpty()) {

            fire();
            int n = que.size();
            for (int i = 0; i < n; i++) {

                Point cur = que.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (check(nr, nc) && map[nr][nc] == '.'&&!v[nr][nc]) {
                        if (nr == 0 || nr == R-1 || nc == 0 || nc == C-1) {
                            answer = String.valueOf(cur.t + 1);
                            return;
                        }

                        que.add(new Point(nr, nc, cur.t + 1));
                        v[nr][nc] = true;
                    }
                }
            }

        }
    }

    private static void fire() {

        int n = fire.size();

        for (int i = 0; i < n; i++) {

            Point f = fire.poll();

            for (int d = 0; d < 4; d++) {
                int nr = f.r + dr[d];
                int nc = f.c + dc[d];

                if (!check(nr, nc)) continue;

                if (map[nr][nc] == '.' || map[nr][nc] == 'J') {
                    map[nr][nc] = 'F';
                    fire.add(new Point(nr, nc));
                }
            }

        }

    }


    private static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    public static class Point {
        int r;
        int c;
        int t;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

}
