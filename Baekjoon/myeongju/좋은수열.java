import java.io.*;
import java.util.*;

/*
    좋은수열
    골드 4
    시간 : ms
    메모리 : kb 메모리 초과가 난다 ㅠㅠ
*/

public class Main {

    static int N;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        backtracking("");

    }

    private static void backtracking(String s) {

        if (s.length() == N) {
            if (flag == false) {
                System.out.println(s);
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (isPossible(s + i)&&!flag) {
                backtracking(s + i);
            }
        }
    }

    private static boolean isPossible(String s) {

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.substring(s.length() - i * 2, s.length() - i).equals(s.substring(s.length() - i, s.length())))
                return false;
        }

        return true;
    }
}