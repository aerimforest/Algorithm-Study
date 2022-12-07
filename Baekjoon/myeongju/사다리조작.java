import java.util.*;
import java.io.*;

public class Main {

    static int N, M, H;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[x][y + 1] = -1;
        }

        for (int i = 0; i <= 3; i++) {
            if (dfs(1, 0, i)) {
                return;
            }
        }

        System.out.println(-1);
    }

    public static boolean dfs(int h, int depth, int level) {
        if (depth == level) {
            if (check()) {
                System.out.println(level);
                return true;
            }

            return false;
        }

        for (int i = h; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = -1;

                    if (dfs(i, depth + 1, level)) {
                        return true;
                    }

                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }

        return false;
    }

    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int y = i;

            for (int x = 1; x <= H; x++) {
                if (map[x][y] == 1) {
                    y++;
                } else if (map[x][y] == -1) {
                    y--;
                }
            }

            if (y != i) {
                return false;
            }
        }

        return true;
    }
}