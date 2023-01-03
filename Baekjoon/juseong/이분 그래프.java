import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int V, E;
    static ArrayList<Integer>[] adj;
    static int[] group;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점의 개수
            E = Integer.parseInt(st.nextToken()); // 간선의 개수
            adj = new ArrayList[V+1]; // 인접한 정점
            group = new int[V+1]; // k 번째 정점의 그룹 번호(1 or -1)
            for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }
            if (bfs()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static boolean bfs() {
        for (int v = 1; v <= V; v++) {
            if (group[v] != 0) continue;
            q = new LinkedList<>();
            q.add(v); // 시작 정점
            group[v] = 1; // 시작 정점의 그룹 번호
            while (!q.isEmpty()) {
                int n = q.poll(); // 현재 정점
                for (int next: adj[n]) { // 인접한 정점
                    if (group[next] == 0) { // 그룹이 지정되지 않았다면
                        group[next] = group[n] * -1; // 현재 그룹과 다른 그룹에 넣는다
                        q.add(next); // 다음 탐색할 정점 추가
                    } else {
                        if (group[next] == group[n]) return false; // 이분 그래프가 아니면
                    }
                }
            }
        }

        return true; // 이분 탐색 그래프이다
    }
}
