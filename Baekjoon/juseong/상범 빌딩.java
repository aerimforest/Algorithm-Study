import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Dot {
    int z;
    int x;
    int y;
    int move;

    public Dot (int z, int x, int y, int move) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.move = move;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        if(L == 0 && R == 0 && C == 0) return false;
        building = new char[L][R][];
        visit = new boolean[L][R][C];
        for(int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                building[i][j] = br.readLine().toCharArray();
            }
            br.readLine();
        }
        ans = "Trapped!";
        return true;
    }

    static int L, R, C;
    static String ans;
    static char[][][] building;
    static boolean[][][] visit;
    static int[][] dir = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

    static void bfs() {
        Queue<Dot> Q = new LinkedList<>();
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(building[h][i][j] == 'S') {
                        Q.add(new Dot(h, i, j, 0));
                    }
                }
            }
        }

        if(!Q.isEmpty()){
            visit[Q.peek().z][Q.peek().x][Q.peek().y] = true;
        }
        while (!Q.isEmpty()) {
            Dot dot = Q.poll();
            if (building[dot.z][dot.x][dot.y] == 'E') {
                ans = "Escaped in " + dot.move + " minute(s).";
                Q.clear();
                continue;
            }
            for (int k=0;k<6;k++) {
                int nz = dot.z + dir[k][0], nx = dot.x + dir[k][1], ny = dot.y + dir[k][2];
                if (nz < 0 || nx < 0 || ny < 0 || nx >= R || ny >= C || nz >= L) continue;
                if (building[nz][nx][ny] == '#') continue;
                if (visit[nz][nx][ny]) continue;
                visit[nz][nx][ny] = true;
                Q.add(new Dot(nz, nx, ny, dot.move + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        boolean hasNext = input();
        while(hasNext) {
            bfs();
            System.out.println(ans);
            hasNext = input();
        }
    }
}
