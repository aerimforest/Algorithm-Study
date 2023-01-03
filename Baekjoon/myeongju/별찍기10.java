import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(map[i], ' ');
        func(0, 0, N);
        for (int i = 0; i < N; i++)
            sb.append(map[i]).append("\n");

        System.out.print(sb);
    }

    public static void func(int r, int c, int n) {
        if (n == 1) {
            map[r][c] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1))
                    func(r + i * (n / 3), c + j * (n / 3), n / 3);
            }
        }
    }
}