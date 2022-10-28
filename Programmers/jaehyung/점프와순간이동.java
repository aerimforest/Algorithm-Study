package Programmers.jaehyung;

/**
 * 점프와순간이동 (성공)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

import java.io.IOException;

public class 점프와순간이동 {
  public int solution(int n) {
    int battery = 0;
    while(n>0){
      if (!isEven(n)){
        n -=1;
        battery++;
      }
      n /=2;
    }
    return battery;
  }

  private boolean isEven(int n) {
    return n%2 == 0;
  }

  public static void main(String[] args) throws IOException {
    점프와순간이동 T = new 점프와순간이동();
    Input[] inputList = new Input[]{
            new Input(5, 2),
            new Input(6, 2),
            new Input(5000, 5)
    };

    for (Input input : inputList) {
      int answer = T.solution(input.n);
      System.out.println(answer == input.answer? "성공" : "실패");
      System.out.println();
    }
  }

  static class Input{
    int n;
    int answer;

    public Input(int n, int answer){
      this.n = n;
      this.answer = answer;
    }
  }
}
