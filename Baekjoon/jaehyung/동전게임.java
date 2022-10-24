package Baekjoon.jaehyung;

/**
 * 동전게임 [실버 2] (미성공)
 * https://www.acmicpc.net/problem/9079
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전게임 {

  public void solution(int[][] map) {
    printMap(map);

    if (checkMap(map)){
      System.out.println(0);
      return;
    }
  }

  private void flipRow(int r, int[][] map) {
    int[] row = map[r];
    for (int c=0; c<3; c++){
      if (row[c] == 0){
        row[c] = 1;
      } else {
        row[c] = 0;
      }
    }
  }

  private boolean checkMap(int[][] map) {
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (map[i][j] != map[0][0])
          return false;
      }
    }
    return true;
  }

  private void printMap(int[][] map) {
    for (int[] row : map){
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    동전게임 T = new 동전게임();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i=0;i<N;i++){
      int[][] list = new int[3][3];
      for (int j=0;j<3;j++){
        list[j] = input2Array(br.readLine());
      }
      T.solution(list);
    }
  }

  private static int[] input2Array(String inputLine){
    StringTokenizer st = new StringTokenizer(inputLine);
    int[] arr = new int[st.countTokens()];
    int cnt = 0;
    while(st.hasMoreTokens()){
      arr[cnt] = st.nextToken().equals("T") ? 1 : 0;
      cnt++;
    }
    return arr;
  }
}
