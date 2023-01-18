import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    List<List<Vertex>> list = new ArrayList<>();
    for (int i = 0; i < n + 1; i++)
      list.add(new ArrayList<Vertex>());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      list.get(from).add(new Vertex(to, weight));
    }

    //반복문 안에서 쓸 자원 생성
    PriorityQueue<Vertex> pq = new PriorityQueue<>();
    int[] distance = new int[n + 1];
    boolean[] visit = new boolean[n + 1];
    final int max = Integer.MAX_VALUE;

    //반복문 안에서 쓸 자원 초기화
    Arrays.fill(distance, max);
    distance[x] = 0;
    pq.offer(new Vertex(x, distance[x]));
    Vertex cur = null;

    while (!pq.isEmpty()) {
      cur = pq.poll();
      if (distance[cur.no] < cur.weight || visit[cur.no]) continue;
      visit[cur.no] = true;

      for (int i = 0; i < list.get(cur.no).size(); i++) {
        Vertex next = list.get(cur.no).get(i);
        if (distance[next.no] > distance[cur.no] + next.weight && !visit[next.no]) {
          distance[next.no] = distance[cur.no] + next.weight;
          pq.offer(new Vertex(next.no, distance[next.no]));
        }
      }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++)
     ans = Math.max(ans, distance[i]);

    System.out.println(ans);
  }

  static class Vertex implements Comparable<Vertex>{
    int no;
    int weight;

    public Vertex(int no, int weight) {
      this.no = no;
      this.weight = weight;
    }
    @Override
    public int compareTo(Vertex o) {
      return this.weight-o.weight;
    }
  }
}
