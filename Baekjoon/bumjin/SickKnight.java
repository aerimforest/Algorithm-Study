package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SickKnight {

    /**
     * 백준(1783) - 병든 나이트(https://www.acmicpc.net/problem/1783)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        if (n == 1) {
            //이동 불가능
            result = 1;
        } else if (n == 2) {
            //2, 3만 가능
            //가로길이 2당 1칸 방문
            //3번만 움직
            result = Math.min((m + 1) / 2, 4);
        } else {
            if (m < 7) {
                //1, 4만 가능
                result = Math.min(m, 4);
            } else {
                //4방향
                //7칸당 5칸 방문
                result = m - 2;
            }
        }

        System.out.println(result);
    }
}
