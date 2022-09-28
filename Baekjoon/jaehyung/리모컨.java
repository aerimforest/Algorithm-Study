package Baekjoon.jaehyung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 리모컨 [골드 5] (성공)
 * https://www.acmicpc.net/problem/1107
 */
public class 리모컨 {

  // 고장난 버튼이 포함된 번호인지 확인하는 메소드
  private boolean isForbidden(String numStr, int[] brokenBtnList) {
    for (int brokenBtn : brokenBtnList){
      if (numStr.contains(String.valueOf(brokenBtn))){
        return true;
      }
    }
    return false;
  }

  public void solution(int N, int M, int[] brokenBtnList) {
    // 2. 목표 채널이 100인 경우 어떠한 버튼도 누를 필요가 없기 때문에 이 처리를 해준다
    if (N == 100){
      System.out.println(0);
      return;
    }

    /*
       3. 자릿수별로 숫자 대입을 시도하면 논리상 오류가 생길 수 있으므로, 가능한 모든 경우의 수를 계산한다.
       최대값은 문제에서 500000이라고 되어있으나 리모콘이 9를 제외하고 모두 고장났다면,
       999999를 눌러서 찾는 경우도 포함되어야 하므로 최대값을 999999으로 설정한다.
     */
    int cnt = Integer.MAX_VALUE;
    for (int i=0; i<=999999; i++) {
      String numStr = String.valueOf(i);
      if (isForbidden(numStr, brokenBtnList)){
        continue;
      }
      cnt = Math.min(cnt, Math.abs(i-N) + numStr.length());
    }

    // 4. 숫자 버튼을 누르지않고 100번 채널에서 +/- 버튼만 누르는 경우도 계산한다
    cnt = Math.min(cnt, Math.abs(N-100));

    System.out.println(cnt);
  }

  public static void main(String[] args) throws IOException {
    리모컨 T = new 리모컨();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] brokenBtnList;

    // 1. 고장난 버튼이 없을 경우 아예 배열을 input 으로 주지 않기 때문에 이 처리를 해줘야한다.
    if (M > 0){
      brokenBtnList = input2Array(br.readLine());
    } else {
      brokenBtnList = new int[0];
    }
    T.solution(N, M, brokenBtnList);
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
