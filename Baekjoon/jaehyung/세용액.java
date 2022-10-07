package Baekjoon.jaehyung;

/**
 * 세 용액 [골드 3] (성공)
 * https://www.acmicpc.net/problem/2473
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {

  static long max = Long.MAX_VALUE;
  static long[] pick = new long[3];

  public void solution(int N, long[] list) {
    Arrays.sort(list);

    for (int i=0; i<N-2; i++){
      int left = i + 1;
      int right = N - 1;

      while (left < right) {
        long sum = list[left] + list[right] + list[i];
        long absSum = Math.abs(sum);

        if(absSum < max) {
          pick[0] = list[left];
          pick[1] = list[right];
          pick[2] = list[i];
          max = absSum;
        }

        if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }
    Arrays.sort(pick);

    System.out.println(pick[0] + " " + pick[1] + " " + pick[2]);
  }

  public static void main(String[] args) throws IOException {
    세용액 T = new 세용액();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] list = input2Array(br.readLine());
    T.solution(N, list);
  }

  private static long[] input2Array(String inputLine){
    StringTokenizer st = new StringTokenizer(inputLine);
    long[] arr = new long[st.countTokens()];
    int cnt = 0;
    while(st.hasMoreTokens()){
      arr[cnt] = Integer.parseInt(st.nextToken());
      cnt++;
    }
    return arr;
  }
}
