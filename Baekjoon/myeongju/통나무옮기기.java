import java.util.*;
import java.io.*;

/*
12116kb
92ms
 */
class Main {

    static int N;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][][] v;
    static int[][] map;
    static Node dest = new Node();
    static Node start = new Node();

    public static class Node {
        int d; // 가로 0 세로 1
        int r;
        int c;

        public Node(int d, int r, int c) {
            this.d = d;
            this.r = r;
            this.c = c;
        }

        public Node() {
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        v = new boolean[2][N][N];
        map = new int[N][N];

        int b = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                if (Character.isDigit(s.charAt(j)))
                    map[i][j] = s.charAt(j) - '0';
                else {
                    if (s.charAt(j) == 'B') {
                        b++;
                        if (b == 2) {
                            start.r = i;
                            start.c = j;
                            if (s.indexOf('B') == j)
                                start.d = 1;
                            else start.d = 0;
                            v[start.d][start.r][start.c] = true;
                        }
                    } else {
                        e++;
                        if (e == 2) {
                            dest.r = i;
                            dest.c = j;
                            if (s.indexOf('E') == j)
                                dest.d = 1;
                            else dest.d = 0;
                        }
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            int cnt = queue.size();

            for (int i = 0; i < cnt; i++) {
                Node now = queue.poll();

                if (now.d == dest.d && now.r == dest.r && now.c == dest.c)
                    return answer;

                // 상하좌우
                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (check(nr, nc, now.d)) {
                        if (v[now.d][nr][nc]) continue;
                        v[now.d][nr][nc] = true;
                        queue.add(new Node(now.d, nr, nc));
                    }
                }

                boolean flag = true;
                outer:
                for (int j = now.r - 1; j <= now.r + 1; j++) {
                    if (j < 0 || j >= N) continue;
                    for (int k = now.c - 1; k <= now.c + 1; k++) {
                        if (k < 0 || k >= N) continue;
                        if (map[j][k] == 1) {
                            flag = false;
                            break outer;
                        }
                    }
                }

                if (flag) {
                    int nd = (now.d == 0 ? 1 : 0);
                    if (check(now.r, now.c, nd)) {
                        if (v[nd][now.r][now.c]) continue;
                        v[nd][now.r][now.c] = true;
                        queue.add(new Node(nd, now.r, now.c));
                    }
                }

            }
            answer++;
        }

        return 0;
    }

    public static boolean check(int r, int c, int d) {
        if (d == 0)
            return r >= 0 && r < N && c > 0 && c < N - 1 && map[r][c] == 0 && map[r][c - 1] == 0 && map[r][c + 1] == 0;
        else
            return r > 0 && r < N - 1 && c >= 0 && c < N && map[r][c] == 0 && map[r + 1][c] == 0 && map[r - 1][c] == 0;
    }
}