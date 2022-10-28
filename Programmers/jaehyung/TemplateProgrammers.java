package Programmers.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class TemplateProgrammers {

  public int solution(int[] list, int n) {
    System.out.println(n);
    System.out.println(Arrays.toString(list));
    return 0;
  }

  public static void main(String[] args) throws IOException {
    TemplateProgrammers T = new TemplateProgrammers();

    Input[] inputList = new Input[]{
            new Input(new int[] {70, 50, 80, 50}, 100, 3),
            new Input(new int[] {70, 80, 50}, 100, 3)
    };

    for (Input input : inputList) {
      int answer = T.solution(input.list, input.n);
      System.out.println(answer == input.answer? "성공" : "실패");
      System.out.println();
    }
  }

  static class Input{
    // input
    int[] list;
    int n;

    // 정답
    int answer;

    public Input(int[] list, int n, int answer){
      this.list = list;
      this.n = n;
      this.answer = answer;
    }
  }
}

