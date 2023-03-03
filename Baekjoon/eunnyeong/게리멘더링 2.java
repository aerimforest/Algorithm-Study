import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int n, total, ans;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    total = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        total += map[i][j];
      }

    }

    ans = Integer.MAX_VALUE;
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        for (int d1 = 1; d1 < n; d1++) {
          for (int d2 = 1; d2 < n; d2++) {
            if (x + d1 + d2 < n && (y - d1 >= 0 || y + d2 < n))
              calc(x, y, d1, d2);
          }
        }
      }
    }

    System.out.print(ans);
  }
  public static void calc(int x, int y, int d1, int d2) {
    boolean[][] border = new boolean[n][n];

    for (int i = 0; i <= d1; i++) {
      border[x + i][y - i] = true;
      border[x + d2 + i][y + d2 - i] = true;
    }

    for (int i = 0; i <= d2; i++) {
      border[x + i][y + i] = true;
      border[x + d1 + i][y - d1 + i] = true;
    }

    int[] pop = new int[5];

    for (int i = 0; i < x + d1; i++) {
      for (int j = 0; j <= y; j++) {
        if (border[i][j]) break;
        pop[0] += map[i][j];
      }
    }

    for (int i = 0; i < x + d2; i++) {
      for (int j = n - 1; j > y; j--) {
        if (border[i][j]) break;
        pop[1] += map[i][j];
      }
    }

    for (int i = x + d1; i < n; i++) {
      for (int j = 0; j < y - d1 + d2; j++) {
        if (border[i][j]) break;
        pop[2] += map[i][j];
      }
    }

    for (int i = x + d2 + 1; i < n; i++) {
      for (int j = n - 1; j >= y - d1 + d2; j--) {
        if (border[i][j]) break;
        pop[3] += map[i][j];
      }
    }

    pop[4] = total;
    for (int i = 0; i < 4; i++)
      pop[4] -= pop[i];

    Arrays.sort(pop);

    ans = Math.min(ans, pop[4] - pop[0]);
  }
}
