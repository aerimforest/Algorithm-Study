import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, d, k, c;
    static int[] A;
    static int[] eat;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        A = new int[n+1];
        eat = new int[d+1];
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(br.readLine());
    }

    static void pro() {
        int R = 0, ans = 1;
        eat[c] = 30001;
        for (int L = 1; L <= n; L++) {
            A[eat[L-1]]--; // L-1 번째 구간 제외
            while (R + 1 <= n &&)

        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
