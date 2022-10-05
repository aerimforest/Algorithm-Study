package Baekjoon.jaehyung;

/**
 * 스타트택시 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/19238
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트택시 {

  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  static int fuel;
  static int[][] map;

  public void findNearestPerson(int r, int c) {
    int[][] visited = new int[map.length][map.length];
    int[][] distance = new int[map.length][map.length];

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {r, c});


    visited[r][c] = 0;

    while(!q.isEmpty()) {
      int[] currPos = q.poll();
      int currR = currPos[0];
      int currC = currPos[1];

      for (int i=0; i<4; i++) {
        int newR = currR + dr[i];
        int newC = currC + dc[i];

        // 맵을 벗어나지 않도록 체크
        if (newR < 0 || newR >= visited.length || newC < 0 || newC >= visited[0].length) {
          continue;
        }

        // 이미 간곳은 다시 가지 않도록 체크
        if (visited[newR][newC] == 1){
          continue;
        }

        // 벽으로 가지 않도록 체크
        if (map[newR][newC] == 1) {
          continue;
        }

        distance[newR][newC] = distance[currR][currC] + 1;
        q.add(new int[] {newR, newC});
      }
    }
    printMap(distance);
  }

  public void solution(int N) {
    for (int r=0; r<N; r++){
      for (int c=0; c<N; c++){
        if (map[r][c] == -1) {
          map[r][c] = 0;
          findNearestPerson(r, c);
        }
      }
    }

    System.out.println(N);
    printMap(map);
  }

  private void printMap(int[][] map) {
    for (int[] row : map){
      System.out.println(Arrays.toString(row));
    }
  }

  public static void main(String[] args) throws IOException {
    스타트택시 T = new 스타트택시();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int M = input[1];
    fuel = input[2];
    map = new int[N][N];
    for (int i=0; i<N; i++){
      map[i] = input2Array(br.readLine());
    }
    int[] taxi = input2Array(br.readLine());
    map[taxi[0]-1][taxi[1]-1] = -1;

    for (int i=0; i<M; i++){
      int personNum = i + 1;
      int[] departGoal = input2Array(br.readLine());
      map[departGoal[0]-1][departGoal[1]-1] = personNum;
      map[departGoal[2]-1][departGoal[3]-1] = personNum + 1000;
    }

    T.solution(N);
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
