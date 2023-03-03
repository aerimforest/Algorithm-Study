import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창고이전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] original = new int[n + 1];
        int idx = 1;

        int x = 0;
        long y = 0;

        for(int i = 1; i <= n; i++) {
            original[i] = Integer.parseInt(br.readLine());
        }

        LOOP:
        for(int i = 1; i <= m; i++) {
            int count = Integer.parseInt(br.readLine());
            while (count-- > 0) {
                while (original[idx] == 0) {
                    if(++idx > n) break LOOP;
                }
                x++;
                y += idx + i;
                original[idx]--;
            }
        }

        System.out.printf("%d %d\n", x, y);
        br.close();
    }
}
