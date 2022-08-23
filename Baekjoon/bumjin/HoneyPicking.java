package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HoneyPicking {

    /**
     * 백준(21758) - 꿀 따기(https://www.acmicpc.net/problem/21758)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i - 1];
        }

        int result = 0;

        //1. 벌벌꿀 : -> ->
        for (int i = 2; i <= N - 1; i++) {
            //총합 - 1번째
            //총합 - i번째합
            int temp = sum[N] - arr[1] - arr[i] + sum[N] - sum[i];
            result = Math.max(result, temp);
        }

        //2. 벌꿀벌 : -> <-
        for (int i = 2; i <= N - 1; i++) {
            int temp = sum[N - 1] - sum[i - 1] + sum[i] - sum[1];
            result = Math.max(result, temp);
        }

        //3. 꿀벌벌 : <- <-
        for (int i = 2; i <= N - 1; i++) {
            int temp = sum[N - 1] - arr[i] + sum[i - 1];
            result = Math.max(result, temp);
        }

        System.out.println(result);
    }
}
