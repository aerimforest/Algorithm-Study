package Baekjoon.jaehyung;

/**
 * 주사위쌓기 [골드 5] (성공)
 * https://www.acmicpc.net/problem/2116
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위쌓기 {

  static int[] oppositeIdx = new int[] {5, 3, 4, 1, 2, 0};

  public void solution(int N, int[][] list) {

//    System.out.println(N);
//    printMap(list);

    if(N == 0){
      System.out.println(0);
      return;
    }

    if(N == 1){
      System.out.println(Arrays.stream(list[0]).max());
    }

    int[] firstDice = list[0];
    int maxSum = 0;

    for(int upIdx=0; upIdx<6; upIdx++){
      int up = firstDice[upIdx];
      int sumSide = getMaxSide(firstDice, upIdx);
      for (int n=1; n<N; n++){
        int[] stackDice = list[n];
        for (int i=0; i<6; i++){
          if (stackDice[i] == up){
            up = stackDice[oppositeIdx[i]];
            sumSide += getMaxSide(stackDice, i);
            break;
          }
        }
      }
      maxSum = Math.max(maxSum, sumSide);
    }
    System.out.println(maxSum);
  }

  private int getMaxSide(int[] dice, int upOrDownIdx){
    int max = 0;
    for (int i=0; i<6; i++) {
      if (i != upOrDownIdx && i != oppositeIdx[upOrDownIdx]){
        max = Math.max(max, dice[i]);
      }
    }
    return max;
  }

  private void printMap(int[][] map) {
    for (int[] row : map) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    주사위쌓기 T = new 주사위쌓기();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] list = new int[N][6];
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
