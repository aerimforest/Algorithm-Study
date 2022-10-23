package Baekjoon.jaehyung;

/**
 * 파이프 옮기기 1 [골드 5] (미성공)
 * https://www.acmicpc.net/problem/17070
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 파이프옮기기1 {

  static int cnt;

  public void dfs(PipePos pipePos, int[][] map) {
    int currHeadR = pipePos.headR;
    int currHeadC = pipePos.headC;

    if (currHeadR == map.length-1 && currHeadC == map[0].length-1){
      cnt++;
      return;
    }

    // 맵 밖으로 벗어나는지 체크
    if (currHeadR < 0 || currHeadR >= map.length || currHeadC < 0 || currHeadC >= map[0].length){
      return;
    }

    // 벽으로 가는지 체크
    if (map[currHeadR][currHeadC] == 1){
      return;
    }

    printMapAndPipe(map, pipePos);

    String currPattern = getCurrPattern(pipePos);
    System.out.println(currPattern);
    if (currPattern.equals("horizontal")){
      // 오른쪽으로 이동
      dfs(new PipePos(currHeadR,currHeadC+1, currHeadR, currHeadC), map);

      // 대각선으로 이동
      dfs(new PipePos(currHeadR+1,currHeadC+1, currHeadR, currHeadC), map);

    } else if (currPattern.equals("vertical")) {
      // 아래로 이동
      dfs(new PipePos(currHeadR+1,currHeadC, currHeadR, currHeadC), map);

      // 대각선으로 이동
      dfs(new PipePos(currHeadR+1,currHeadC+1, currHeadR, currHeadC), map);

    } else {
      // 오른쪽으로 이동
      dfs(new PipePos(currHeadR,currHeadC+1, currHeadR, currHeadC), map);

      // 아래로 이동
      dfs(new PipePos(currHeadR+1,currHeadC, currHeadR, currHeadC), map);

      // 대각선으로 이동
      dfs(new PipePos(currHeadR+1,currHeadC+1, currHeadR, currHeadC), map);
    }
  }

  private String getCurrPattern(PipePos pipePos) {
    if (pipePos.headR == pipePos.tailR){
      return "horizontal";
    } else if (pipePos.headC == pipePos.tailC) {
      return "vertical";
    } else {
      return "diagonal";
    }
  }

  public void solution(int N, int[][] map) {
    System.out.println(N);
    System.out.println(Arrays.deepToString(map));
    dfs(new PipePos(0,1,0,0), map);
  }

  public static void main(String[] args) throws IOException {
    파이프옮기기1 T = new 파이프옮기기1();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] list = new int[N][2];
    for (int i=0;i<N;i++){
      list[i] = input2Array(br.readLine());
    }
    T.solution(N, list);
  }

  private void printMapAndPipe(int[][] map, PipePos pipePos){
    int[][] mapPrint = new int[map.length][map[0].length];
    for (int i = 0; i < map.length; i++) {
      System.arraycopy(map[i], 0, mapPrint[i], 0, map[i].length);
    }

    mapPrint[pipePos.headR][pipePos.headC] = 8;
    mapPrint[pipePos.tailR][pipePos.tailC] = 8;

    for (int[] row : mapPrint) {
      System.out.println(Arrays.toString(row));
    }
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

  static class PipePos {
    int headR;
    int headC;
    int tailR;
    int tailC;

    public PipePos(int headR, int headC, int tailR, int tailC){
      this.headR = headR;
      this.headC = headC;
      this.tailR = tailR;
      this.tailC = tailC;
    }
  }
}
