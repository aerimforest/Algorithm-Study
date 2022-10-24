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

    if (currHeadR == map.length-1 && currHeadC == map.length-1){
      cnt++;
      return;
    }

//    printMapAndPipe(map, pipePos);

    String currPattern = getCurrPattern(pipePos);
    if (currPattern.equals("horizontal")){
      goRight(pipePos, map);
    } else if (currPattern.equals("vertical")) {
      goDown(pipePos, map);
    } else {
      goRight(pipePos, map);
      goDown(pipePos, map);
    }
    goDiagonal(pipePos, map);
  }

  private void goRight(PipePos pipePos, int[][] map){
    int nextHeadR = pipePos.headR;
    int nextHeadC = pipePos.headC + 1;

    if (isOut(nextHeadR, nextHeadC, map.length)){
      return;
    }

    if (map[nextHeadR][nextHeadC] == 1){
      return;
    }
    dfs(new PipePos(nextHeadR,nextHeadC, pipePos.headR, pipePos.headC), map);
  }

  private void goDown(PipePos pipePos, int[][] map){
    int nextHeadR = pipePos.headR + 1;
    int nextHeadC = pipePos.headC;

    if (isOut(nextHeadR, nextHeadC, map.length)){
      return;
    }

    if (map[nextHeadR][nextHeadC] == 1){
      return;
    }
    dfs(new PipePos(nextHeadR,nextHeadC, pipePos.headR, pipePos.headC), map);
  }

  private void goDiagonal(PipePos pipePos, int[][] map){
    int nextHeadR = pipePos.headR + 1;
    int nextHeadC = pipePos.headC + 1;

    if (isOut(nextHeadR, nextHeadC, map.length)){
      return;
    }

    if (map[nextHeadR][nextHeadC] == 1 || map[nextHeadR][nextHeadC-1] == 1 || map[nextHeadR-1][nextHeadC] == 1){
      return;
    }
    dfs(new PipePos(nextHeadR,nextHeadC, pipePos.headR, pipePos.headC), map);
  }

  private boolean isOut(int r, int c, int N) {
    return r < 0 || r >= N || c < 0 || c >= N;
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
    dfs(new PipePos(0,1,0,0), map);
    System.out.println(cnt);
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
    System.out.println();
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
