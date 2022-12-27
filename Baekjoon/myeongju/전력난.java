import java.util.*;
import java.io.*;

/*
모든 집들이 불이 켜진 길로 왕래 가능해야 함
<= 200,000
 */
public class Main {
    static int N,M;
    static int[] parents;
    static PriorityQueue<Node> queue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(M==0&&N==0) break;

            int sum = 0;
            queue = new PriorityQueue<>(((o1, o2) -> o1.d-o2.d));
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                sum += d;
                queue.add(new Node(a,b,d));
            }

            sb.append((sum- kruskal())).append("\n");
        }
        System.out.print(sb);
    }

    public static int kruskal() {
        int sum = 0;
        int cnt = 0;

        parents = new int[M];
        for (int i = 0; i < M; i++)
            parents[i] = i;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(union(now.from, now.to)) {
                sum += now.d;
                if(++cnt==M-1) break;
            }
        }

        return sum;
    }

    public static int find(int a) {
        if(parents[a] == a) return a;
        else return parents[a]=find(parents[a]);
    }

    public static boolean union(int a,int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1==p2) return false;
        parents[p2] = p1;
        return true;
    }

    public static class Node{
        int from;
        int to;
        int d;
        public Node(int from, int to, int d) { this.from = from; this.to=to; this.d=d;}
    }
}