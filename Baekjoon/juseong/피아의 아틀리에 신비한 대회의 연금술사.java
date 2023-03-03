import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] A;
    static char[][] C;
    static int[][][] PA;
    static char[][][] PC;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[5][5];
        C = new char[5][5];
        PA = new int[n][4][4];
        PC = new char[n][4][4];
        for (int t = 0; t < 4; t++) {
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    PA[t][i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 4; i++) {
                String s = br.readLine();
                for (int j = 0, index = 0; j < 4; j++, index += 2) {
                    PA[t][i][j] = s.charAt(index);
                }
            }
        }
        selected = new boolean[n];
        // end of input
        rec_func(0, new int[n]);
    }

    static void rec_func(int index, int[] result) {
        if (index == n) {
            calculation(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            rec_func(index + 1, result);
            selected[i] = false;
        }
    }

    static void calculation(int[] result) {
        for (int i = 0; i < result.length; i++) {
            put(PA[i], PC[i]);
        }
    }

    static void put(int[][] nums, char[][] colors) {

    }
}
