package Baekjoon.jaehyung;

/**
 * 겹치는건싫어 [골드 4] (성공)
 * https://www.acmicpc.net/problem/20922
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 겹치는건싫어 {

  int maxLength = 0;
  int[] numCnt = new int[100001];

  public void solution(int N, int K, int[] list) {
    int start = 0;
    int end;

    for (int i=0; i<list.length; i++){
      int currNum = list[i];
      end = i;
      numCnt[currNum]++;
      if(numCnt[currNum] > K){
//        System.out.println("넘어, i: " + i + ", currNum: " + currNum + ", start: " + start + ", end: " + end);
        maxLength = Math.max(maxLength, (end-1)-start+1);

//        System.out.println("oldStart: " + start);
        while(numCnt[currNum] > K) {
          numCnt[list[start++]]--;
        }
//        System.out.println("newStart: " + start);
      }
//      System.out.println("end: " + end);
      maxLength = Math.max(maxLength, end-start+1);
    }
    System.out.println(maxLength);
  }

  public static void main(String[] args) throws IOException {
    겹치는건싫어 T = new 겹치는건싫어();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int K = input[1];
    int[] list = input2Array(br.readLine());
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
