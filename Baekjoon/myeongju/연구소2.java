import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static ArrayList<Point> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int[] dr = {0, -1, 1, 0};
    static int[] dc = {1, 0, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2)
                    list.add(new Point(i, j, 0));

            }
        }

        comb(0, 0, new int[M]);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void comb(int r, int cnt, int[] arr) {
        if (cnt == M) {

            int[][] newMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                newMap[i] = Arrays.copyOfRange(map[i], 0, N);
            }

            bfs(newMap, arr);

            return;
        }

        for (int i = r; i < list.size(); i++) {
            arr[cnt] = i;
            comb(i + 1, cnt + 1, arr);
        }
    }

    public static void bfs(int[][] map, int[] arr) {
        Queue<Point> queue = new LinkedList<>();
        int time = 0;

        for (int i : arr) {
            Point p = list.get(i);

            map[p.r][p.c] = -1;
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            time = now.t;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 0 || map[nr][nc] == 2) {
                        map[nr][nc] = -1;
                        queue.add(new Point(nr, nc, now.t + 1));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || map[i][j] == 2)
                    return;
            }
        }

        answer = Math.min(time, answer);
    }

    public static class Point {
        int r;
        int c;
        int t;

        public Point(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}