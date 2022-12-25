import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int r = R - Integer.parseInt(st.nextToken());
            if (i % 2 == 0) //왼->오
                go(r, 0);
            else // 오->왼
                go(r, 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(map[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void go(int r, int dir) {
        int c = (dir == 0) ? 0 : C - 1;

        while (c >= 0 && c < C && map[r][c] == '.') c += dc[dir];
        if (c < 0 || c >= C) return;

        v = new boolean[R][C];
        map[r][c] = '.'; // 미네랄 파괴

        bfs(); // 땅과 붙어있는 클러스터 탐색

        int min = R;
        for (int nc = 0; nc < C; nc++) {
            for (int nr = R - 1; nr >= 0; nr--) {
                // 땅과 붙어있지 않는 미네랄이라면
                if (map[nr][nc] == 'x' && !v[nr][nc]) {
                    int h = 0;
                    // 다시 땅으로 내려가면서 높이 카운트
                    for (int i = nr + 1; i < R; i++) {
                        if (map[i][nc] == 'x' && v[i][nc]) break;
                        h++;
                    }
                    min = Math.min(h, min);
                }
            }
        }

        // h만큼 내려주기
        for (int j = 0; j < C; j++) {
            for (int i = R - 1; i >= 0; i--) {
                if (map[i][j] == 'x' && !v[i][j]) {
                    map[i + min][j] = 'x';
                    map[i][j] = '.';
                }
            }
        }
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < C; i++) {
            if (map[R - 1][i] == 'x') {
                queue.add(new Point(R - 1, i));
                v[R - 1][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (check(nr, nc) && map[nr][nc] == 'x') {
                    v[nr][nc] = true;
                    queue.add(new Point(nr, nc));
                }
            }
        }
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C && !v[r][c];
    }

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}