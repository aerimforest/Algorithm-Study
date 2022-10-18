package Baekjoon.jaehyung;

/**
 * 네트워크연결 [골드 4] (미성공)
 * https://www.acmicpc.net/problem/1922
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 네트워크연결 {

  static int[] parent;

  private void union(int x, int y) {
    x = find(x);
    y = find(y);
    if(x != y)
      parent[y] = x;
  }

  private int find(int x) {
    if(parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }
  private boolean isSameParent(int x, int y) {
    x = find(x);
    y = find(y);
    return x == y;
  }

  public void solution(int N, int[][] list) {

    List<Edge> edgeList = new ArrayList<>();
    for (int[] edgeInput : list){
      edgeList.add(new Edge(edgeInput[0],edgeInput[1],edgeInput[2]));
    }

    parent = new int[N+1];
    for(int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    Collections.sort(edgeList);

    int sum = 0;
    for(int i = 0; i < edgeList.size(); i++) {
      Edge edge = edgeList.get(i);
      if (!isSameParent(edge.n1, edge.n2)) {
        sum += edge.cost;
        union(edge.n1, edge.n2);
      }
    }


    System.out.println(sum);
  }

  public static void main(String[] args) throws IOException {
    네트워크연결 T = new 네트워크연결();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[][] list = new int[M][3];
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

  static class Edge implements Comparable<Edge>{
    int n1;
    int n2;
    int cost;

    Edge(int n1, int n2, int cost){
      this.n1 = n1;
      this.n2 = n2;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
      return Integer.compare(this.cost, e.cost);
    }
  }
}
