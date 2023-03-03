import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < n; i++)
      q.add(Integer.parseInt(br.readLine()));

    int ans = 0;
    if (q.size() == 1) {
      System.out.print(ans);
      return;
    }
    
    while(q.size() > 2) {
      int a = q.poll();
      int b = -1;
      if (!q.isEmpty())
        b = q.poll();
      if (b != -1) {
        q.add(a + b);
        ans += a + b;
      }
    }

    while (!q.isEmpty())
      ans += q.poll();

    System.out.print(ans);
  }
}
