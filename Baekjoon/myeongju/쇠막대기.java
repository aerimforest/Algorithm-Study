import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') stack.push(c);
            else {
                stack.pop();
                if (s.charAt(i - 1) == '(')
                    answer += stack.size();
                else answer++;
            }
        }

        System.out.print(answer);
    }
}