import java.util.*;
import java.io.*;

/*
B -> E
 */
public class Main {
    static int N;
    static Tree start;
    static Tree end;
    static int[][] map;
    static boolean[][][] v;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[2][N][N]; // 방향 좌표 visited

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (c == 'B') { //시작지점
                    if (start == null) {
                        if (s.contains("BBB"))
                            start = new Tree(i, j + 1, 0);
                        else start = new Tree(i + 1, j, 1);
                    }
                    map[i][j] = 0;
                } else if (c == 'E') { //도착지점
                    if (end == null) {
                        if (s.contains("EEE"))
                            end = new Tree(i, j + 1, 0);
                        else end = new Tree(i + 1, j, 1);
                    }
                    map[i][j] = 0;
                } else {
                    map[i][j] = c - '0';
                }
            }
        }
        System.out.print(bfs());
    }

    public static int bfs() {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(start);
        v[start.d][start.r][start.c] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int t = 0; t < size; t++) {
                Tree now = queue.poll();

                if (now.r == end.r && now.c == end.c && now.d == end.d) return cnt;

                // 상하좌우
                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];
                    if (check(nr, nc, now.d)) {
                        v[now.d][nr][nc] = true;
                        queue.add(new Tree(nr, nc, now.d));
                    }
                }
                // 방향 돌리기
                int nd = (now.d == 0) ? 1 : 0;
                if (v[nd][now.r][now.c]) continue;
                if (checkTurn(now.r, now.c)) {
                    v[nd][now.r][now.c] = true;
                    queue.add(new Tree(now.r, now.c, nd));
                }
            }
            cnt++;
        }
        return 0;
    }

    public static class Tree {
        int r;
        int c;
        int d; // 0 : 가로 1 : 세로

        public Tree(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static boolean check(int r, int c, int d) {
        if (d == 0) return r >= 0 && r < N && c > 0 && c < N - 1
                && map[r][c - 1] == 0 && map[r][c] == 0 && map[r][c + 1] == 0
                && !v[d][r][c];
        else return r > 0 && r < N - 1 && c >= 0 && c < N
                && map[r - 1][c] == 0 && map[r][c] == 0 && map[r + 1][c] == 0
                && !v[d][r][c];
    }

    public static boolean checkTurn(int r, int c) {
        for (int i = r - 1; i <= r + 1; i++) {
            if (i < 0 || i >= N) return false;
            for (int j = c - 1; j <= c + 1; j++) {
                if (j < 0 || j >= N) return false;
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }
}