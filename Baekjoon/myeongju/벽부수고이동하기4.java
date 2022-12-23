import java.util.*;
import java.io.*;

/*
896ms
그 벽을 뚫었을 경우에 갈 수 있는 칸의 갯수를 구하는건가?
 */
public class Main {

    static int N, M;
    static int[][] map;
    static int[][] answer;
    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0, 0, -1};
    static HashMap<Integer, Integer> hMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        map = new int[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) bfs(i, j, idx++);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    HashSet<Integer> set = new HashSet<>();
                    answer[i][j] = 1;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1)
                            set.add(map[nr][nc]);
                    }
                    for (int n : set) answer[i][j] += hMap.get(n);
                    answer[i][j] %= 10;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void bfs(int r, int c, int idx) {

        int cnt = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        map[r][c] = idx;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    map[nr][nc] = idx;
                    queue.add(new Point(nr, nc));
                }
            }
        }
        hMap.put(idx, cnt);
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