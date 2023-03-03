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

    int[][] a = new int[m][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int k = 0; k < n; k++) { 
      Point[] t = new Point[n];
      t[0] = new Point(a[k][0], k);
      Point mx = new Point(0, 0);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
         if ((mx.y != j && mx.x < a[j][i]) || (mx.y == j && mx.x < a[j][i] / 2))
           mx = new Point(a[j][i], j);
         }
        t[i + 1] = mx;
        }
      int sum = 0;
      for (int i = 0; i < n; i++)
        sum += t[i].x;
      ans = Math.max(ans, sum);
      }
    
    System.out.println(ans);
    }
  }
}
