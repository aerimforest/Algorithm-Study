import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[][] A;
    static ArrayList<Virus> viri;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        viri = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                A[i][j] = s.charAt(2*j);
                if (A[i][j] == '2') {
                    viri.add(new Virus(i, j));
                    A[i][j] = '0';
                }
            }
        }
    }

    static class Virus {
        int x,y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
