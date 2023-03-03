import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] A;
    static int n;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new long[n+1][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        A[n][0] = A[0][0];
        A[n][1] = A[0][1];
    }

    static void pro() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i][0] * A[i + 1][1] - A[i+1][0] * A[i][1];
        }
        sum = Math.abs(sum);
        System.out.printf("%.1f", (double)sum/2);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
