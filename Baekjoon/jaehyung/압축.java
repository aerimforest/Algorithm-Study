package Baekjoon.jaehyung;

/**
 * 압축 [골드 5] (미성공)
 * https://www.acmicpc.net/problem/1662
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 압축 {

  public void solution(String compressed) {
    decompress(compressed);
  }

  private void decompress(String compressed) {
    Stack<Character> stack = new Stack<>();
    char[] charArray = compressed.toCharArray();
    for (int i=0; i<charArray.length; i++) {
      if (charArray[i] != ')'){
        stack.push(charArray[i]);
      } else {
        char currChar;
        StringBuilder currSb = new StringBuilder();
        while(!stack.isEmpty()){
          currChar = stack.pop();
          if (currChar == '('){
            break;
          }
          currSb.insert(0, currChar);
//          System.out.println("currChar insert: " + currChar);
        }
        int repeat = Integer.parseInt(String.valueOf(stack.pop()));
//        System.out.println("repeat: " + repeat);
        for (int r=0; r<repeat; r++){
          for (char c : currSb.toString().toCharArray()){
            stack.push(c);
          }
        }
      }
    }
    System.out.println(stack.size());
  }

  public static void main(String[] args) throws IOException {
    압축 T = new 압축();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T.solution(br.readLine());
  }
}
