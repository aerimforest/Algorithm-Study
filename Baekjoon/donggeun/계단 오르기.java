import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < Math.min(2, n); i++) {
            dp[i] = sum(arr, i);
        }

        if (n >= 3) {
            dp[2] = Math.max(arr[0], arr[1]) + arr[2];
        }
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }
        System.out.println(dp[n - 1]);
    }

    public static Integer sum(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += arr[i];
        }
        return res;
    }
}
