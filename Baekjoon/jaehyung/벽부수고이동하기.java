package Baekjoon.jaehyung;

/**
 * 벽 부수고 이동하기 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/2206
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

  static boolean[][][] visited;
  static int[] dr = new int[] {-1, 0, 1, 0};
  static int[] dc = new int[] {0, -1, 0, 1};

  private void bfs(int N, int M, int[][] map){
    Queue<Position> queue = new LinkedList<>();
    queue.offer(new Position(0, 0, 1, 0));
    visited[0][0][0] = true;
    while(!queue.isEmpty()){
      Position currPosition = queue.poll();

      for (int i=0; i<4; i++) {
        int newR = currPosition.r + dr[i];
        int newC = currPosition.c + dc[i];

        if (newR < 0 || newR >= N || newC < 0 || newC >= M){
          continue;
        }

        if (map[newR][newC] == 1) {
          if (currPosition.crashed == 0 && !visited[1][newR][newC]) {
            visited[currPosition.crashed][newR][newC] = true;
            queue.offer(new Position(newR, newC, currPosition.cost+1, 1));
          }
        } else {
          if (!visited[currPosition.crashed][newR][newC]) {
            visited[currPosition.crashed][newR][newC] = true;
            queue.offer(new Position(newR, newC, currPosition.cost+1, currPosition.crashed));
          }
        }

        if (newR == N-1 && newC == M-1) {
          System.out.println(currPosition.cost + 1);
          System.exit(0);
        }
      }
    }
  }

  public void solution(int N, int M, int[][] map) {
    if (N == 1 && M == 1){
      System.out.println(1);
      return;
    }

    visited = new boolean[2][N][M];
    bfs(N, M, map);
    System.out.println(-1);
  }

  private void printMap(int[][] map) {
    for (int[] row : map) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    벽부수고이동하기 T = new 벽부수고이동하기();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int M = input[1];
    int[][] list = new int[N][M];
    for (int i=0;i<N;i++){
      String rowStr = br.readLine();
      int[] row = new int[M];
      for (int j=0; j<M; j++) {
        row[j] = Integer.parseInt(String.valueOf(rowStr.charAt(j)));
      }
      list[i] = row;
    }
    T.solution(N, M, list);
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

  static class Position{
    int r;
    int c;
    int cost;
    int crashed;

    public Position(int r, int c, int cost, int crashed){
      this.r = r;
      this.c = c;
      this.cost = cost;
      this.crashed = crashed;
    }
  }
}
