package Programmers.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class 구명보트 {

  public int solution(int[] people, int limit) {
    Integer[] limitList = Arrays.stream(people).boxed().toArray(Integer[]::new);
    Arrays.sort(limitList, Collections.reverseOrder());
    System.out.println(Arrays.toString(limitList));



    return 0;
  }

  public static void main(String[] args) throws IOException {
    구명보트 T = new 구명보트();

    Input[] inputList = new Input[]{
            new Input(new int[] {70, 50, 80, 50}, 100, 3),
            new Input(new int[] {70, 80, 50}, 100, 3)
    };

    for (Input input : inputList) {
      int answer = T.solution(input.list, input.limit);
      System.out.println(answer == input.answer? "성공" : "실패");
      System.out.println();
    }
  }

  static class Input{
    int[] list;
    int limit;
    int answer;

    public Input(int[] list, int limit, int answer){
      this.list = list;
      this.limit = limit;
      this.answer = answer;
    }
  }
}

