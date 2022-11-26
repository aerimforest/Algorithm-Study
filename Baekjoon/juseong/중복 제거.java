import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BitSet b = new BitSet();
        while (st.hasMoreTokens()) {
            int m = Integer.parseInt(st.nextToken());
            if (b.get(m)) continue;
            b.set(m);
            sb.append(m).append(' ');
        }
        System.out.println(sb.toString());
    }
}
