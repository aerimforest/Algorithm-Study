import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k, w, h, ans;
    static char[][] A;
    static boolean[][][] visited;
    static int[][] dir1 = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
    static int[][] dir2 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        A = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0, index = 0; j < w; j++, index += 2) {
                A[i][j] = s.charAt(index);
            }
        }
        visited = new boolean[h][w][k+1];
        ans = -1;
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Dot> Q = new LinkedList<>();
        Q.add(new Dot(0, 0, k));
        visited[0][0][k] = true;
        int move = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int s = 0; s < size; s++) {
                Dot cur = Q.poll();
                int x = cur.x, y = cur.y, skill = cur.skill;
                if (x == h - 1 && y == w - 1) {
                    ans = move;
                    return;
                }
                if (skill > 0) { // 점프 사용 가능한 횟수가 1 이상이면 점프로 이동
                    for (int k = 0; k < 8; k++) {
                        int nx = x + dir1[k][0], ny = y + dir1[k][1];
                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                        if (A[nx][ny] == '1') continue;
                        if (visited[nx][ny][skill-1]) continue;
                        visited[nx][ny][skill-1] = true;
                        Q.add(new Dot(nx, ny, skill - 1));
                    }
                }
                // 주변으로 이동
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir2[k][0], ny = y + dir2[k][1];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (A[nx][ny] == '1') continue;
                    if (visited[nx][ny][skill]) continue;
                    visited[nx][ny][skill] = true;
                    Q.add(new Dot(nx, ny, skill));
                }
            }
            move++;
        }
    }

    static class Dot{
        int x, y, skill;

        public Dot(int x, int y, int skill) {
            this.x = x;
            this.y = y;
            this.skill = skill;
        }
    }
}
