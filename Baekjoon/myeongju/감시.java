import java.util.*;
import java.io.*;

/*
6 벽
방향을 정해서 사각 지대의 최소 크기 구하기
cctv <= 8
4^8 = 2^16
 */
public class Main {
    static int N, M;
    static ArrayList<CCTV> cctv;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int sum = 0;
    static int max = 0;
    static int[][][] dir = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{1, 2}, {2, 3}, {3, 0}, {0, 1}},
            {{3, 2, 0}, {1, 2, 3}, {1, 3, 0}, {1, 0, 2}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5)
                    cctv.add(new CCTV(i, j, map[i][j]));
                else if (map[i][j] == 0) sum++;
            }
        }

        dfs(0, 0, map);
        System.out.print(sum - max);
    }

    public static void dfs(int r, int cnt, int[][] map) {
        if (r == cctv.size()) {
            max = Math.max(cnt, max);
            return;
        }
        int[][] newMap = new int[N][M];
        copy(newMap, map);

        CCTV now = cctv.get(r);

        for (int i = 0; i < dir[now.type].length; i++) {
            int sum = 0;
            for (int d : dir[now.type][i]) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                while (check(nr, nc) && newMap[nr][nc] != 6) {
                    if (newMap[nr][nc] == 0) {
                        newMap[nr][nc] = -1;
                        sum++;
                    }
                    nr += dr[d];
                    nc += dc[d];
                }
            }

            dfs(r + 1, cnt + sum, newMap);
            copy(newMap, map);
        }
    }

    public static void copy(int[][] m1, int[][] m2) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                m1[i][j] = m2[i][j];
            }
        }
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static class CCTV {
        int r;
        int c;
        int type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
}