import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    max = Math.max(bfs(i, j), max);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    public static int bfs(int r, int c) {
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        map[r][c] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            area++;

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (check(nr, nc) && map[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc});
                    map[nr][nc] = 0;
                }
            }
        }
        return area;
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}