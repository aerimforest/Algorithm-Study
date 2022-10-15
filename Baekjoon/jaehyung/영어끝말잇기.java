package Baekjoon.jaehyung;

/**
 * ㅁㅁㅁㅁ [골드 4] (미성공)
 * https://www.acmicpc.net/problem/0000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 영어끝말잇기 {

  public void solution(int n, String[] words) {
    int[] answer = new int[2];

    Set<String> wordSet = new HashSet<>();
    double failIdx = 0;
    char currEnd = words[0].charAt(0);
    boolean isFail = false;

    for(int i=0; i<words.length; i++) {
      String currWord = words[i];
      char currStart = currWord.charAt(0);
      if (wordSet.contains(currWord) || currEnd != currStart){
        failIdx = i + 1;
        isFail = true;
        break;
      }
      currEnd = currWord.charAt(currWord.length()-1);
      wordSet.add(currWord);
    }

    if (!isFail){
      System.out.println(Arrays.toString(new int[] {0, 0}));
      return;
    }

    System.out.println(failIdx);

    answer[0] = failIdx%n == 0? n : (int) failIdx%n;
    answer[1] = (int) Math.ceil(failIdx/n);

    System.out.println(Arrays.toString(answer));
  }

  public static void main(String[] args) throws IOException {
    영어끝말잇기 T = new 영어끝말잇기();

    Input[] inputList = new Input[]{
            new Input(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}),
            new Input(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}),
            new Input(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"}),
            new Input(6, new String[] {"omm", "moom", "mom", "mom", "mor"}),
            new Input(3, new String[] {"rom", "moom", "rom", "mm", "mm"})
    };

    for (Input input : inputList) {
      T.solution(input.n, input.words);
      System.out.println();
    }
  }
}

class Input{
  int n;
  String[] words;

  public Input(int n, String[] words){
    this.n = n;
    this.words = words;
  }
}