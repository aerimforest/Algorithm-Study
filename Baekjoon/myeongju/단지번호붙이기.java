import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    bfs(i, j);
                    v[i][j]=true;
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()+"\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)+"\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int r, int c) throws Exception {

        int cnt = 1;
        Queue<point> q = new LinkedList<>();
        q.add(new point(r, c));

        while (!q.isEmpty()) {
            point p = q.poll();

            map[p.r][p.c] = 0;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (!check(nr, nc)) continue;

                if (!v[nr][nc] && map[nr][nc] == 1) {
                    cnt++;
                    v[nr][nc] = true;
                    q.add(new point(nr, nc));
                }
            }

        }
        list.add(cnt);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static class point {
        int r;
        int c;

        public point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
