import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, b, min, max;
    static int[] ans;
    static int[][] A;
    static boolean found;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void calculation(int mid) {
        int add = 0, sub = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] < mid) add++;
                else if (A[i][j] > mid) sub++;
            }
        }
        int have = b + sub;
        if (add <= have) {
            int time = sub * 2 + add;
            if (time < ans[0]) {
                ans[0] = time;
                ans[1] =  mid;
            }
        }
    }

    static void pro() {
        ans = new int[2];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(min, A[i][j]);
                max = Math.max(max, A[i][j]);
            }
        }
        ans[0] = Integer.MAX_VALUE;
        for (int i = max; i >= min; i--) {
            calculation(i);
        }
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
