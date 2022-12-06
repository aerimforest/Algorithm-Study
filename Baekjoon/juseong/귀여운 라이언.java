import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int R = 0;
        int found = 0;
        int ans = Integer.MAX_VALUE;
        int len = 0;
        for (int L = 0; L < N; L++) {
            if (L > 0) {
                char c = s.charAt((L-1) * 2);
                if (c == '1') found--;
                len--;
            }
            while(R < N && found < K) {
                R++;
                len++;
                char c = s.charAt((R-1) * 2);
                if (c == '1') found++;
            }
            if (found == K) ans = Math.min(ans, len);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
