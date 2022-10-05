package Baekjoon.jaehyung;

/**
 * 마법사 상어와 파이어볼 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/20056
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼 {

  public void solution(int N, int[][] list) {
    System.out.println(N);
    System.out.println(Arrays.deepToString(list));
  }

  public static void main(String[] args) throws IOException {
    마법사상어와파이어볼 T = new 마법사상어와파이어볼();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] list = new int[N][2];
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
