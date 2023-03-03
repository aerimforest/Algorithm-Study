import java.util.*;
import java.io.*;

public class Main {
    static int R, C, max = 0;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;
    static boolean[] v = new boolean[26];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();

        v[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.print(max);
    }

    public static void dfs(int r,int c,int cnt) {

        max = Math.max(cnt,max);

        for (int d = 0; d < 4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(nr>=0 && nr<R && nc>=0 && nc<C && !v[map[nr][nc]-'A']) {
                v[map[nr][nc]-'A'] = true;
                dfs(nr,nc,cnt+1);
                v[map[nr][nc]-'A'] = false;
            }
        }
    }
}