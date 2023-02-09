import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int mx = 987654321;
    int[][] dist = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++)
        if (i != j)
          dist[i][j] = mx;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      dist[a][b] = Math.min(c, dist[a][b]);
    }

    int k = Integer.parseInt(br.readLine());
    int[] a = new int[k];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++)
      a[i] = Integer.parseInt(st.nextToken());

    for (int l = 1; l <= n; l++) {
      for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
          dist[i][j] = Math.min(dist[i][l] + dist[l][j], dist[i][j]);
    }

    int[] tmp = new int[n + 1];
    int x = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      int max = 0;
      for (int j = 1; j <= n; j++) {
        max += dist[i][j];
        max += dist[j][i];
      }
      tmp[i] = max;
      x = Math.min(x, max);
    }

    for (int i = 1; i <= n; i++)
      if (tmp[i] == x)
        System.out.print(i + " ");
  }
}
