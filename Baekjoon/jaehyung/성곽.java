package Baekjoon.jaehyung;

/**
 * 성곽 [골드 4] (성공)
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
  static int tmpRoomSize = 0;
  static int[] dr = new int[] {-1, 0, 1, 0};
  static int[] dc = new int[] {0, -1, 0, 1};

  private void searchIsland(int r, int c, Room[][] roomMap){
    if (r < 0 || r > roomMap.length - 1 || c < 0 || c > roomMap[0].length - 1){
      return;
    }

    if (visited[r][c] == 1) {
      return;
    }

    visited[r][c] = 1;
    tmpRoomSize++;

    for (int i=0; i<4; i++){
      if (roomMap[r][c].up && i == 0){
        continue;
      } else if (roomMap[r][c].left && i == 1) {
        continue;
      } else if (roomMap[r][c].down && i == 2) {
        continue;
      } else if (roomMap[r][c].right && i == 3) {
        continue;
      }
      searchIsland(r + dr[i], c + dc[i], roomMap);
    }
  }

  public void solution(int R, int C, int[][] map) {
//    System.out.println(Arrays.deepToString(map));
    Room[][] roomMap = new Room[R][C];
    for (int r=0; r<R; r++){
      for (int c=0; c<C; c++){
        roomMap[r][c] = new Room(map[r][c]);
      }
    }

    int roomCnt = 0;
    int largestRoomSize = 0;
    int largestRoomSizeAfterRemoveWall = 0;

    for (int r=0; r<R; r++){
      for (int c=0; c<C; c++){
        if (visited[r][c] == 0){
          searchIsland(r,c,roomMap);
          largestRoomSize= Math.max(largestRoomSize, tmpRoomSize);
          tmpRoomSize = 0;
          roomCnt++;
        }
      }
    }

    visited = new int[R][C];

    for (int r=0; r<R; r++){
      for (int c=0; c<C; c++){
        int currWall = roomMap[r][c].wall;
        for (int i=0; i<4; i++){
          if (i==0){
            if (!roomMap[r][c].up){
              continue;
            } else {
              roomMap[r][c].up = false;
            }
          } else if (i==1){
            if (!roomMap[r][c].left){
              continue;
            } else {
              roomMap[r][c].left = false;
            }
          } else if (i==2){
            if (!roomMap[r][c].down){
              continue;
            } else {
              roomMap[r][c].down = false;
            }
          } else if (i==3){
            if (!roomMap[r][c].right){
              continue;
            } else {
              roomMap[r][c].right = false;
            }
          }

          searchIsland(r,c,roomMap);
          largestRoomSizeAfterRemoveWall= Math.max(largestRoomSizeAfterRemoveWall, tmpRoomSize);
          tmpRoomSize = 0;
          roomMap[r][c] = new Room(currWall);
          visited = new int[R][C];
        }
      }
    }

    System.out.println(roomCnt);
    System.out.println(largestRoomSize);
    System.out.println(largestRoomSizeAfterRemoveWall);
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
  int wall;
  boolean up;
  boolean left;
  boolean down;
  boolean right;

  public Room(int wall){
    this.wall = wall;
    this.left = (wall & 1) != 0;
    this.up = (wall & 2) != 0;
    this.right = (wall & 4) != 0;
    this.down = (wall & 8) != 0;
//    System.out.println(this.up + ", " + this.left + ", " + this.down + ", " + this.right);
  }
}