import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, sx, sy, ans;
    static char[][] A;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j]= s.charAt(j);
            }
        }
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
        Queue<Dot> Q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][1 << 6];
        Q.add(new Dot(sx, sy, 0)); // 시작점을 큐에 넣어준다
        visited[sx][sy][0] = true; // 시작점 방문 확인
        int move = 0; // 이동 횟수
        while (!Q.isEmpty()) {
           int size = Q.size();
           for (int s = 0; s < size; s++) {
               Dot dot = Q.poll();
               int x = dot.x, y = dot.y, key = dot.key;
               if (A[x][y] == '1') { // 탈출구를 만났을 때
                   ans = move; // 도착점 이동횟수 갱신
                   return; // bfs 종료
               }
               for (int k = 0; k < 4; k++) {
                   int nx = x + dir[k][0], ny = y + dir[k][1];
                   if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                   if (A[nx][ny] == '#') continue;
                   if (A[nx][ny] >= 'a' && A[nx][ny] <= 'f') { // 열쇠를 만났을 때
                       int newKey = key | (1 << (A[nx][ny] - 'a')); // 새로운 열쇠 계산
                       if (visited[nx][ny][newKey]) continue; // 다음칸을 방문 했으면
                       visited[nx][ny][newKey] = true; // 다음칸 방문 확인
                       Q.add(new Dot(nx, ny, newKey)); // 다음칸을 큐에 넣어준다
                   } else if (A[nx][ny] >= 'A' && A[nx][ny] <= 'F') { // 문을 만났을 때
                       int door = 1 << (A[nx][ny] - 'A'); // 문값 계산
                       if ((key & door) > 0) { // 문을 열수 있으면
                           if (visited[nx][ny][key]) continue; // 다음칸을 방문 했으면
                           visited[nx][ny][key] = true; // 다음칸 방문 확인
                           Q.add(new Dot(nx, ny, key)); // 다음칸을 큐에 넣어준다
                       }
                   } else { // A[nx][ny] == '.', 빈칸을 만났을 때
                        if (visited[nx][ny][key]) continue; // 다음칸을 방문 했으면
                       visited[nx][ny][key] = true;  // 다음칸 방문 확인
                        Q.add(new Dot(nx, ny, key)); // 다음칸을 큐에 넣어준다
                   }
               }
           }
           move++; // 이동 횟수 증가
       }
   }

    static void pro() {
        // 민식이를 찾는다
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == '0') {
                    sx = i;
                    sy = j;
                    A[i][j] = '.'; // 민식이의 위치를 빈칸으로 바꿔준다
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
