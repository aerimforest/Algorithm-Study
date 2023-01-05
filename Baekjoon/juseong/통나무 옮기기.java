import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, ans;
    static char[][] A;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 상하좌우
    static Log start;
    static Log end;
    static boolean[][][] visited;
    static class Log{
        int x, y, d;

        public Log(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 한번의 길이 (4 ≤ N ≤ 50)
        A = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = s.charAt(j);
            }
        }
        visited = new boolean[N][N][2];
        // 시작위치, 도착위치를 찾는다
        find_start_end();
        // 통나무를 위, 아래, 왼쪽, 오른쪽, 회전(90) 으로 이동한다
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Log> Q = new LinkedList<>();
        Q.add(new Log(start.x, start.y, start.d));
        visited[start.x][start.y][start.d] = true;
        int move = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int s = 0; s < size; s++) {
                Log log = Q.poll();
                int x = log.x, y = log.y, d = log.d;
                if (x == end.x && y == end.y && d == end.d) {
                    ans = move;
                    return;
                }
                boolean[] ad = new boolean[8]; // 상하좌우대각선에 이동하지 못하는 칸
                for (int k = 0; k < 8; k++) {  // 상하좌우대각선 가능 여부
                    int nx = x + dir[k][0], ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N){
                        ad[k] = true; // 범위에 벗어나면
                    } else if (A[nx][ny] == '1') ad[k] = true; // 1이 있으면
                }
                if (log.d == 0) { // 통나무가 가로 일때
                    int nd = 1;
                    for (int k = 0; k < 4; k++) { // 상하좌우
                        int nx = x + dir[k][0], ny = y + dir[k][1];
                        if (k == 0 && !ad[4] && !ad[0] && !ad[5]){ // 위로 이동 가능
                            if (visited[nx][ny][d]) continue;
                            visited[nx][ny][d] = true;
                            Q.add(new Log(nx, ny, d));
                        } else if (k == 1 && !ad[6] && !ad[1] && !ad[7]) { // 아래로 이동 가능
                            if (visited[nx][ny][d]) continue;
                            visited[nx][ny][d] = true;
                            Q.add(new Log(nx, ny, d));
                        } else if (k == 2 || k == 3) { // 왼쪽 또는 오른쪽 일때
                            int fx = nx + dir[k][0], fy = ny + dir[k][1]; // 이동할 칸
                            if (fx < 0 || fy < 0 || fx >= N || fy >= N) continue;
                            if (visited[nx][ny][d]) continue;
                            visited[nx][ny][d] = true;
                            Q.add(new Log(nx, ny, d));
                        }
                    }
                    if (!ad[0] && !ad[1] && !ad[2]&& !ad[3]&& !ad[4]&& !ad[5]&& !ad[6]&& !ad[7]) { // 회전 가능
                        if (!visited[x][y][nd]) { // 방문 확인
                            visited[x][y][nd] = true;
                            Q.add(new Log(x, y, nd));
                        }
                    }
                } else { // 통나무가 세로 일때
                    int nd = 0;
                    for (int k = 0; k < 4; k++) { // 상하좌우
                        int nx = x + dir[k][0], ny = y + dir[k][1];
                        if (k == 0 || k == 1){ // 위 또는 아래로 이동 할때
                            int fx = nx + dir[k][0], fy = ny + dir[k][1]; // 이동할 칸
                            if (fx < 0 || fy < 0 || fx >= N || fy >= N) continue;
                            if (visited[nx][ny][d]) continue;
                            visited[nx][ny][d] = true;
                            Q.add(new Log(nx, ny, d));
                        } else if (k == 2 && !ad[4] && !ad[2] && !ad[6]) { // 왼쪽으로 이동 가능
                            if (visited[nx][ny][d]) continue;
                            visited[nx][ny][d] = true;
                            Q.add(new Log(nx, ny, d));
                        } else if(k == 3 && !ad[5] && !ad[3] && !ad[7]) { // 오른쪽으로 이동 가능
                            if (visited[nx][ny][d]) continue;
                            visited[nx][ny][d] = true;
                            Q.add(new Log(nx, ny, d));
                        }
                    }
                    if (!ad[0] && !ad[1] && !ad[2]&& !ad[3]&& !ad[4]&& !ad[5]&& !ad[6]&& !ad[7]) { // 회전 가능
                        if (visited[x][y][nd]) continue;
                        visited[x][y][nd] = true;
                        Q.add(new Log(x, y, nd));
                    }
                }
            }
            move++;
        }
    }

    static void find_start_end() {
        int sx, sy, sd, ex, ey, ed;
        int S = 0, E = 0;
        int[][] s = new int[3][2];
        int[][] e = new int[3][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 'B') {
                    s[S][0] = i;
                    s[S][1] = j;
                    S++;
                    A[i][j] = '0';
                } else if (A[i][j] == 'E') {
                    e[E][0] = i;
                    e[E][1] = j;
                    E++;
                    A[i][j] = '0';
                }
            }
        }
        // 시작점과 도착점의 중심점
        sx = s[1][0];
        sy = s[1][1];
        ex = e[1][0];
        ey = e[1][1];
        if (s[0][0] == s[1][0]) { // 줄이 같으면
            sd = 0; // 가로 방향
        } else {
            sd = 1; // 세로 방향
        }
        if (e[0][0] == e[1][0]) { // 줄이 같으면
            ed = 0; // 가로 방향
        } else {
            ed = 1; // 세로 방향
        }
        start = new Log(sx, sy, sd);
        end = new Log(ex, ey, ed);
    }
}
