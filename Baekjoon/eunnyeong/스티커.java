import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());
      int[][] a = new int[2][n + 1];

      for (int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= n; j++)
          a[i][j] = Integer.parseInt(st.nextToken());
      }

      int[][] memo = new int[2][n + 1];
      memo[0][1] = a[0][1];
      memo[1][1] = a[1][1];

      for (int j = 2; j <= n; j++) {
        memo[0][j] = Math.max(memo[1][j - 1], memo[1][j - 2]) + a[0][j];
        memo[1][j] = Math.max(memo[0][j - 1], memo[0][j - 2]) + a[1][j];
      }

      System.out.println(Math.max(memo[0][n], memo[1][n]));
    }
  }
}
