import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] memo;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        memo = new int[201][201];
    }

    static void pro() {
        for (int i = 1; i < n + 1; i++) {
            memo[i][1] = 1;
        }

        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < k + 1; j++) {
//                if (memo[i][])
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
