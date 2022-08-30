package Baekjoon.bumjin;

import java.util.Scanner;

public class EasySteps {

    /**
     * 백준(10844) - 쉬운 계단 수(https://www.acmicpc.net/problem/10844)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //길이가 i, j로 끝나는 수의 계단 수 (1~9)
        long[][] dp = new long[n + 1][10];

        //길이가 1인 계단은 1개 - 초기값 설정
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 9) {
                    //8만 가능
                    dp[i][j] = dp[i - 1][j - 1] % 1000000000;
                } else if (j == 0) {
                    //1만 가
                    dp[i][j] = dp[i - 1][j + 1] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % 1000000000);
    }
}
