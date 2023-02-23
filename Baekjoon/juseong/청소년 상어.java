import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new int[4][8];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
