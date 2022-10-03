package Baekjoon.jaehyung;

/**
 * 부분수열의 합 [실버 2] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합 {

  static int cnt = 0;

  private void dfs(int depth, int lastIdx, int sum, int goal, int[] seq) {
    if (depth == lastIdx) {
      if (sum == goal) {
        cnt++;
      }
      return;
    }
    dfs(depth+1, lastIdx, sum + seq[depth], goal, seq);
    dfs(depth+1, lastIdx, sum, goal, seq);
  }

  public void solution(int N, int S, int[] seq) {
    dfs(0, N, 0, S, seq);
    if (S == 0) {
      cnt--;
    }
    System.out.println(cnt);
  }

  public static void main(String[] args) throws IOException {
    부분수열의합 T = new 부분수열의합();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int S = input[1];
    int[] seq = input2Array(br.readLine());
    T.solution(N, S, seq);
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
