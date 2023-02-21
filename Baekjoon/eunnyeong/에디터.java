import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        int n = Integer.parseInt(br.readLine());
        ListIterator<Character> p = list.listIterator();
        while (p.hasNext())
            p.next();

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            int c = tmp.charAt(0);
            if (c == 'L' && p.hasPrevious())
                p.previous();
            if (c == 'D' && p.hasNext())
                p.next();
            if (c == 'P')
                p.add(tmp.charAt(2));
            if (c == 'B' && p.hasPrevious()) {
                p.previous();
                p.remove();
            }
        }

        for(Character chr : list)
            bw.write(chr);
        
        bw.flush(); bw.close(); br.close();
    }
}
