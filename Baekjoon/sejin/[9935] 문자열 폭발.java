import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main {
    static String origin;
    static String bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine();
        bomb = br.readLine();
        
        int oriLen = origin.length();
        int bombLen = bomb.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < oriLen; i++) {
            char c = origin.charAt(i);
            sb.append(c);
            if(sb.length() >= bombLen) {
                boolean isSame = true;
                for(int idx = 0; idx < bombLen; idx++) {
                    char c1 = sb.charAt(sb.length() - bombLen + idx);
                    char c2 = bomb.charAt(idx);
                    if(c1 != c2) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }
        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
