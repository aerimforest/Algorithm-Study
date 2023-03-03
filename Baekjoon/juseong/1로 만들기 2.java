import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] C, prev;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        C = new int[n + 1]; // 해당(k) 번째 수를 만드는데 필요한 최소 연산 수
        prev = new int[n + 1]; // 해당(k) 번째 수를 만드는데 사용한 이전 수
        C[1] = 0; // 1에서 시작
        if (n >= 2) {
            C[2] = 1; // 1 + 1 or 1 * 2
            prev[2] = 1; // 1 + 1 or 1 * 2를 했을 경우 이전 수는 1
        }
        if (n >= 3) {
            C[3] = 1; // 1 * 3
            prev[3] = 1; // 1 * 3 을 했을 경우 이전 수는 1
        }
        for (int x = 4; x <= n; x++){
            //3. 1을 뺀다.
            C[x] = C[x - 1] + 1;
            prev[x] = x - 1;
            if (x % 3 == 0 && C[x] > C[x / 3] + 1) { //1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
                C[x] = C[x / 3] + 1;
                prev[x] = x / 3;
            }
            if (x % 2 == 0 && C[x] > C[x / 2] + 1) { //2. X가 2로 나누어 떨어지면, 2로 나눈다.
                C[x] = C[x / 2] + 1;
                prev[x] = x / 2;
            }
        }
        sb.append(C[n]).append("\n");
        int p = n;
        while (p != 0) {
            sb.append(p).append(" ");
            p = prev[p];
        }
        System.out.println(sb.toString());
    }
}
