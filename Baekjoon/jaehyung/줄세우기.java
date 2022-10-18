package Baekjoon.jaehyung;

/**
 * 줄세우기 [골드 3] (미성공)
 * https://www.acmicpc.net/problem/2252
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기 {

  public void solution(int N, int[][] list) {

    int[] linked = new int[N+1];

    List<List<Integer>> edgeList = new ArrayList<>();
    for (int i=0; i<N+1; i++) {
      edgeList.add(new ArrayList<>());
    }

    for (int[] edge : list) {
      edgeList.get(edge[0]).add(edge[1]);
      linked[edge[1]] +=1;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i=1; i<linked.length; i++) {
      if (linked[i] == 0){
        queue.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!queue.isEmpty()) {
      Integer currNode = queue.poll();
      sb.append(currNode).append(" ");

      List<Integer> nodeList = edgeList.get(currNode);
      for (Integer node : nodeList) {
        if (--linked[node] == 0){
          queue.add(node);
        }
      }
    }
//    System.out.println(N);
//    System.out.println(Arrays.deepToString(list));
//    System.out.println(edgeList);
    System.out.println(sb.toString());
  }

  public static void main(String[] args) throws IOException {
    줄세우기 T = new 줄세우기();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = input2Array(br.readLine());;
    int N = input[0];
    int M = input[1];
    int[][] list = new int[M][2];
    for (int i=0;i<M;i++){
      list[i] = input2Array(br.readLine());
    }
    T.solution(N, list);
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
