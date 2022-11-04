package Baekjoon.jaehyung;

/**
 * 알고스팟 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/1261
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 알고스팟 {

  static int[] dr = new int[] {-1, 0, 1, 0};
  static int[] dc = new int[] {0, -1, 0, 1};

  private void bfs(int r, int c, int[][] map){

  }

  public void solution(int N, int[][] map) {
    System.out.println(N);
    printMap(map);


  }

  private void printMap(int[][] map) {
    for (int[] row : map) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    알고스팟 T = new 알고스팟();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int M = input[0];
    int N = input[1];

    int[][] map = new int[N][M];
    for (int i=0; i<N; i++){
      char[] rowCharArr = br.readLine().toCharArray();
      for (int c=0; c<M; c++) {
        map[i][c] = Integer.parseInt(String.valueOf(rowCharArr[c]));
      }

    }
    T.solution(N, map);
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

  static class Point{
    int r;
    int c;
    int cnt;
  }
}
