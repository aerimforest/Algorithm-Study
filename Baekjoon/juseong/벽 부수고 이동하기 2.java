import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, ans;
    static char[][] A;
    static boolean[][][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new char[N+1][M+1];
        visit = new boolean[N+1][M+1][K+1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1, index = 0; j <= M; j++, index++) {
                A[i][j] = s.charAt(index);
            }
        }
        ans = -1;
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Dot> Q = new LinkedList<>();
        Q.add(new Dot(1, 1, 0));
        visit[1][1][0] = true;
        int move = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int s = 0; s < size; s++) {
                Dot dot = Q.poll();
                int x = dot.x, y = dot.y, k = dot.k;
                if (x == N && y == M) {
                    ans = move+1;
                    return;
                }
                for (int d = 0; d < 4; d++) { // 상하좌우로 이동한다
                    int nx = x + dir[d][0], ny = y + dir[d][1];
                    if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                    if (A[nx][ny] == '1') { // 벽이 있을 때
                       if (k + 1 <= K) { // 촤대 부수는 횟수 이하이면 벽을 부수고 이동한다
                           if (visit[nx][ny][k+1]) continue;
                           visit[nx][ny][k+1] = true;
                           Q.add(new Dot(nx, ny, k+1));
                       }
                    } else {
                        if (visit[nx][ny][k]) continue;
                        visit[nx][ny][k] = true;
                        Q.add(new Dot(nx, ny, k));
                    }
                }
            }
            move++;
        }
    }

    static class Dot {
        int x, y, k;

        public Dot(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}
