import java.util.*;
import java.io.*;

/*
스도쿠 완성하기
백트래킹

 */
public class Main {
    static int[][] map = new int[9][9];
    static int[][] v = new int[3][9]; //가로 세로 사각형
    static ArrayList<Point> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
                int n = i / 3 * 3 + j / 3;
                if (map[i][j] == 0) {
                    list.add(new Point(i, j, n));
                    continue;
                }
                v[0][i] |= 1 << map[i][j];
                v[1][j] |= 1 << map[i][j];
                v[2][n] |= 1 << map[i][j];
            }
        }
        dfs(0);
    }

    public static void dfs(int n) {
        if (n == list.size()) {
            print();
            System.exit(0);
        }

        Point now = list.get(n);
        for (int i = 1; i <= 9; i++) {

            if ((v[0][now.r] & 1 << i) != 0 || (v[1][now.c] & 1 << i) != 0 || (v[2][now.n] & 1 << i) != 0)
                continue;

            v[0][now.r] |= 1 << i;
            v[1][now.c] |= 1 << i;
            v[2][now.n] |= 1 << i;
            map[now.r][now.c] = i;
            dfs(n+1);
            v[0][now.r] &= ~(1 << i);
            v[1][now.c] &= ~(1 << i);
            v[2][now.n] &= ~(1 << i);
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static class Point {
        int r;
        int c;
        int n;

        public Point(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }
}