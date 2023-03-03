import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static List<List<Route>> list;
    public static PriorityQueue<Route> pq;
    public static int[] dist, visited;

    public static void solve(int start, int end) {
        pq = new PriorityQueue<>();
        pq.offer(new Route(start, 0));
        dist[start] = 0;
        boolean[] vtd = new boolean[N + 1];
        while (!pq.isEmpty()) {
            Route r = pq.poll();

            if (vtd[r.num]) continue;
            vtd[r.num] = true;
            for (Route ro : list.get(r.num)) {
                if (dist[ro.num] > dist[r.num] + ro.cost) {
                    dist[ro.num] = dist[r.num] + ro.cost;
                    pq.offer(new Route(ro.num, dist[ro.num]));
                    visited[ro.num] = r.num;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      N = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(bf.readLine());
      M = Integer.parseInt(st.nextToken());

      list = new ArrayList<>();
      dist = new int[N + 1];
      visited = new int[N + 1];
      for (int i = 0; i <= N; i++) {
        list.add(new ArrayList<>());
        dist[i] = 987654321;
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        list.get(a).add(new Route(b, c));
      }

      st = new StringTokenizer(bf.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      solve(start, end);

      List<Integer> temp = new ArrayList<>();
      int find = end;
      while (find > 0) {
        temp.add(find);
        find = visited[find];
      }

      System.out.println(dist[end]);
      System.out.println(temp.size());
      StringBuilder sb = new StringBuilder();
      for (int i = temp.size() - 1; i >= 0; i--)
        sb.append(temp.get(i)).append(" ");
      System.out.println(sb.toString());
    }
    
    static class Route implements Comparable<Route> {
      int num;
      int cost;

      public Route(int num, int cost) {
          this.num = num;
          this.cost = cost;
      }

      @Override
      public int compareTo(Route o) {
          return this.cost - o.cost;
      }
  }
}
