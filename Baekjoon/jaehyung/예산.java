package Baekjoon.jaehyung;

/**
 * 예산 [실버 3] (성공)
 * https://www.acmicpc.net/problem/2512
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {

  public void solution(int[] countryList, int total) {
    Arrays.sort(countryList);

    int start = 1;
    int end = countryList[countryList.length-1];
    int result = 0;

    while (start <= end){
      int mid = (end+start)/2;

      int sum = 0;
      for (int country : countryList) {
        sum += Math.min(country, mid);
      }

      if (sum == total){
        result = Math.max(result, mid);
        break;
      } else if (sum > total){
        end = mid-1;
      } else {
        start = mid+1;
        result = Math.max(result, mid);
      }
    }
    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    예산 T = new 예산();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] countryList = input2Array(br.readLine());
    int total = Integer.parseInt(br.readLine());
    T.solution(countryList, total);
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
