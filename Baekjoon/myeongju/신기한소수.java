import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        comb(0,0);
        System.out.println(sb);
    }

    public static void comb(int n, int cnt) {
        if(cnt==N) {
            sb.append(n+"\n");
            return;
        }

        n *= 10;
        for (int i = 1; i <= 9; i++) {
            if(isPrime(n+i))
                comb(n+i, cnt+1);
        }
    }

    public static boolean isPrime(int n) {
        if(n == 1) return false;

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
