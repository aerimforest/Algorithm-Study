import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, d;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= n; x++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }
            sb.append(n - d).append("\n");
            d = 0;
        }
        System.out.print(sb.toString());
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        } else {
            for (int i = 1; i <= n; i++) {
                if (find(i) == x) d++;
            }
        }
    }
}
