import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        BitSet bs = new BitSet();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (!bs.get(num)) {
                bs.set(num);
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);
    }

}