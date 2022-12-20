import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (s.charAt(i+1) == ')') { // 레이저 이면
                    i++;
                    ans += stack.size();
                    //자르기
                } else { // 쇠 막대기 이면
                    stack.add(c);
                    ans++;
                }
            } else { // 쇠막대가 끝났으면
                stack.pop();
            }
        }
        System.out.println(ans);
    }
}
