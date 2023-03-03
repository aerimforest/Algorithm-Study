import java.util.*;
import java.io.*;

/*
 */
public class Main {
    static int N, M,max=0;
    static int[][] map;
    static int[][] arr;
    static int[] dr = {0, -1, 0, 1, 1, 1, -1, -1};
    static int[] dc = {1, 0, -1, 0, -1, 1, 1, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Point(i, j, 0));
                    arr[i][j] = 0;
                }
            }
        }
        bfs();
        System.out.print(max);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            max = Math.max(max, now.cnt);

            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&arr[nr][nc]==Integer.MAX_VALUE) {
                    arr[nr][nc] = now.cnt+1;
                    queue.add(new Point(nr,nc,now.cnt+1));
                }
            }
        }
    }

    public static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
