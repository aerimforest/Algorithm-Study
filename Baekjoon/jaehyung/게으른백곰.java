package Baekjoon.jaehyung;

/**
 * 게으른백곰 [실버 3] (성공)
 * https://www.acmicpc.net/problem/10025
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게으른백곰 {

  public void solution(int N, int K, int[][] list) {
    int length = 0;
    for (int[] input : list){
      length = Math.max(length, input[1]);
    }

    int[] line = new int[length + 1];
    for (int[] input : list){
      line[input[1]] = input[0];
    }

    System.out.println(Arrays.toString(line));

    int windowLength = K*2;

    // 처음에 이 조건을 생각못하고 틀림
    if (windowLength >= length){
      System.out.println(Arrays.stream(line).sum());
      System.exit(0);
    }

    int maxSum = 0;

    int sum = 0;
    int left = 0;
    for (int right=0; right<line.length; right++){
      sum += line[right];
      if (right-left == windowLength){
        System.out.println("left: " + left + ", right: " + right + ", sum: " + sum);
        maxSum = Math.max(maxSum, sum);
        sum -= line[left++];
      }
    }
    System.out.println(maxSum);
  }

  private void printMap(int[][] map) {
    for (int[] row : map) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    게으른백곰 T = new 게으른백곰();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int K = input[1];
    int[][] list = new int[N][2];
    for (int i=0;i<N;i++){
      list[i] = input2Array(br.readLine());
    }
    T.solution(N, K, list);
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
