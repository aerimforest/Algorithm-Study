import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static String A[];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            A[i] = st.nextToken();
        }
    }

    static void rec_func(int k, int cnt, int flag) {
        if (cnt == L) {
            String[] result = new String[L];
            int r = 0;
            int consonant = 0;
            for (int i = 0; i < C; i++) {
                if ((flag & 1 << i) > 0) {
                    result[r] = A[i];
                    r++;
                    if (A[i].equals("a") || A[i].equals("e") || A[i].equals("i") || A[i].equals("o") || A[i].equals("u")) {
                        consonant++;
                    }
                }
            }
            if (consonant >= 1 && (L - consonant) >= 2) {
                for (String s: result) {
                    sb.append(s);
                }
                sb.append('\n');
            }
            return;
        }
        if (k == C) return;
        rec_func(k + 1, cnt + 1, flag | 1 << k);
        rec_func(k + 1, cnt, flag);
    }

    static void pro() {
        Arrays.sort(A);
        rec_func(0, 0, 0);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
