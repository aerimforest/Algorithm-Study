package Baekjooon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LCS2 {

    /**
     * 백준(9252) - LCS2(https:/www.acmicpc.net/problem/9252)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = reader.readLine().toCharArray();
        char[] arr2 = reader.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

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
        sb.append(dp[arr1.length][arr2.length]).append("\n");

        int now = dp[arr1.length][arr2.length];
        int x = arr1.length;
        int y = arr2.length;

        Stack<Character> stack = new Stack<>();

        while (x > 0 && y > 0 && now > 0) {
            if (dp[x - 1][y] == now) {
                x--;
            } else if (dp[x][y - 1] == now) {
                y--;
            } else {
                x--;
                y--;
                now--;
                stack.push(arr1[x]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
