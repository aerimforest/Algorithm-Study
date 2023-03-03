import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int mx = 10000001;
    int[][] dist = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j)
          dist[i][j] = 0;
        else
          dist[i][j] = mx;
      }
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      dist[a][b] = Math.min(dist[a][b], c);
    }

    for (int k = 1; k <= n; k++)
      for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (dist[i][j] == mx)
          sb.append(0 + " ");
        else
          sb.append(dist[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}
