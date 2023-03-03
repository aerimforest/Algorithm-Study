import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, sx, sy, eat, ans;
    static int[][] A;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int cur_size() {
        int cur_size = 2;
        int food = eat;
        while(food - cur_size >= 0) {
            food -= cur_size;
            cur_size++;
        }
        return cur_size;
    }

    static boolean bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        Q.add(0);
        visit[sx][sy] = true;
        int ex = -1, ey = -1;
        int min_path = Integer.MAX_VALUE;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll(), move = Q.poll();
            if (A[x][y] != 0 && A[x][y] < cur_size()) {
                if (move < min_path) { // 먹을 수 있는 물고기를 처음 만났을 때
                    min_path = move;
                    ex = x;
                    ey = y;
                } else if (min_path == move) {
                    if (x < ex) { // 가장 위에 있다면
                        ex = x;
                        ey = y;
                    } else if (x == ex && y < ey) { // 가장 위에 있고 가장 왼쪽이라면
                        ey = y;
                    }
                }
                continue;
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;
                if (A[nx][ny] > cur_size()) continue;
                if (move + 1 > min_path) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                Q.add(move + 1);
            }
        }
        if (ex == -1) {
            return false;
        } else {
            A[ex][ey] = 0;
            sx = ex;
            sy = ey;
            eat++;
            ans += min_path;
            return true;
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 9) {
                    sx = i;
                    sy = j;
                    A[i][j] = 0;
                }
            }
        }
        boolean canEatFish = bfs();
        while(canEatFish) {
            visit = new boolean[N][N];
            canEatFish = bfs();
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
