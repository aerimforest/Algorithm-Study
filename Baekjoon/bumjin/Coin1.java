package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin1 {

    /**
     * 백준(2293) - 동전1(https://www.acmicpc.net/problem/2293)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        //경우의 수
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
