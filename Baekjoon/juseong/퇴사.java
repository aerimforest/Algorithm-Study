import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        rec_func(0, 0);
        System.out.println(ans);
    }

    static void rec_func(int index, int sum) {
        if (index == n) {
            ans = Math.max(ans, sum);
            return;
        }
        if (index + A[index][0] <= n) rec_func(index + A[index][0], sum + A[index][1]);
        rec_func(index + 1, sum);
    }
}
