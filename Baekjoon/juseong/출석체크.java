import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, k, q, m;
    static boolean[] A, B;
    static int[][] scope;
    static int[] nums, sums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new boolean[n + 3];
        B = new boolean[n + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            B[num] = true;
        }
        nums = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        scope = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            scope[i][0] = Integer.parseInt(st.nextToken());
            scope[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        for (int i = 0; i < q; i++) {
            int num = nums[i];
            if (B[num]) continue;
            for (int j = num; j < n + 3; j+=num) {
                if (B[j]) continue;
                A[j] = true;
            }
        }
        sums = new int[n + 3];
        for (int i = 3; i < n + 3; i++) {
            sums[i] = sums[i - 1];
            if (!A[i]) sums[i]++;
        }
        for (int i = 0; i < m; i++) {
            int a = scope[i][0], b = scope[i][1];
            int sum = sums[b] - sums[a-1];
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
