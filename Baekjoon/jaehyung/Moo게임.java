package Baekjoon.jaehyung;

/**
 * Moo게임 [골드 5] (미성공)
 * https://www.acmicpc.net/problem/5904
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Moo게임 {

  public void solution(int N) {

    StringBuilder mooSb = new StringBuilder("moo");

    int k = 1;
    while(true){
      StringBuilder sb = new StringBuilder(mooSb);
      sb.append("m");
      for (int i=0; i<k+2; i++) {
        sb.append("o");
      }
      sb.append(mooSb);

      if (sb.length() > N){
        System.out.println(sb.toString().charAt(N-1));
        break;
      }
      mooSb = sb;
      k++;
    }
  }

  public static void main(String[] args) throws IOException {
    Moo게임 T = new Moo게임();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    T.solution(N);
  }
}
