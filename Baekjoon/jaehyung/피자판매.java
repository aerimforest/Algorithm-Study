package Baekjoon.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 피자판매 {

  public void solution(int C, int[] A, int[] B) {
    int[] extA = new int[A.length*2];
    for (int i=0; i<extA.length; i++){
      extA[i] = A[i%A.length];
    }

    int[] extB = new int[B.length*2];
    for (int i=0; i<extB.length; i++){
      extB[i] = A[i%A.length];
    }
    System.out.println(Arrays.toString(extA));
    System.out.println(Arrays.toString(extB));

    // 모든 부분합 구하기
    List<Integer> APartialSumList = new ArrayList<>();

    int sum = 0;
    int left = 0;
    int right = 0;
    for (int i=1; i<=A.length; i++){
      for (int j=0; j<extA.length; j++){

      }
    }

  }

  public static void main(String[] args) throws IOException {
    피자판매 T = new 피자판매();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int C = Integer.parseInt(br.readLine());
    int[] input = input2Array(br.readLine());
    int ARow = input[0];
    int BRow = input[1];

    int[] A = new int[ARow];
    for (int i=0;i<ARow;i++){
      A[i] = Integer.parseInt(br.readLine());
    }

    int[] B = new int[BRow];
    for (int i=0;i<BRow;i++){
      B[i] = Integer.parseInt(br.readLine());
    }

    T.solution(C, A, B);
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
