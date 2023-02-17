import java.io.*;
import java.util.*;

public class Main {

  static int n, h;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    map = new int[h][n];
    for (int i = 0; i < n; i+=2) {
      first(i, Integer.parseInt(br.readLine()));
      second(i + 1, Integer.parseInt(br.readLine()));
    }

    int[] cnt = new int[h];
    for (int i = 0; i < h; i++) {
      int sum = 0;
      for (int j = 0; j < n; j++)
        sum += map[i][j];
      cnt[i] = sum;
    }

    Arrays.sort(cnt);

    int min = cnt[0], ans = 1;
    for (int i = 1; i < n; i++)
      if (cnt[i] != min)
        break;
      else
        ans++;

    System.out.print(min + " " + ans);
  }

  public static void first(int x, int num) { // 몇 번재 칸인지, 몇 개가 들어가야 하는지
    for (int i = h - 1; i >= h - num; i--)
      map[i][x] = 1;
  }

  public static void second(int x, int num) {// 몇 번재 칸인지, 몇 개가 들어가야 하는지
    for (int i = 0; i < num; i++)
      map[i][x] = 1;
  }
}
