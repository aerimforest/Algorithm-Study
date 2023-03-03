import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  static int n;
  static int[][] map;
  static int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    map = new int[n][n];
    Point start = null;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 9)
          start = new Point(i, j);
      }
    }

    map[start.x][start.y] = 0;

    bfs(start);
  }

  public static void bfs(Point start) {
    boolean[][] visit = new boolean[n][n];
    PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        if (o1.x == o2.x)
          return o1.y - o2.y;
        return o1.x - o2.x;
      }
    });
    q.add(start);

    int cnt = 0, size = 2, ans = 0, tmp = 0;
    while (!q.isEmpty()) {
      Point p = q.poll();
      if (map[p.x][p.y] != size)
        visit[p.x][p.y] = true;
      else
        q.add(p);
      
      tmp++;
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] <= size) {
          q.add(new Point(nx, ny));
          if (map[nx][ny] > 0 && map[nx][ny] < size) {
            cnt++;
            map[nx][ny] = 0;
            ans += tmp;
            tmp = 0;
          }

          if (cnt == size) {
            cnt = 0;
            size++;
          }
        }
      }
    }
    System.out.print(ans);
  }

  public static boolean check(boolean[][] visit) {
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (!visit[i][j]) return false;

    return true;
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
