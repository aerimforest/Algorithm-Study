package Baekjoon.jaehyung;

/**
 * 경사로 [골드 4] (성공)
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
//    System.out.println("도로: " + Arrays.toString(road));
    int[] visited = new int[road.length];

    // 한번에 높이 차이가 2이상 나는 부분이 있는지 전체 체크
    for (int i=1; i<road.length; i++) {
      if (Math.abs(road[i] - road[i-1]) > 1){
        return;
      }
    }

    for (int i=1; i<road.length; i++) {

      // 내리막일때 높은곳의 오른쪽 확인, 오르막일 때 높은곳의 왼쪽 확인
      boolean canCross = true;
      if (road[i] - road[i-1] == -1) {
        canCross = checkRight(i-1, L, road, visited);
      } else if (road[i] - road[i-1] == 1){
        canCross = checkLeft(i, L, road, visited);
      }

      if (!canCross){
        return;
      }
    }
//    System.out.println("건넜습니다.");
//    System.out.println();
    cnt++;
  }

  private boolean checkRight(int peakIdx, int L, int[] road, int[] visited) {
    int rightCnt = 0;
    for (int i=1; i<=L; i++) {
      int nextIdx = peakIdx + i;
      if (nextIdx > road.length -1) {
        break;
      }
      if (visited[nextIdx] == 1){
        return false;
      }
      rightCnt++;
      visited[nextIdx] = 1;
    }

    if (rightCnt > 0 && rightCnt < L) {
//      System.out.println("내리막이지만 앞 도로를 충분히 깔 수 없었습니다.");
      return false;
    }
    return true;
  }

  private boolean checkLeft(int peakIdx, int L, int[] road, int[] visited) {
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
      visited[nextIdx] = 1;
    }

    if (leftCnt > 0 && leftCnt < L) {
//      System.out.println("오르막이지만 오르기 전 도로를 충분히 깔 수 없었습니다.");
      return false;
    }
    return true;
  }

  public void solution(int N, int L, int[][] map) {
//    printMap(map);
    for (int r=0; r<N; r++) {
      crossingRoad(map[r], L);
      int[] col = new int[N];
      for (int c=0; c<N; c++) {
        col[c] = map[c][r];
      }
      crossingRoad(col, L);
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
