package Baekjoon.jaehyung;

/**
 * 공유기설치 [골드 4] (성공)
 * https://www.acmicpc.net/problem/2110
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {

  public void solution(int N, int C, int[] houseList) {
    Arrays.sort(houseList);
    int start = 1;
    int end = houseList[N-1] - houseList[0];
    int result = 0;

    while (start <= end) {
      int mid = (start + end)/2;

      int cnt = 1;
      int prevHouse = houseList[0];
      for (int i=1; i<N; i++) {
        if (houseList[i] - prevHouse >= mid) {
          cnt++;
          prevHouse = houseList[i];
        }
      }

      if (cnt >= C){
        result = Math.max(result, mid);
        start = mid + 1;
      } else {
        end = mid-1;
      }
    }
    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    공유기설치 T = new 공유기설치();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int C = input[1];
    int[] list = new int[N];
    for (int i=0;i<N;i++){
      list[i] = Integer.parseInt(br.readLine());
    }
    T.solution(N, C, list);
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
