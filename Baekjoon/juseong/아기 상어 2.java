import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] A;
    static boolean[][] visit;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int bfs(int sx, int sy) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        Q.add(0);
        visit[sx][sy] = true;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll(), move = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (A[nx][ny] == 1) return move + 1;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                Q.add(move + 1);
            }
        }
        return -1;
    }

    static void pro() {
        ans = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    visit = new boolean[N][M];
                    int result = bfs(i, j);
                    ans = Math.max(ans, result);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
