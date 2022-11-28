import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] A;
    static boolean[][] blank;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

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

    static boolean findCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) return true;
            }
        }
        return false;
    }

    static void bfs(int sx, int sy) {
        blank = new boolean[N][M];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        blank[sx][sy] = true;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (A[nx][ny] == 1) continue;
                if (blank[nx][ny]) continue;
                blank[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static void meltCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    int face = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dir[k][0], ny = j + dir[k][1];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (blank[nx][ny]) {
                            face++;
                        }
                    }
                    if (face >= 2) A[i][j] = 0;
                }
            }
        }
    }

    static void pro() {
        while(findCheese()) {
            // 공기가 퍼진다.
            bfs(0, 0);
            // 치즈를 녹인다.
            meltCheese();
            ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
