package baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 백준(12904) - A와 B(https://www.acmicpc.net/problem/12904)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String S = reader.readLine();
        //T를 사용해 연산
        StringBuilder T = new StringBuilder(reader.readLine());

        //A 제거
        //B 제거 후 뒤집기
        int sLength = S.length();
        int tLength = T.length();

        while (sLength < tLength--) {
            if (T.charAt(tLength) == 'B') {
                T.deleteCharAt(tLength);
                T.reverse();
            } else {
                T.deleteCharAt(tLength);
            }
        }

        System.out.println(S.equals(T.toString()) ? 1 : 0);
    }
}
