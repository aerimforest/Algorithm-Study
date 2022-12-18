import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    dp[i] = (dp[i]+dp[j]) % 998244353;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(dp[i]+" ");
        }
    }
}
