package Baekjoon.jaehyung;

/**
 * 성곽 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/2234
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 성곽 {

  static int[][] visited;

  private void findIsland(int r, int c, int[][] map){

  }

  public void solution(int R, int C, int[][] map) {
//    System.out.println(Arrays.deepToString(map));

    Room[][] roomMap = new Room[R][C];

    for (int r=0; r<R; r++){
      for (int c=0; c<C; c++){
        roomMap[r][c] = new Room(map[r][c]);
      }
    }

    for (int r=0; r<R; r++){
      for (int c=0; c<C; c++){
        if (visited[r][c] == 0){

        }
      }
    }


  }

  public static void main(String[] args) throws IOException {
    성곽 T = new 성곽();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int R = input[1];
    int C = input[0];
    visited = new int[R][C];
    int[][] list = new int[R][C];
    for (int i=0;i<R;i++){
      list[i] = input2Array(br.readLine());
    }
    T.solution(R, C, list);
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

class Room {
  boolean up = false;
  boolean left = false;
  boolean down = false;
  boolean right = false;

  public Room(int wall){
    System.out.println(wall);
    System.out.println(Integer.toBinaryString(wall));
    System.out.println(wall & 2);
    System.out.println();
  }
}