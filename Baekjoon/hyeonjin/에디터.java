import java.io.*;
import java.util.*;

public class 에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            left.push(s.charAt(i));
        }

        int M = Integer.valueOf(br.readLine());

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());

            switch (str.nextToken()){
                case "L":
                    if(left.isEmpty()) break;
                    right.push(left.pop());
                    break;

                case "D":
                    if(right.isEmpty()) break;
                    left.push(right.pop());
                    break;
                case "B":
                    if(left.isEmpty()) break;
                    left.pop();
                    break;
                case "P":
                    left.push(str.nextToken().charAt(0));
                    break;
            }
        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }

        StringBuffer sb = new StringBuffer();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb.toString());
    }
}
