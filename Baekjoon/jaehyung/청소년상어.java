package Baekjoon.jaehyung;

/**
 * 청소년상어 [골드 2] (미성공)
 * https://www.acmicpc.net/problem/19236
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 청소년상어 {

  static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

  // 1번 ~ 16번까지 순차적으로 모든 물고기를 이동시킨다
  private void moveFish(Fish[][] fishMap) {
    Loop1:
    for (int num=1; num<=16; num++){
      for (int r=0; r<4; r++){
        for (int c=0; c<4; c++){

          if (fishMap[r][c].fishNum == num){
            int changeDirectionCnt = 0;
            int newR, newC;

            // 현재 물고기의 방향 정하기
            while(true){
              // 모든 방향이 이동불가하면 이동하지 않는다
              if (changeDirectionCnt > 7) {
                printMap("물고기" + num + " 이동하지 않음", fishMap);
                continue Loop1;
              }

              newR = r + dr[fishMap[r][c].direction];
              newC = c + dc[fishMap[r][c].direction];
              // 맵 바깥으로 벗어나거나, 가리키는 방향에 상어가 있는 경우 반시계 45도 회전
              if (newR < 0 || newR > 3 || newC < 0 || newC > 3 || fishMap[newR][newC].fishNum == -1) {
                fishMap[r][c].direction++;
                fishMap[r][c].direction %= 8;
                changeDirectionCnt++;
                continue;
              }
              break; // 가는 방향이 정해지면 while 탈출
            }

            // 가는 방향에 있는 물고기랑 위치 Swap
            swapFish(r, c, newR, newC, fishMap);
            continue Loop1;
          }

        }
      }
    }
  }

  static List<Fish[][]> fishMapCloneList = new ArrayList<>();

  private void moveFishThenShark(int L, Fish[][] fishMap) {
    moveFish(fishMap);
    fishMapCloneList.add(cloneFishMap(fishMap));
    printMap("깊이: " + L + ", 복사된 맵", fishMapCloneList.get(L));

    for (int r=0; r<4; r++){
      for (int c=0; c<4; c++){

        if (fishMap[r][c].fishNum == -1){
          int newR = r;
          int newC = c;

          for (int i=1; i<=3; i++){
            printSaveMap();
//            fishMap = cloneFishMap(fishMapCloneList[L]);
            printMap("깊이: " + L + ", 루프 " + i + " 복사된 맵 불러오기", fishMapCloneList.get(L));

            System.out.println("깊이: " + L + ", 루프 " + i + " 시작");
            printMap("모든 물고기 이동", fishMap);
            newR += dr[fishMap[r][c].direction];
            newC += dc[fishMap[r][c].direction];
            if (newR < 0 || newR > 3 || newC < 0 || newC > 3) {
              fishMap[r][c] = new Fish(0,0);
              printMap("상어 바깥으로 나감", fishMap);
              System.out.println("깊이: " + L + ", 루프 " + i + " 끝");
              break;
            }

            // 상어가 물고기 먹으러 이동
            eatFish(r, c, newR, newC, fishMap);
            printMap("상어 (" + newR + "," + newC + ") 으로 이동", fishMap);

            // 반복
            moveFishThenShark(L+1, fishMap);
            System.out.println("깊이: " + L + ", 루프 " + i + " 끝");
          }
          return;
        }

      }
    }
  }

  private void printSaveMap(){
    System.out.println("===== 저장된 맵 시작 ====");
    for (int i=0; i<fishMapCloneList.size(); i++){
      printMap("L: " + i, fishMapCloneList.get(i));
    }
    System.out.println("===== 저장된 맵 끝 ====");
  }

  private void swapFish(int r, int c, int newR, int newC, Fish[][] fishMap){
    Fish currFish = fishMap[r][c];
    fishMap[r][c] = fishMap[newR][newC];
    fishMap[newR][newC] = currFish;
  }

  private void eatFish(int r, int c, int newR, int newC, Fish[][] fishMap){
    fishMap[newR][newC].fishNum = -1;
    fishMap[r][c] = new Fish(0,0);
  }

  private Fish[][] cloneFishMap(Fish[][] fishMap) {
    Fish[][] fishMapClone = new Fish[4][4];
    for (int x=0; x<4; x++){
      fishMapClone[x] = fishMap[x].clone();
    }
    return fishMapClone;
  }

  public void solution(Fish[][] fishMap) {
    printMap("초기 맵", fishMap);

    // (0,0)에 상어 투입
    fishMap[0][0].fishNum = -1;
    printMap("첫 상어투입", fishMap);

    moveFishThenShark(0, fishMap);
  }

  private void printMap(String msg, Fish[][] fishMap){
    System.out.println(msg);
    for (Fish[] fishArr : fishMap){
      System.out.println(Arrays.toString(fishArr));
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    청소년상어 T = new 청소년상어();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Fish[][] fishMap = new Fish[4][4];
    for (int i=0; i<4; i++) {
      int[] arr = input2Array(br.readLine());
      fishMap[i][0] = new Fish(arr[0], arr[1] - 1);
      fishMap[i][1] = new Fish(arr[2], arr[3] - 1);
      fishMap[i][2] = new Fish(arr[4], arr[5] - 1);
      fishMap[i][3] = new Fish(arr[6], arr[7] - 1);
    }
    T.solution(fishMap);
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

class Fish {
  int fishNum;
  int direction;

  public Fish(int fishNum, int direction){
    this.fishNum = fishNum;
    this.direction = direction;
  }

  @Override
  public String toString(){
    return "(" + fishNum + ", " + direction + ")";
  }
}
