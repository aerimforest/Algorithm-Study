import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int m, n, k;
    static int[][] A;
    static ArrayList<Integer> ans;
    static boolean[][] visited;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    A[x][y] = 1;
                }
            }
        }
    }

    static int bfs(int sx, int sy) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visited[sx][sy] = true;
        int size = 1;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (A[nx][ny] == 1) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                size++;
            }
        }
        return size;
    }

    static void pro() {
        ans = new ArrayList<>();
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) continue;
                if (visited[i][j]) continue;
                int size = bfs(i, j);
                ans.add(size);
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for (int s: ans) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
       input();
       pro();
    }
}
