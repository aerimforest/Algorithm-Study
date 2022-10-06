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
  static int currFuelConsume = 0;
  static int[] currCustomer;
  static int[][] map;

  public void searchPath(int r, int c, boolean isCustomer) {
    int[][] visited = new int[map.length][map.length];
    int[][] distance = new int[map.length][map.length];

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {r, c});

    map[r][c] = 0;
    visited[r][c] = 1;

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

        if (visited[newR][newC] == 0 && map[newR][newC] != 1){
          visited[newR][newC] = 1;
          distance[newR][newC] = distance[currR][currC] + 1;
          q.add(new int[] {newR, newC});
        }
      }
    }

    int[] target = new int[] {0, 0, Integer.MAX_VALUE};

    for (int r2=0; r2<map.length; r2++){
      for (int c2=0; c2<map.length; c2++){
        if (isCustomer) {
          if (map[r2][c2] > 1 && map[r2][c2] < 1000) {
            if (distance[r2][c2] < target[2]) {
              target = new int[] {r2, c2, distance[r2][c2]};
              currCustomer = new int[] {r2, c2, map[r2][c2]};
            } else if (distance[r2][c2] == target[2]) {
              if (r2 < target[0]){
                target = new int[] {r2, c2, distance[r2][c2]};
                currCustomer = new int[] {r2, c2, map[r2][c2]};
              } else if (r2 == target[0]) {
                if (c2 < target[1]){
                  target = new int[] {r2, c2, distance[r2][c2]};
                  currCustomer = new int[] {r2, c2, map[r2][c2]};
                }
              }
            }
          }
        } else {
          if (map[r2][c2] - 1000 == currCustomer[2]) {
            target = new int[] {r2, c2, distance[r2][c2]};
          }
        }
      }
    }

    map[target[0]][target[1]] = -1;
    fuel -= target[2];
    checkFuel();

    if (!isCustomer) {
      currFuelConsume += target[2];
      fuel += currFuelConsume*2;
      currFuelConsume = 0;
      currCustomer = new int[] {99, 99, 0};
    }

//    printMap("거리 맵", distance);
  }

  private void checkFuel(){
    if (fuel < 0){
      System.out.println(-1);
      System.exit(0);
    }
  }

  private boolean isDeliverFinished(int N){
    for (int r=0; r<N; r++){
      for (int c=0; c<N; c++){
        if (map[r][c] > 1) {
          return false;
        }
      }
    }
    return true;
  }

  public void solution(int N) {
    while(!isDeliverFinished(N)){
      Loop1:
      for (int r=0; r<N; r++){
        for (int c=0; c<N; c++){
          if (map[r][c] == -1) {
//            System.out.println("연료양: " + fuel);
//            printMap("택시 발견", map);

            searchPath(r, c, true);
//            System.out.println("연료양: " + fuel);
//            System.out.println("현재 승객: " + Arrays.toString(currCustomer));
//            printMap("승객 발견", map);

            searchPath(currCustomer[0], currCustomer[1], false);
//            System.out.println("연료양: " + fuel);
//            printMap("목적지 도착", map);
            break Loop1;
          }
        }
      }
    }
    System.out.println(fuel);
  }

  private void printMap(String msg, int[][] map) {
    System.out.println(msg);
    for (int[] row : map){
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
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
      int personNum = i + 2;
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
