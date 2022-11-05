package Baekjoon.jaehyung;

/**
 * 떡 먹는 호랑이 [실버 2] (성공)
 * https://www.acmicpc.net/problem/2502
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡먹는호랑이 {

  int[] fibo = new int[31];

  public void solution(int D, int K) {
    fibo[1] = 1;
    fibo[2] = 1;
    for (int i=3; i<fibo.length; i++) {
      fibo[i] = fibo[i-2] + fibo[i-1];
    }
    int aCnt = fibo[D-2];
    int bCnt = fibo[D-1];

    int a = 1;
    int b = 1;

    while(true){
      int sum = a*aCnt + b*bCnt;
      if (sum > K) {
        a++;
        b = 1;
      } else if (sum == K){
        break;
      } else {
        b++;
      }
    }

    System.out.println(a);
    System.out.println(b);
  }

  private void printMap(int[][] map) {
    for (int[] row : map) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    떡먹는호랑이 T = new 떡먹는호랑이();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());

    T.solution(input[0], input[1]);
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
