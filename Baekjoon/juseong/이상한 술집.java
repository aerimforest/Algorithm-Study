import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, k, ans;
    static int[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];
        for (int i = 0; i < n ; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    static boolean determination(int num) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] / num;
        }
        return k <= sum;
    }

    static void pro() {
        int L = 0, R = Integer.MAX_VALUE;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
