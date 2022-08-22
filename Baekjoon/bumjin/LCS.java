package baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    /**
     * 백준(9251) - LCS(https://www.acmicpc.net/problem/9251)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = reader.readLine().toCharArray();
        char[] arr2 = reader.readLine().toCharArray();

        //LCS 배열
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    //두 문자가 같으면 길이 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //다를 때 - 이전 값들 중 최대값 넣기
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length]);
    }
}
