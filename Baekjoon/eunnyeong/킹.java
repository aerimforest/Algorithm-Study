import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] map = new int[9][9];
    int[] dx = {0, 0, 1, -1, -1, -1, 1, 1}, dy = {1, -1, 0, 0, 1, -1, 1, -1 };
    StringTokenizer st = new StringTokenizer(br.readLine());
    String king = st.nextToken();
    String doll = st.nextToken();
    int n = Integer.parseInt(st.nextToken());

    Point k = new Point(king.charAt(0) - 'A' + 1, king.charAt(1) - '0');
    Point d = new Point(doll.charAt(0) - 'A' + 1, doll.charAt(1) - '0');

    for (int i = 0; i < n; i++) {
      String tmp = br.readLine();
      int idx = 0;
      switch (tmp) {
        case "R":
          idx = 0;
          break;
        case "L":
          idx = 1;
          break;
        case "B":
          idx = 2;
          break;
        case "T":
          idx = 3;
          break;
        case "RT":
          idx = 4;
          break;
        case "LT":
          idx = 5;
          break;
        case "RB":
          idx = 6;
          break;
        case "LB":
          idx = 7;
          break;
      }
      int nx = k.x + dx[idx], ny = k.y + dy[idx];
      if (range(nx, ny)) {
        k = new Point(nx, ny);
      }
      if (k.x == d.x && k.y == d.y) {
        nx = d.x + dx[idx]; ny = d.y + dy[idx];
        if (range(nx, ny)) {
          d = new Point(nx, ny);
        }
      }

    }
    System.out.println((k.x + 'A') + k.y);
    System.out.println((d.x + 'A') + d.y);
    bw.flush(); bw.close(); br.close();
  }

  public static boolean range(int nx, int ny) {
    if (nx > 0 && nx <= 8 && ny > 0 && ny <= 8) return true;
    return false;
  }

}
