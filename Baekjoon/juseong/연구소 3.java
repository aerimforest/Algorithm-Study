import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B, count_blank, ans;
    static int[][] A;
    static int[][] virus;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        virus = new int[N * N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs(int count) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 3){
                    Q.add(i);
                    Q.add(j);
                    Q.add(0);
                    visit[i][j] = true;
                }
            }
        }
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll(), move = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;
                if (A[nx][ny] == 1) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                Q.add(move + 1);
                if (A[nx][ny] == 0) count--;
                if (count == 0) {
                    ans = Math.min(ans, move + 1);
                    return;
                }
            }
        }
    }

    static void rec_func(int k, int cnt) {
        if (cnt == M) {
            bfs(count_blank);
            return;
        }
        if (k >= B) return;
        A[virus[k][0]][virus[k][1]] = 3;
        rec_func(k + 1, cnt + 1);
        A[virus[k][0]][virus[k][1]] = 2;
        rec_func(k + 1, cnt);
    }

    static void pro() {
        B = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 2){
                    virus[B][0] = i;
                    virus[B][1] = j;
                    B++;
                }
                if (A[i][j] == 0) count_blank++;
            }
        }
        if (count_blank == 0) {
            System.out.println(0);
            return;
        }
        ans = Integer.MAX_VALUE;
        rec_func(0, 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
