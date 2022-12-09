import java.util.*;
import java.io.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int maxR, maxC, minR, minC;
    static int r, c, d;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String s = br.readLine();
            d = r = c = maxR = maxC = minR = minC = 0;

            for (char order : s.toCharArray()) {
                if (order == 'F') {
                    r += dr[d];
                    c += dc[d];
                    maxR = Math.max(maxR, r);
                    minR = Math.min(minR, r);
                    maxC = Math.max(maxC, c);
                    minC = Math.min(minC, c);
                } else if (order == 'B') {
                    r -= dr[d];
                    c -= dc[d];
                    maxR = Math.max(maxR, r);
                    minR = Math.min(minR, r);
                    maxC = Math.max(maxC, c);
                    minC = Math.min(minC, c);
                } else if (order == 'L') {
                    d = (d == 0 ? 3 : d - 1);
                } else if (order == 'R') {
                    d = (d == 3 ? 0 : d + 1);
                }
            }

            sb.append((maxR - minR) * (maxC - minC) + "\n");
        }

        System.out.println(sb);
    }
}