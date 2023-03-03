import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x, y, k;
    static int[][] A;
    static int[] cmd;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cmd = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) cmd[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
