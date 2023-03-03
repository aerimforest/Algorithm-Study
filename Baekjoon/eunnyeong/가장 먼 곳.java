import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[3]; //a,b,c
    for (int i = 0; i < 3; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());
    List<List<Vertex>> list = new ArrayList<>();
    for (int i = 0; i <= n; i++)
      list.add(new ArrayList<>());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());
      list.get(d).add(new Vertex(e, l));
      list.get(e).add(new Vertex(d, l));
    }

    int ans = -1;
    for (int start = 1; start <= n; start++) {
      //반복문 안에서 쓸 자원 생성
      PriorityQueue<Vertex> pq = new PriorityQueue<>();
      int[] distance = new int[n + 1];
      boolean[] visit = new boolean[n + 1];
      final int max = Integer.MAX_VALUE;

      //반복문 안에서 쓸 자원 초기화
      Arrays.fill(distance, max);
      distance[start] = 0;
      pq.offer(new Vertex(start, distance[start]));
      Vertex cur = null;

      while (!pq.isEmpty()) {
        cur = pq.poll();
        if (distance[cur.no] < cur.weight || visit[cur.no])
          continue;
        visit[cur.no] = true;

        for (int i = 0; i < list.get(cur.no).size(); i++) {
          Vertex next = list.get(cur.no).get(i);
          if (distance[next.no] > distance[cur.no] + next.weight && !visit[next.no]) {
            distance[next.no] = distance[cur.no] + next.weight;
            pq.offer(new Vertex(next.no, distance[next.no]));
          }
        }
      }

      int tmp = Integer.MAX_VALUE;
      for (int i = 0; i < 3; i++)
        tmp = Math.min(distance[arr[i]], tmp);

      ans = Math.max(ans, tmp);
    }

    System.out.print(ans);
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
