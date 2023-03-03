import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if(n <= k) {
        System.out.print(0);
        return;
        }
        
        for (int i = 0; i < k - 1; i++) {
            int base = 0;
            while (Math.pow(2, base) < n) {
                base++;
            }
            n -= Math.pow(2, base - 1);

            if(n == 0)  {
        System.out.print(0);
        return;
        }
        }

        
        int base = 0;
        while (Math.pow(2, base) < n) {
            base++;
        }
        System.out.print((int) Math.pow(2, base) - n);
        br.close();
    }
}
