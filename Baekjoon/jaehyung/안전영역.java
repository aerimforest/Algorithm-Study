package Baekjoon.jaehyung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 안전 영역 [실버 1] (성공)
 * https://www.acmicpc.net/problem/2468
 */
public class 안전영역 {

  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int[][] visited;

  private void dfs(int r, int c, int h, int[][] map){
    // 최소/최대 범위를 안벗어나도록 체크
    if (r < 0 || r >= map.length || c < 0 || c >= map.length){
      return;
    }

    // 이미 방문한 곳은 방문하지 않도록 체크
    if (visited[r][c] == 1) {
      return;
    }

    // 물에 잠긴곳으로 이동하지 않도록 체크
    if (map[r][c] <= h){
      return;
    }

    visited[r][c] = 1;
    for (int i=0; i<4; i++){
      dfs(r + dr[i], c + dc[i], h, map);
    }
  }

  public void solution(int C, int[][] map) {
    // 지역의 최고 높이 구하기
    int maxHeight = 0;
    for (int i=0; i<C; i++){
      for (int j=0; j<C; j++){
          maxHeight = Math.max(maxHeight, map[i][j]);
      }
    }

    int maxIslandCnt = 0;
    for (int h=0; h<=maxHeight; h++) {
      visited = new int[C][C];
      int islandCnt = 0;
      System.out.println("물높이: " + h);
      System.out.println("잠김=0, 안잠김=1");
      for (int i=0; i<C; i++){
        for (int j=0; j<C; j++){
          // 안잠겨있고, 아직 방문안한 곳에서 방문을 시작하여 모든 영역을 탐색한다.
          // 한 영역을 탐색할때마다 카운트 수를 증가한다
          if (map[i][j] > h && visited[i][j] == 0){
            islandCnt++;
            dfs(i, j, h, map);
          }
        }
      }
      printMap(visited);
      // 가장 많이 발견된
      maxIslandCnt = Math.max(maxIslandCnt, islandCnt);
    }

    System.out.println(maxIslandCnt);
  }

  private void printMap(int[][] map){
    for (int[] ints : map) {
      System.out.println(Arrays.toString(ints));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    안전영역 T = new 안전영역();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];
    for (int i=0;i<N;i++){
      map[i] = input2Array(br.readLine());
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
}

