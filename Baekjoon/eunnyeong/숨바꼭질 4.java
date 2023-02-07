import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

  static int n, k, min = Integer.MAX_VALUE;
  static Stack s = new Stack();


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    bfs();

    System.out.println(min);
    while (!s.isEmpty())
      System.out.print(s.pop() + " ");
  }

  public static void bfs() {
    int[] visit = new int[100001];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(n, 0));
    visit[n] = 1;
    int nn, m = k;
    while (!q.isEmpty()) {
      Point p = q.poll();

      if (p.x == k) {
        min = Math.min(min, p.y);
      }

      if (range(p.x + 1) && visit[p.x + 1] != 0) {
        q.add(new Point(p.x + 1, p.y + 1));
        visit[p.x + 1] = p.x;
      }

      if (range(p.x - 1) && visit[p.x - 1] != 0) {
        q.add(new Point(p.x - 1, p.y + 1));
        visit[p.x - 1] = p.x;
      }

      if (range(p.x * 2) && visit[p.x * 2] != 0) {
        q.add(new Point(p.x * 2, p.y + 1));
        visit[p.x * 2] = p.x;
      }
    }

    s.push(k);
    int x = 0;
    while(true) {
      s.push(x);
      x = visit[x];
      if (x == 1) break;
      System.out.println(m);
    }
    s.push(n);
  }

  public static boolean range(int x) {
    if (x >= 0 && x <=100000) return true;
    return false;
  }
}
