import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        dp[0] = a[0] = 0;
        for (int i = 1; i  <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], dp[i - j] + a[j]); //각 카드 개수마다 최댓값 구해서 저장

        System.out.println(dp[n]);
    }
}
