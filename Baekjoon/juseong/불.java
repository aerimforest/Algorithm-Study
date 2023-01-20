import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, ans;
    static char[][] A;
    static Queue<Dot> J = new LinkedList<>();
    static Queue<Dot> F = new LinkedList<>();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        A = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                A[i][j] = s.charAt(j);
                if (A[i][j] == 'J') { // 지훈이 이면
                    J.add(new Dot(i, j));
                } else if (A[i][j] == 'F') { // 불이면
                    F.add(new Dot(i, j));
                }
            }
            // end of input
        }
        ans = Integer.MAX_VALUE;
        bfs();
        System.out.println(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
    }

    static void bfs() {
        int time = 0; // 시간
        while (!J.isEmpty()) {
            // 불 이동
            int size = F.size();
            for (int s = 0; s < size; s++) {
                Dot fire = F.poll();
                int x = fire.x, y = fire.y;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0], ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue; // 범위를 벗어났으면
                    if (A[nx][ny] == 'F' || A[nx][ny] == '#') continue; // 다음 지점이 불이거나 벽이면
                    A[nx][ny] = 'F';
                    F.add(new Dot(nx, ny));
                }
            }
            // 지훈 이동
            size = J.size();
            for (int s = 0; s < size; s++) {
                Dot jihun = J.poll();
                int x = jihun.x, y = jihun.y;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0], ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) { // 범위를 벗어났으면
                        ans = time + 1; // 정답 갱신
                        return; // bfs 종료
                    }
                    if (A[nx][ny] == 'F' || A[nx][ny] == '#' || A[nx][ny] == 'J') continue; // 다음 지점이 불,벽, 이미 방문 이면
                    A[nx][ny] = 'J';
                    J.add(new Dot(nx, ny));
                }
            }
            time++;
        }
    }

    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
