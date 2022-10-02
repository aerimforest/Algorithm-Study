package Baekjoon.jaehyung;

/**
 * 숨바꼭질4 [골드 4] (성공)
 * https://www.acmicpc.net/problem/13913
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질4 {

  static int[] previousPosition = new int[100001];
  static int[] time = new int[100001];

  private void searchSisBfs(int N, int K){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(N);

    while(!queue.isEmpty()) {
      int currPos = queue.poll();

      if (currPos == K){
        return;
      }

      for (int i=0; i<3; i++) {
        int nextPos;
        if (i==0){
          nextPos = currPos + 1;
        } else if (i == 1) {
          nextPos = currPos - 1;
        } else {
          nextPos = currPos*2;
        }

        if (nextPos < 0 || nextPos > 100000){
          continue;
        }

        if (time[nextPos] == 0) {
          queue.add(nextPos);
          time[nextPos] = time[currPos] + 1;
          previousPosition[nextPos] = currPos;
        }
      }
    }
  }

  public void solution(int N, int K) {
    searchSisBfs(N, K);
    System.out.println(time[K]);

    Stack<Integer> stack = new Stack<>();
    while (K != N) {
      stack.push(K);
      K = previousPosition[K];
    }
    stack.push(N);

    while (!stack.isEmpty()){
      if (stack.size() == 1){
        System.out.println(stack.pop());
      } else {
        System.out.print(stack.pop() + " ");
      }
    }
  }

  public static void main(String[] args) throws IOException {
    숨바꼭질4 T = new 숨바꼭질4();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());
    T.solution(input[0], input[1]);
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
