import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = 0, f = 0;
        for (int i = 0; i < m; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if (tmp == 0)
                tmp = check[i];
            if (tmp != 0 && check[i] != tmp)
                f = 1;
        }

        if (f == 0) { //여행가야하는 곳이 전부 같은 경우 (이동 안해도 되는 경우)
            System.out.print("YES");
            return;
        }

        Point s = null;
        for (int i = 1; i <= n; i++) {
            if (map[check[0]][i] != 0) {
                s = new Point(check[0], i);
                break;
            }
        }

        if (s == null) { //처음부터 방문할 수 없는 경우
            System.out.print("NO");
            return;
        }

        visit = new boolean[n + 1][n + 1];

        dfs(s.x, s.y);

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (visit[check[i]][j]) { //계획 세운 곳을 전부 방문했는지 체크
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == m) //전부 방문한 경우
            System.out.print("YES");
        else //전부 방문 못한 경우
            System.out.print("NO");
    }

    public static void dfs(int x, int y) {
        if (visit[x][y]) return;
        visit[x][y] = true;

        for (int i = 1; i <= n; i++) {
            if (map[y][i] == 1)
                dfs(y, i);
        }
    }
}
