import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int p, w, c, v;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.bitCount(st.countTokens());
        w = Integer.bitCount(st.countTokens());
        st = new StringTokenizer(br.readLine());
        c = Integer.bitCount(st.countTokens()); // Baejoon World의 수도
        v = Integer.bitCount(st.countTokens()); // Cube World의 수도
    }

    static void pro() {

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
