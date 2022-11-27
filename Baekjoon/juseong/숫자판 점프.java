import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static boolean[] visited;
    static int ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void dfs(int x, int y, int cnt, int num) {
        if (cnt == 6) {
            if (!visited[num]) ans++;
            visited[num] = true;
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            dfs(nx,ny, cnt + 1, num * 10 + A[nx][ny]);
        }
    }

    static void pro() {
        visited = new boolean[1000000];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, A[i][j]);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
