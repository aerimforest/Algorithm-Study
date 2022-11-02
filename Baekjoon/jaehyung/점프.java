package Baekjoon.jaehyung;

/**
 * 점프 [실버 1] (성공)
 * https://www.acmicpc.net/problem/1890
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점프 {

  public void solution(int N, int[][] map) {
    long[][] dp = new long[101][101];
    dp[0][0] = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) {
          continue;
        }

        int dist = map[i][j];
        int down = dist + i;
        int right = dist + j;

        if (down < N) {
          dp[down][j] += dp[i][j];
        }

        if (right < N) {
          dp[i][right] += dp[i][j];
        }
      }
    }
    System.out.println(dp[N - 1][N - 1]);
  }

  private void printMap(int[][] map) {
    for (int[] row : map) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    점프 T = new 점프();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] list = new int[N][N];
    for (int i=0;i<N;i++){
      list[i] = input2Array(br.readLine());
    }
    T.solution(N, list);
  }

  private static int[] input2Array(String inputLine){
    StringTokenizer st = new StringTokenizer(inputLine);
    int[] arr = new int[st.countTokens()];
    int cnt = 0;
    while(st.hasMoreTokens()){
      arr[cnt] = Integer.parseInt(st.nextToken());
      cnt++;
    }
    return arr;
  }
}
