import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                stack.add('(');
            }
            else{
                stack.pop();

                if(s.charAt(i - 1) == '(') cnt += stack.size();
                else cnt += 1;

            }
        }
        System.out.println(cnt);
    }
}
