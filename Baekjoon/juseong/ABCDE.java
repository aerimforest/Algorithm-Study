import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean found;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void dfs(int k, int depth) {
        visited[k] = true;
        if (depth == 4) {
            found = true;
            return;
        }
        for (int a: adj[k]) {
            if (!visited[a]) {
                dfs(a, depth + 1);
                visited[a] = false;
            }
        }
    }

    static void pro() {
        found = false;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
            if (found) break;
        }
        System.out.println(found ? 1 : 0);

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
