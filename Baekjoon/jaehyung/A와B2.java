package Baekjoon.jaehyung;

/**
 * A와B 2 [골드 5] (성공)
 * https://www.acmicpc.net/problem/12919
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A와B2 {

  private void dfs(String S, String T){
    System.out.println(T);
    if (T.length() < S.length()){
      return;
    }
    if (S.length() == T.length()){
      if (S.equals(T)){
        System.out.println(1);
        System.exit(0);
      }
    } else {
      if (T.charAt(0) == 'B'){
        dfs(S, removeB(T));
      }
      if (T.charAt(T.length()-1) == 'A'){
        dfs(S, removeA(T));
      }
    }
  }

  private String removeB(String t){
    StringBuilder sb = new StringBuilder(t.substring(1));
    sb.reverse();
    return sb.toString();
  }

  private String removeA(String t){
    return t.substring(0, t.length()-1);
  }

  public void solution(String S, String T) {
    if (S.length() > T.length()){
      System.out.println(0);
    } else if (S.length() == T.length()){
      if (S.equals(T)){
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    } else {
      dfs(S, T);
      System.out.println(0);
    }
  }

  public static void main(String[] args) throws IOException {
    A와B2 TT = new A와B2();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();

    TT.solution(S, T);
  }
}
