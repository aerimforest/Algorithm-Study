package Baekjoon.jaehyung;

/**
 * 마법사상어와토네이도 [골드 3] (성공)
 * https://www.acmicpc.net/problem/20057
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {

  static int[] dr = {0,1,0,-1};
  static int[] dc = {-1,0,1,0};
  static int[] dcr = {1,1,2,2};
  static int[][] dsr = {
          {-1,1,-2,-1,1,2,-1,1,0},
          {-1,-1,0,0,0,0,1,1,2},
          {1,-1,2,1,-1,-2,1,-1,0},
          {1,1,0,0,0,0,-1,-1,-2}
  };
  static int[][] dsc = {
          {1,1,0,0,0,0,-1,-1,-2},
          {-1,1,-2,-1,1,2,-1,1,0},
          {-1,-1,0,0,0,0,1,1,2},
          {1,-1,2,1,-1,-2,1,-1,0}
  };
  static int[] sandRatio ={1,1,2,7,7,2,10,10,5};

  public void solution(int N, int[][] map) {
    System.out.println(calculateOutSand(N/2, N/2, N, map));
  }

  private int calculateOutSand(int r, int c, int N, int[][] map) {
    int totalOutSand = 0;

    int currR = r;
    int currC = c;

    while (true) {
      for (int i = 0; i < 4; i++) {
        for (int moveCount = 0; moveCount < dcr[i]; moveCount++) {
          int newR = currR + dr[i];
          int newC = currC + dc[i];
          if (newR < 0 || newC < 0 || newR >= N || newC >= N) {
            return totalOutSand;
          }

          int sand = map[newR][newC];
          map[newR][newC] = 0;
          int spreadTotal = 0;

          for (int spread = 0; spread < 9; spread++) {
            int sandX = newR + dsr[i][spread];
            int sandY = newC + dsc[i][spread];
            int spreadAmount = (sand * sandRatio[spread]) / 100;

            if (sandX < 0 || sandX >= N || sandY < 0 || sandY >= N) {
              totalOutSand += spreadAmount;
            } else {
              map[sandX][sandY] += spreadAmount;
            }
            spreadTotal += spreadAmount;
          }

          int alphaX = newR + dr[i];
          int alphaY = newC + dc[i];
          int alphaAmount = sand - spreadTotal;
          if (alphaX < 0 || alphaX >= N || alphaY < 0 || alphaY >= N) {
            totalOutSand += alphaAmount;
          } else {
            map[alphaX][alphaY] += alphaAmount;
          }

          currR = newR;
          currC = newC;
        }
      }

      for (int index = 0; index < 4; index++) {
        dcr[index] += 2;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    마법사상어와토네이도 T = new 마법사상어와토네이도();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] list = new int[N][N];
    for (int i=0;i<N;i++){
      list[i] = input2Array(br.readLine());
    }
    T.solution(N, list);
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
