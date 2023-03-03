import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        if (o1.x == o2.y)
          return o1.y - o2.y;
        return o1.x - o2.x;
      }
    });

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      q.add(new Point(x, y));
    }

    int cnt = 0;
    Point p = q.poll();
    while (!q.isEmpty()) {
      if (p.y <= q.peek().x) {
        p = q.poll();
      }
      else if (p.y > q.peek().x) {
        cnt++;
        //System.out.println(p.x + " " + p.y);
        p = q.poll();
      }
      else {
        Point t = q.poll();
        q.add(t);
      }
    }
    if (cnt == 0) cnt++;
    System.out.print(cnt);
  }
}
