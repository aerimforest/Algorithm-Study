package Baekjoon.jaehyung;

/**
 * 경사로 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/14890
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 경사로 {

  static int cnt = 0;

  private void crossingRoad(int[] road, int L) {
    int tmpL = 0;
    int[] visited = new int[road.length];

    // 한번에 높이 차이가 2이상 나는 부분이 있는지 전체 체크
    for (int i=1; i<road.length; i++) {
      if (Math.abs(road[i] - road[i-1]) > 1){
        return;
      }
    }

    for (int i=1; i<road.length; i++) {

      boolean canCross = true;

      // 경사를 발견했을 때 높은 곳에서 양쪽 검사
      if (road[i] - road[i-1] == -1) {
        canCross = checkLeftRight(i-1, L, road, visited);
      } else if (road[i] - road[i-1] == 1){
        canCross = checkLeftRight(i, L, road, visited);
      }

      if (!canCross){
        return;
      }
    }
    System.out.println(Arrays.toString(road));
    cnt++;
  }

  // 높은곳에서 양옆 검사
  private boolean checkLeftRight(int peakIdx, int L, int[] road, int[] visited) {

    int leftCnt = 0;
    for (int i=1; i<=L; i++) {
      int nextIdx = peakIdx - i;
      if (nextIdx < 0) {
        break;
      }

      if (visited[nextIdx] == 1){
        return false;
      }

      leftCnt++;
    }

    if (leftCnt > 0 && leftCnt < L) {
      return false;
    }

    return true;
  }

  public void solution(int N, int L, int[][] map) {
    printMap(map);

    for (int r=0; r<N; r++) {
      crossingRoad(map[r], L);
    }

    System.out.println(cnt);
  }

  private void printMap(int[][] map) {
    for (int[] row : map){
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    경사로 T = new 경사로();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int L = input[1];
    int[][] map = new int[N][N];
    for (int i=0;i<N;i++){
      map[i] = input2Array(br.readLine());
    }
    T.solution(N, L, map);
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
