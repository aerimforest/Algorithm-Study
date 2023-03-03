import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static int ans1, ans2;
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};
    static boolean[][] v;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    dfs(i, j);
                    ans1++;
                }
                if(map[i][j]=='G')
                    map[i][j] = 'R';
            }
        }

        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    dfs(i, j);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);

    }

    private static void dfs(int r, int c) {

        v[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r +dr[d];
            int nc = c +dc[d];

            if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
                if(map[nr][nc]==map[r][c])
                    dfs(nr,nc);
            }
        }
    }
}
