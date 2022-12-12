import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, count, max;
    static char[][] A;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0, index = 0; j < m; j++, index += 2) {
                A[i][j] = s.charAt(index);
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == '1' && !visited[i][j]) {
                    count++;
                    int size = bfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    static int bfs(int sx, int sy) {
        int size = 0;
        Queue<Dot> Q = new LinkedList<>();
        visited[sx][sy] = true;
        Q.add(new Dot(sx, sy));
        size++;
        while (!Q.isEmpty()) {
            Dot dot = Q.poll();
            int x = dot.x, y = dot.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (A[nx][ny] == '0') continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                Q.add(new Dot(nx, ny));
                size++;
            }
        }
        return size;
    }

    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
