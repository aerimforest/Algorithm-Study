package Baekjoon.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열복원하기 {

  public void solution(int H, int W, int X, int Y, int[][] map) {
    int[][] original = new int[H][W];

    for (int r=0; r<H+X; r++){
      if (r<X){
        for (int c=0; c<W; c++){
          original[r][c] = map[r][c];
        }
      } else if (r<H-1){
        for (int c=Y; c<W+Y; c++){
          map[r][c] -= original[r-X][c-Y];
        }
        for (int c=0; c<W; c++){
          original[r][c] = map[r][c];
        }
      } else if (r>H-1){
        for (int c=Y; c<W+Y; c++){
          original[r-X][c-Y] = map[r][c];
        }
      }
    }

    printMap(original);
  }

  private void printMap(int[][] map) {
    for (int[] row : map) {
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<row.length; i++){
        sb.append(row[i]);
        if (i != row.length-1){
          sb.append(" ");
        }
      }
      System.out.println(sb.toString());
    }
  }

  public static void main(String[] args) throws IOException {
    배열복원하기 T = new 배열복원하기();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int H = input[0];
    int W = input[1];
    int X = input[2];
    int Y = input[3];;

    int[][] list = new int[H+X][W+Y];
    for (int i=0;i<H+X;i++){
      list[i] = input2Array(br.readLine());
    }
    T.solution(H, W, X, Y, list);
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
