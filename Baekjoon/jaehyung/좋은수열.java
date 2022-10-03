package Baekjoon.jaehyung;

/**
 * 좋은수열 [골드 4] (성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은수열 {

  private void backTracking(int depth, int N, String seq) {
    if (seq.length() == N){
      System.out.println(seq);
      System.exit(0); // 첫번째 발견한 수열이 최소임으로 바로 종료
    }

    for (int i=1; i<=3; i++) {
      if (isGoodSeq(seq + i)) {
        backTracking(depth+1, N, seq + i);
      }
    }
  }

  // 좋은 수열인지 체크
  private boolean isGoodSeq(String seq){
    int seqSize = seq.length();
    if (seqSize == 1) {
      return true;
    }

    // 연속되는 수열 체크
    for(int i = 1; i <= seqSize/2; i++) {
      String firstHalf = seq.substring(seqSize-i-i, seqSize-i);
      String secondHalf = seq.substring(seqSize-i, seqSize);
      if(firstHalf.equals(secondHalf)) {
        return false;
      }
    }
    return true;
  }

  public void solution(int N) {
    backTracking(0, N, "");
  }

  public static void main(String[] args) throws IOException {
    좋은수열 T = new 좋은수열();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T.solution(Integer.parseInt(br.readLine()));
  }
}
