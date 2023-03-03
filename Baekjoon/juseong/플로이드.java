import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = 10000001;
                if (i == j) dist[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }
    }

    static void pro() {
        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 시작지
                for (int j = 1 ; j <= n; j++) { // 도착지
                    int a = dist[i][k] + dist[k][j];
                    int b = dist[i][j];
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(dist[i][j] == 10000001 ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
