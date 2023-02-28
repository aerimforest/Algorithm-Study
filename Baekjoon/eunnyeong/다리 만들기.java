import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};
  static int n, ans = Integer.MAX_VALUE;
  static int[][] map, tmp;
  static boolean[][] visit;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visit = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1)
          visit[i][j] = true;
      }
    }

    tmp = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 0) {
          copy(tmp, map);
          dfs(i, j, 1);
          System.out.println(i + " " + j);
        }
      }
    }
    System.out.println(ans);
  }

  public static void copy(int[][] a, int[][] b) {
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        a[i][j] = b[i][j];
  }

  public static void dfs(int x, int y, int cnt) {
    System.out.println(x + " " + y + " " + cnt);
    if (tmp[x][y] == 1) {
      ans = Math.min(ans, cnt);
      return;
    }
    tmp[x][y] = 2;
    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      if (range(nx, ny) && tmp[nx][ny] != 2)
        dfs(nx, ny, cnt + 1);
    }
  }


  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
