import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static long G;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Long.parseLong(br.readLine());

        // L: 기억하고 있던 몸무게
        // R: 현재 몸무게
        long R = 0;
        for (long L = 1; L < 100001; L++) {

            // 가능한 한 R을 오른쪽으로 이동
            while(R + 1 < 100001 && (R*R - L*L) < G) {
                R++;
            }

            //정답 갱신
            if ((R*R - L*L) == G) sb.append(R).append('\n');
        }
        System.out.println(sb.length() > 0 ? sb.toString() : -1);
    }
}
