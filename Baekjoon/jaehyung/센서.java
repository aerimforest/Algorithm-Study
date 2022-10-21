package Baekjoon.jaehyung;

/**
 * 센서 [골드 5] (성공)
 * https://www.acmicpc.net/problem/2212
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 센서 {

  public void solution(int N, int K, int[] list) {
    Arrays.sort(list);
//    System.out.println(Arrays.toString(list));

    List<Integer> diffList = new ArrayList<>();
    for (int i=1; i<list.length; i++) {
      diffList.add(list[i] - list[i-1]);
    }
    diffList.sort(Collections.reverseOrder());
//    System.out.println(diffList);

    int sum = 0;
    for (int i=K-1;i<diffList.size(); i++){
      sum += diffList.get(i);
    }

    System.out.println(sum);
  }

  public static void main(String[] args) throws IOException {
    센서 T = new 센서();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());
    int[] list = input2Array(br.readLine());
    T.solution(N, K, list);
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
