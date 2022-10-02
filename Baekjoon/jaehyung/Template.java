package Baekjoon.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.*;
import java.util.*;

public class Template {

  public void solution(int N, int[][] list) {
    System.out.println(N);
    System.out.println(Arrays.deepToString(list));
  }

  public static void main(String[] args) throws IOException {
    Template T = new Template();
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
