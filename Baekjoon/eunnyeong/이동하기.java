import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dx = {1, 0, 1}, dy = {0, 1, 1};
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (range(nx, ny)) {
                        if (dp[nx][ny] == 0)
                            dp[nx][ny] = dp[i][j] + map[nx][ny];
                        else
                            dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j] + map[nx][ny]);
                    }
                }
            }
        }

        System.out.print(dp[n - 1][m - 1]);
        br.close();
    }

    public static boolean range(int nx, int ny) {
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
        return false;
    }
}
