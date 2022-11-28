package Baekjoon.jaehyung;

/**
 * 떡장수와호랑이 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/16432
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 떡장수와호랑이 {

  static int N;
  static int[][] visited;
  static int[] ddukList;

  private void dfs(int depth, List<List<Integer>> map) {

    if (depth == N-1){
      boolean isExist = false;
      List<Integer> currList = map.get(depth);
      for (int i = 0; i < currList.size(); i++) {
        int currDduk = currList.get(i);
        if (ddukList[depth-1] != currDduk){
          ddukList[depth] = currDduk;
          isExist = true;
        }
      }

      if (!isExist){
        System.out.println(-1);
        System.exit(0);
      }

      for (int dduck : ddukList){
        System.out.println(dduck);
      }
      System.exit(0);
    } else {
      List<Integer> currList = map.get(depth);
      for (int i = 0; i < currList.size(); i++) {
        int currDduk = currList.get(i);
        if (visited[depth][currDduk] == 1){
          continue;
        }

        if (depth > 0 && ddukList[depth-1] == currDduk){
          continue;
        }

        ddukList[depth] = currDduk;
        visited[depth][currDduk] = 1;
        dfs(depth + 1, map);
      }
    }
  }

  public void solution(List<List<Integer>> map) {
    dfs(0, map);
    System.out.println(-1);
  }

  public static void main(String[] args) throws IOException {
    떡장수와호랑이 T = new 떡장수와호랑이();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<List<Integer>> map = new ArrayList<>();
    N = Integer.parseInt(br.readLine());
    ddukList = new int[N];
    visited = new int[N][10];
    for (int i=0;i<N;i++){
      int[] list = input2Array(br.readLine());
      List<Integer> row = new ArrayList<>();
      for (int j=1; j<list.length; j++) {
        row.add(list[j]);
      }
      map.add(row);
    }
    T.solution(map);
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
