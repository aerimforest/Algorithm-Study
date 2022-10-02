package Baekjoon.jaehyung;

/**
 * 1,2,3 더하기 [실버 3] (미성공)
 * https://www.acmicpc.net/problem/9095
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기 {

  public void solution(int[] list) {
    int max = 0;
    for (int num : list) {
      max = Math.max(max, num);
    }
    int dp[] = new int[max + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i <= max; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    for (int num : list) {
      System.out.println(dp[num]);
    }
  }

  public static void main(String[] args) throws IOException {
    일이삼더하기 T = new 일이삼더하기();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] list = new int[N];
    for (int i=0;i<N;i++){
      list[i] = Integer.parseInt(br.readLine());
    }
    T.solution(list);
  }
}
