package Baekjoon.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/1595
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 북쪽나라의도로 {

  static List<Node>[] list;
  static boolean[] check;
  static long max = -1;
  static int idx;

  static void dfs(int here, long cost) {
    for(Node nxt : list[here]) {
      if(check[nxt.to]) continue;
      long nxtVal = cost + nxt.value;
      check[nxt.to] = true;
      if(max < nxtVal) {
        idx = nxt.to;
        max = nxtVal;
      }
      dfs(nxt.to, nxtVal);
    }
  }

  public void solution() {
    check = new boolean[10001];
    check[1] = true;
    dfs(1,0);

    Arrays.fill(check, false);
    check[idx] = true;
    max = -1;
    dfs(idx,0);
    System.out.println(max);
  }

  public static void main(String[] args) throws IOException {
    북쪽나라의도로 T = new 북쪽나라의도로();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int f = -1;
    list = new ArrayList[10001];
    for(int i=0; i<10001; i++) {
      list[i] = new ArrayList<>();
    }

    String input;
    while(!(input = br.readLine()).isEmpty()) {
      int[] input2 = input2Array(input);
      f = input2[0];
      list[input2[0]].add(new Node(input2[1], input2[2]));
      list[input2[1]].add(new Node(input2[0], input2[2]));
    }

    if(f == -1) {
      System.out.println(0);
      return;
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

  static class Node{
    int to;
    int value;

    public Node(int to, int value) {
      this.to = to;
      this.value = value;
    }

    @Override
    public String toString(){
      return "(to: " + to + ", value: " + value + ")";
    }
  }
}
