import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = s.charAt(j) - '0';
        }

        bfs();
    }

    public static void bfs() {
        int[][] check = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k], ny = p.y + dy[k];
                if (range(nx, ny) && board[nx][ny] == 1 && !visit[nx][ny]) {
                    check[nx][ny] = check[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
        System.out.print(check[n - 1][m - 1] + 1);
    }
    public static boolean range(int nx, int ny) {
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
        return false;
    }
}
