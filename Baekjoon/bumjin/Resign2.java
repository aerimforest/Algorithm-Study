package baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resign2 {

    /**
     * 백준 15486 퇴사2 (https://www.acmicpc.net/problem/15486)
     */
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] t = new int[n];
        int[] p = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        //t가 8번째일 때 끝

        //dp : N일에 얻을 수 있는 최대 수익
        int[] dp = new int[n + 1];

        //점화식
        //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장한다.
        //이후, 중복될 때 최대값을 넣는다.
        //dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);

        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) {
                //날짜가 범위를 넘어가지 않는 경우
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[n]);

    }//main
}
