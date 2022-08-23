package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HappyKindergarten {

    /**
     * 백준(13164) - 행복 유치원(https://www.acmicpc.net/problem/13164)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //수들의 차 배열에 넣기
        int[] minus = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            minus[i] = arr[i + 1] - arr[i];
        }

        //정렬 후 낮은 수부터 더하기
        Arrays.sort(minus);

        int num = 0;
        for (int i = 0; i < minus.length - (K - 1); i++) {
            num += minus[i];
        }
        System.out.println(num);
    }
}
