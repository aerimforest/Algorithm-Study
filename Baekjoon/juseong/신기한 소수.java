import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        rec_func(0, 0);
        System.out.print(sb.toString());
    }

    static void rec_func(int num, int cnt) {
        if (cnt == n) {
            sb.append(num).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            int p = num * 10 + i;
            if(isPrime(p)) {
                rec_func(p, cnt + 1);
            }
        }
    }

    static boolean isPrime(int num) {
       if (num == 1) return false;
       int sqrt = (int)Math.sqrt(num); // 제곱근 까지만 탐색해도 소수인지 판별할 수 있다
       for (int i = 2; i <= sqrt; i++) {
           if (num % i == 0) return false;
       }
       return true;
    }
}
