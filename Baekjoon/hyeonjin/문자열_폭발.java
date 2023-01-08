import java.io.*;
import java.util.*;

public class 문자열_폭발 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        String s = br.readLine();
        String bomb = br.readLine();

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));

            if(sb.length() < bomb.length()) continue;

            if(!sb.substring(sb.length() - bomb.length(), sb.length()).equals(bomb)) continue;

            sb.delete(sb.length() - bomb.length(), sb.length());
        }

        String result;
        if(sb.length() == 0) result = "FRULA";
        else result = sb.toString();

        System.out.println(result);
    }
}
