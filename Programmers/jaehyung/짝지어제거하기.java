package Programmers.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.IOException;
import java.util.*;

public class 짝지어제거하기 {

  public int solution(String s) {
    Stack<Character> stack = new Stack();
    for (char c : s.toCharArray()){
      if(!stack.isEmpty() && stack.peek() == c){
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty()? 1: 0;
  }

  public static void main(String[] args) throws IOException {
    짝지어제거하기 T = new 짝지어제거하기();
    Input[] inputList = new Input[]{
            new Input("baabaa", 1),
            new Input("cdcd", 0)
    };
    for (Input input : inputList) {
      int answer = T.solution(input.s);
      System.out.println("입력값: " + input.s);
      System.out.println("답: " + input.answer);
      System.out.println("출력값: " + answer);
      System.out.println(answer == input.answer? "테스트 성공" : "테스트 실패");
      System.out.println();
    }
  }

  static class Input{
    // input
    String s;

    // 정답
    int answer;

    public Input(String s, int answer){
      this.s = s;
      this.answer = answer;
    }
  }
}

