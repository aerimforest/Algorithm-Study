import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static boolean[][][] visited;
    static char[][] A;
    static Queue<Dot> Q;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][];
        visited = new boolean[N][M][1<<6];
        for (int i = 0; i < N; i++) A[i] = br.readLine().toCharArray();
    }

    static class Dot {
        int x, y, key;

        public Dot(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }

    static void bfs() {
        int dist = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            dist++;
            for (int s = 0; s < size; s++) {
                Dot dot = Q.poll();
                int x = dot.x, y = dot.y, nowKey = dot.key;
                if (A[x][y] == '1') {
                    ans = dist - 1;
                    return;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0], ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (A[nx][ny] == '#') continue;
                    if (visited[nx][ny][nowKey]) continue;
                    if (A[nx][ny] >= 'a' && A[nx][ny] <= 'f') { // 열쇠를 만났을 때
                        int newKey = 1<<(A[nx][ny] - 'a');
                        int addedKey = nowKey | newKey;
                        visited[nx][ny][addedKey] = true;
                        Q.add(new Dot(nx, ny, addedKey));
                    } else if (A[nx][ny] >= 'A' && A[nx][ny] <= 'F') { // 문을 만났을 때
                        int door = 1 << (A[nx][ny] - 'A');
                        if ((door & nowKey) > 0) { // 열쇠가 있으면
                            visited[nx][ny][nowKey] = true;
                            Q.add(new Dot(nx, ny, nowKey));
                        }
                    } else {
                        visited[nx][ny][nowKey] = true;
                        Q.add(new Dot(nx, ny, nowKey));
                    }
                }
            }
        }
    }

    static void pro() {
        Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == '0') {
                    Q.add(new Dot(i, j, 0));
                    visited[i][j][0] = true;
                }
            }
        }
        ans = -1;
        bfs();
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
