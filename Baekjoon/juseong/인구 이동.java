import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, G, ans;
    static int[][] A;
    static int[][] group_num;
    static int[][] group_people;
    static boolean[][] visited;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs(int sx, int sy, int G) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visited[sx][sy] = true;
        group_num[sx][sy] = G;
        group_people[G][0] += A[sx][sy];
        group_people[G][1]++;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (Math.abs(A[x][y] - A[nx][ny]) < L || Math.abs(A[x][y] - A[nx][ny]) > R) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                group_num[nx][ny] = G;
                group_people[G][0] += A[nx][ny];
                group_people[G][1]++;
            }
        }
    }

    static void open() {
        group_num = new int[N][N];
        group_people = new int[N*N+1][2];
        visited = new boolean[N][N];
        G = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    G++;
                    bfs(i, j, G);
                }
            }
        }
    }

    static void move() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = group_num[i][j];
                A[i][j] = group_people[num][0] / group_people[num][1];
            }
        }
    }

    static boolean equalPopulation() {
        int people = A[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] != people) return false;
            }
        }
        return true;
    }
    static void pro() {
        open(); // 1. 국경선을 연다.
        while(G!=N*N) {
            move(); // 2. 인구가 이동한다.
            ans++;
            open(); // 1. 국경선을 연다.
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
