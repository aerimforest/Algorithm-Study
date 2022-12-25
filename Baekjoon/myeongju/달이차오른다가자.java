import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

/*
. 빈칸
# 절대 불가
a b c d e f 열쇠
A B C D E F 문
0 민식이 서있는 곳
1 출구
 */
public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][][] v;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        v = new boolean[64][R][C];

        int r = 0, c = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '0') {
                    r = i;
                    c = j;
                }
            }
        }
        System.out.print(bfs(r, c));
    }

    public static int bfs(int r, int c) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c, 0, 0));
        v[0][r][c] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (check(nr, nc) && !v[now.key][nr][nc]) {
                    // 소문자
                    if (Character.isLowerCase(map[nr][nc])) {
                        int newKey = (now.key) | (1 << (map[nr][nc] - 'a'));
                        if (!v[newKey][nr][nc]) {
                            v[now.key][nr][nc] = true;
                            v[newKey][nr][nc] = true;
                            queue.add(new Point(nr, nc, newKey, now.cnt + 1));
                        }
                    } else if (Character.isUpperCase(map[nr][nc])) {
                        if ((now.key & (1 << (map[nr][nc] - 'A'))) > 0) {
                            v[now.key][nr][nc] = true;
                            queue.add(new Point(nr, nc, now.key, now.cnt + 1));
                        }
                    } else if (map[nr][nc] == '1') return now.cnt + 1;
                    else {
                        v[now.key][nr][nc] = true;
                        queue.add(new Point(nr, nc, now.key, now.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C && map[r][c] != '#';
    }

    public static class Point {
        int r;
        int c;
        int key;
        int cnt;

        public Point(int r, int c, int key, int cnt) {
            this.r = r;
            this.c = c;
            this.key = key;
            this.cnt = cnt;
        }
    }
}