import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, ans;
    static char[][] A;
    static boolean[] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        A = new char[r][c];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                A[i][j] = s.charAt(j);
            }
        }
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int x, int y, int depth) {
        visited[A[x][y] - 'A'] = true;
        ans = Math.max(ans, depth);
        for (int k = 0; k < 4; k++) { // 상하좌우
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if (visited[A[nx][ny] - 'A']) continue;
            visited[A[nx][ny] - 'A'] = true;
            dfs(nx, ny, depth + 1);
            visited[A[nx][ny] - 'A'] = false;
        }
    }
}
