import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Tomato> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 익은 토마토인 경우
                    q.add(new Tomato(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }

        if (q.isEmpty()) { 
            if (check() > 0) //익힐 토마토는 있는데 익힐 수 없는 경우(0은 있는데 1이 없는 경우)
                System.out.print(-1);
            else //이미 모두 익어있는 경우
                System.out.print(0);
            return;
        }
        
        int ans = 0;
        while (!q.isEmpty()) {
            Tomato p = q.poll();
            visit[p.x][p.y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k], ny = p.y + dy[k];
                if (range(nx,ny) && map[nx][ny] == 0 && !visit[nx][ny]) {
                    map[nx][ny] = 1;
                    q.add(new Tomato(nx, ny, p.day + 1));
                }
            }
            if (q.isEmpty()) ans = p.day; // 더 이상 익힐 토마토가 없을 때 날짜
        }

        if (check() > 0) ans = -1; //안 익은 토마토가 있을 때

        System.out.print(ans);
    }

    public static int check() { //안 익은 토마토 몇 개인지 체크
        int cnt = 0;
        for (int i = 0 ; i < n; i++)
            for (int j = 0; j < m; j++)
                if (map[i][j] == 0)
                    cnt++;
        return cnt;
    }

    public static boolean range(int nx, int ny) {
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
        return false;
    }

    static class Tomato {
        int x, y, day; //좌표, 날짜

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
