import java.util.*;
import java.io.*;

/*
V <= 20,000
E <= 200,000

정점 대비 간선이 적음 -> 간선 리스트
정점을 둘로 분할
같은 집합일 시 서로 인접하면 안됨
 */
class Main {

    static int V, E;
    static ArrayList<Integer>[] list;
    static int[] v;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            v = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            if (bfs()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    public static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= V; i++) {
            if (v[i] == 0) {
                v[i] = 1;

                queue.add(i);

                while (!queue.isEmpty()) {
                    int now = queue.poll();

                    for (int to : list[now]) {
                        if (v[now] == v[to]) return false;
                        if (v[to] == 0) {
                            queue.add(to);
                            v[to] = v[now] * -1;
                        }
                    }
                }
            }
        }
        return true;
    }
}