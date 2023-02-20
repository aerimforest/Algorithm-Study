import java.io.*;
import java.util.*;

public class Main {

  static int ans, n;
  static char[][] map;
  static int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    map = new char[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      map[i] = st.nextToken().toCharArray();
    }

    ans = -1;
    check();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k], ny = j + dy[k];
          if(range(nx, ny) && map[i][j] != map[nx][ny]) {
            change(i, j, nx, ny);
            check();
            change(i, j, nx, ny);
          }
        }
      }
    }

    System.out.print(ans);
  }

  public static void change(int i, int j, int nx, int ny) {
    char tmp = map[i][j];
    map[i][j] = map[nx][ny];
    map[nx][ny] = tmp;
  }


  public static void check() {
    for (int i = 0; i < n; i++) {
      int cnt = 1, x = map[i][0];
      for (int j = 1; j < n; j++){
        if (x == map[i][j])
          cnt++;
        else {
          ans = Math.max(ans, cnt);
          cnt = 1; x = map[i][j];
        }
      }
      ans = Math.max(ans, cnt);
    }

    for (int j = 0; j < n; j++) {
      int cnt = 1, x = map[0][j];
      for (int i = 1; i < n; i++){
        if (x == map[i][j])
          cnt++;
        else {
          ans = Math.max(ans, cnt);
          cnt = 1; x = map[i][j];
        }
      }
      ans = Math.max(ans, cnt);
    }
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
