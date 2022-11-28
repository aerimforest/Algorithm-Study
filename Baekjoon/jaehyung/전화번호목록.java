package Baekjoon.jaehyung;

/**
 * 전화번호목록 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/5052
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 전화번호목록 {

  public void solution(int n, String[] list) {
    if (n == 1) {
      System.out.println("YES");
      return;
    }
    Arrays.sort(list);
    for (int i=1; i<n; i++){
      if (list[i-1].length() < list[i].length()){
        if (list[i-1].equals(list[i].substring(0,list[i-1].length()))){
          System.out.println("NO");
          return;
        }
      }
    }
    System.out.println("YES");
  }

  public static void main(String[] args) throws IOException {
    전화번호목록 T = new 전화번호목록();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test = Integer.parseInt(br.readLine());
    for (int i=0; i<test; i++) {
      int n = Integer.parseInt(br.readLine());
      String[] list = new String[n];
      for (int j=0;j<n;j++){
        list[j] = br.readLine();
      }
      T.solution(n, list);
    }
  }
}
