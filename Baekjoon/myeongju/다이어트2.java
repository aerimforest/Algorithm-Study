import java.util.*;
import java.io.*;

/*
1484 다이어트
g <= 100_000
g = a^2 - b^2
a를 구하라
 */
public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long s = 1;
        long e = 2;
        boolean flag = false;

        while (e < 100_000) {
            long ps = s * s;
            long pe = e * e;

            if (pe - ps == n) {
                sb.append(e).append("\n");
                flag = true;
            }

            if (pe - ps > n) {
                s++;
            } else {
                e++;
            }
        }

        if (!flag) {
            System.out.println(-1);
        } else System.out.println(sb);
    }
}