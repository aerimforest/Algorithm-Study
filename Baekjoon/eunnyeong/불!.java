import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int r, c, ans;
  static int[] dx = {0, -1, 1, 0}, dy = {1, 0, 0, -1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    char[][] map = new char[r][c];
    Move start = null;
    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      map[i] = s.toCharArray();
      for (int j = 0; j < c; j++) {
        if (map[i][j] == 'J')
          start = new Move(i, j, 0, map);
      }
    }

    ans = Integer.MAX_VALUE;
    bfs(map, start);

    if (ans == Integer.MAX_VALUE)
      System.out.print("IMPOSSIBLE");
    else
      System.out.print(ans + 1);
  }

  public static char[][] fire(char[][] map) {
    char[][] tmp = new char[r][c];
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        tmp[i][j] = map[i][j];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (map[i][j] == 'F') {
          for (int k = 0; k < 4; k++) {
            int nx = i + dx[k], ny = j + dy[k];
            if (range(nx, ny) && map[nx][ny] != '#')
              tmp[nx][ny] = 'F';
          }
        }
      }
    }
    map = tmp.clone();
    return map;
  }

  public static void bfs(char[][] map, Move start) {
    Queue<Move> q = new ArrayDeque<>();
    boolean[][] visit = new boolean[r][c];
    q.add(start);

    while (!q.isEmpty()) {
      Move p = q.poll();
      visit[p.x][p.y] = true;

      if (((p.x == r - 1 || p.x == 0) || (p.y == c - 1 || p.y == 0)) && p.map[p.x][p.y] == '.')
        ans = Math.min(p.cnt, ans);

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && p.map[nx][ny] == '.')
          q.add(new Move(nx, ny, p.cnt + 1, fire(p.map)));
      }
    }
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < r && ny >= 0 && ny < c) return true;
    return false;
  }

  static class Move {
    int x, y, cnt;
    char[][] map;
    public Move(int x, int y, int cnt, char[][] map) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.map = map.clone();
    }
  }
}
