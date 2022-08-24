package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Teaching {

    /**
     * 백준(1062) - 가르침(https://www.acmicpc.net/problem/1062)
     */
    private static int N;
    private static int K;
    private static String[] words;
    private static boolean[] alpha = new boolean[26];
    private static List<Character> charList = new ArrayList<>(); //가르칠 수 있는 알파벳
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }

        words = new String[N];

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            words[i] = str.substring(4, str.length() - 4);
        }

        initAlpha();
        setList();

        dfs(0, 0);

        if (charList.size() <= (K - 5)) {
            System.out.println(N);
            return;
        }

        System.out.println(result);
    }

    private static void dfs(int start, int level) {
        if (level == K - 5) {
            int count = 0;
            boolean flag;

            for (int i = 0; i < N; i++) {
                flag = true;
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    if (!alpha[c - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
            result = Math.max(result, count);
        } else {

            for (int i = start; i < charList.size(); i++) {
                char c = charList.get(i);
                alpha[c - 'a'] = true;
                dfs(i + 1, level + 1);
                alpha[c - 'a'] = false;
            }

        }
    }

    private static void setList() {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!alpha[c - 'a']) {
                    set.add(c);
                }
            }
        }

        charList.addAll(set);
    }

    private static void initAlpha() {
        //a
        //n
        //t
        //c
        //i
        alpha[0] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['c' - 'a'] = true;
        alpha['i' - 'a'] = true;
    }
}
