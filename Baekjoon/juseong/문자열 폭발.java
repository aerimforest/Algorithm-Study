import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String regex = br.readLine();
        int regexSize = regex.length();
        stack = new Stack<>();

        for(int i = 0; i < line.length(); i++) {
            stack.push(line.charAt(i));
            if(stack.size()>= regexSize) {
                boolean flag = true;
                for(int j = 0, index  = stack.size() - regexSize; j < regexSize; j++, index++) {
                    if(stack.get(index) != regex.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0; j<regexSize; j++) stack.pop();
                }
            }

        }
        for (int i = 0; i < stack.size(); i++) sb.append(stack.get(i));
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());

    }
}
