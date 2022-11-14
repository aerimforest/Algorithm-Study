import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[] node;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new int[n + 1];
        adj = new ArrayList[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            node[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static boolean bfs(ArrayList<Integer> set) {
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> Q = new LinkedList<>();
        visited[set.get(0)] = true;
        Q.add(set.get(0));
        cnt++;
        while(!Q.isEmpty()) {
            int node = Q.poll();
            for (int adjNode: adj[node]) {
                if (visited[adjNode]) continue;
                if (!set.contains(adjNode)) continue;
                visited[adjNode] = true;
                Q.add(adjNode);
                cnt++;
            }
        }
        return set.size() == cnt;
    }

    static void rec_func(int k, int cnt, int flag, int s) {
        if (cnt == s) {
            ArrayList<Integer> setA = new ArrayList<>();
            ArrayList<Integer> setB = new ArrayList<>();
            int sumA = 0, sumB = 0;
            for (int i = 1; i <= n; i++) {
                if ((flag & 1 << i) > 0) {
                    setA.add(i);
                    sumA += node[i];
                } else {
                    setB.add(i);
                    sumB += node[i];
                }
            }
            if (bfs(setA) && bfs(setB)) {
                ans = Math.min(ans, Math.abs(sumA - sumB));
            }
            return;
        }
        if (k == n + 1) return;
        rec_func(k + 1, cnt + 1, flag | 1 << k, s);
        rec_func(k + 1, cnt, flag, s);
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            rec_func(1, 0, 0, i);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
