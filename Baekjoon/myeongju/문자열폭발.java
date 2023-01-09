import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    char c1 = sb.charAt(sb.length() - bomb.length() + j);
                    char c2 = bomb.charAt(j);
                    if (c1 != c2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) sb.delete(sb.length() - bomb.length(), sb.length());
            }
        }
        if (sb.length() == 0) System.out.print("FRULA");
        else System.out.print(sb);
    }
}
