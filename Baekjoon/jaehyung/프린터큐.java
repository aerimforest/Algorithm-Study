package Baekjoon.jaehyung;

/**
 * 프린터 큐 [실버 3] (성공)
 * https://www.acmicpc.net/problem/1966
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐 {

  public void solution(int N, int M, int[] list) {
    Queue<Page> q = new LinkedList<>();
    for (int i=0; i<N; i++) {
      q.add(new Page(list[i], i == M));
    }

    int cnt = 0;
    while (!q.isEmpty()) {
      Page currPage = q.poll();
      if (canPrint(currPage, q)){
        cnt++;
        if (currPage.isChosen){
          break;
        }
      } else {
        q.add(currPage);
      }
    }

    System.out.println(cnt);
  }

  private boolean canPrint(Page targetPage, Queue<Page> q){
    Queue<Page> newQ = new LinkedList<>(q);
    for (Page page : newQ){
      if (page.num > targetPage.num){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    프린터큐 T = new 프린터큐();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCnt = Integer.parseInt(br.readLine());
    for (int i=0;i<testCnt;i++){
      int[] input1 = input2Array(br.readLine());
      int[] list = input2Array(br.readLine());
      T.solution(input1[0], input1[1], list);
    }
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

class Page {
  int num;
  boolean isChosen;

  public Page(int num, boolean isChosen){
    this.num = num;
    this.isChosen = isChosen;
  }
}