import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int r1, c1, r2, c2, num, l;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) + 5000;
        c1 = Integer.parseInt(st.nextToken()) + 5000;
        r2 = Integer.parseInt(st.nextToken()) + 5000;
        c2 = Integer.parseInt(st.nextToken()) + 5000;
        int mm = 10000;
        arr = new int[mm+1][mm+1];
        visited = new boolean[mm+1][mm+1];
//        num = r2 - r1 + c2 - c1 + 1;
        num = mm;
        int x = mm, y = mm, d = 0;
        arr[x][y] = num;
        num--;
        while (true) {
            if (num == 0) break;
            int nx  = x + dir[d%4][0], ny = y + dir[d%4][1];
            if (nx < 0 || ny < 0 || nx > mm || ny > mm || visited[nx][ny]) {
                d++;
                continue;
            }
            visited[nx][ny] = true;
            arr[ny][ny] = num;
            num--;
            x = nx;
            y = ny;
        }
        int max = Math.max(Math.max(arr[r1][c1], arr[r1][c2]), Math.max(arr[r2][c1], arr[r2][c2]));
        l = max / 10;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                for (int k = 0; k < l - arr[i][j] / 10; k++) sb.append(' ');
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
