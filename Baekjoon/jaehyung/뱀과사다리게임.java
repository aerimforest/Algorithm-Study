package Baekjoon.jaehyung;

/**
 * 뱀과사다리게임 [골드 5] (성공)
 * https://www.acmicpc.net/problem/16928
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {

  static boolean[] visited = new boolean[101];
  static int[] count = new int[101];
  static int[] ladderAndSnake = new int[101];

  private void bfs(){
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    visited[1] = true;
    count[1] = 0;

    while(!queue.isEmpty()) {
      int curr = queue.poll();

      if (curr == 100){
        System.out.println(count[curr]);
        return;
      }

      for (int i=1; i<=6; i++){
        int next = curr + i;
        if (next > 100) {
          continue;
        }

        if (visited[next]){
          continue;
        }

        visited[next] = true;

        if (ladderAndSnake[next] != 0) {
          int nextDest = ladderAndSnake[next];

          if (!visited[nextDest]) {
            queue.offer(nextDest);
            visited[nextDest] = true;
            count[nextDest] = count[curr] + 1;
          }
        } else {
          queue.offer(next);
          count[next] = count[curr] + 1;
        }
      }
    }
  }

  public void solution() {
    bfs();
  }

  public static void main(String[] args) throws IOException {
    뱀과사다리게임 T = new 뱀과사다리게임();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    int N = input[0];
    int M = input[1];

    for (int i=0; i<N+M; i++){
      int[] snakeLadder = input2Array(br.readLine());
      ladderAndSnake[snakeLadder[0]] = snakeLadder[1];
    }

    T.solution();
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
