package Baekjoon.jaehyung;

/**
 * 피자판매 [골드 2] (미성공)
 * https://www.acmicpc.net/problem/2632
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 피자판매 {

  static int totalCnt = 0;

  public void solution(int C, int[] A, int[] B) {

    // 순환 배열의 부분합을 구하기 위해 배열길이를 2배로 증가
    int[] extA = extendArray(A);
    int[] extB = extendArray(B);

    // 모든 경우의 부분합 중, 목표 피자크기보다 작은 부분합 저장
    List<Integer> partialSumListA = getPartialSumList(extA, A.length, C);
    List<Integer> partialSumListB = getPartialSumList(extB, B.length, C);

    // 아래 연산을 위해 정렬
    Collections.sort(partialSumListA);
    Collections.sort(partialSumListB);

    // A 부분합과, B 부분합을 더해서 목표 피자크기가 있는지 확인
    // 오름차순 정렬이기 때문에 두 부분합의 합이 목표 피자크기를 넘어가면 continue
    Loop1:
    for (Integer partialA : partialSumListA) {
      for (Integer partialB : partialSumListB) {
        int sum = partialA + partialB;
        if (sum == C) {
          totalCnt++;
        } else if (sum > C) {
          continue Loop1;
        }
      }
    }

    // 결과 출력
    System.out.println(totalCnt);
  }

  // 모든 경우의 부분합 연산
  private List<Integer> getPartialSumList(int[] extArr, int arrLength, int C) {
    List<Integer> partialSumList = new ArrayList<>();
    for (int i=1; i<=arrLength; i++){
      int sum = 0;
      int left = 0;
      for (int right=0; right<arrLength+i; right++){
        if (right - left == i) {
          if (sum == C){
            totalCnt++;
          }
          // 부분합이 목표 피자크기보다 작을경우만 저장
          if (sum < C){
            partialSumList.add(sum);
          }
          sum -= extArr[left++];
        }
        sum += extArr[right];
      }
    }
    return partialSumList;
  }

  private int[] extendArray(int[] arr){
    int[] ext = new int[arr.length*2];
    for (int i=0; i<ext.length; i++){
      ext[i] = arr[i%arr.length];
    }
    return ext;
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
