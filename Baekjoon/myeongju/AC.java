import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        outer:
        while (T-- > 0) {
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());

            Deque<String> deque = new ArrayDeque<>();

            String s = br.readLine();
            s = s.substring(1, s.length() - 1);

            if(n==0 && p.contains("D")) {
                sb.append("error\n");
                continue;
            }

            for (String c : s.split(","))
                deque.addLast(c);

            boolean right = true;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    right = !right;
                } else {

                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        continue outer;
                    }

                    if (right)
                        deque.removeFirst();
                    else deque.removeLast();
                }
            }

            sb.append("[");

            while(!deque.isEmpty()) {
                if(right)
                    sb.append(deque.removeFirst());
                else sb.append(deque.removeLast());

                if(!deque.isEmpty()) sb.append(",");
            }

            sb.append("]\n");
        }

        System.out.println(sb);
    }
}