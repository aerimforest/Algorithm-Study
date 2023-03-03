import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ha;
    static int[][] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ha = Integer.parseInt(st.nextToken());
        A = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            A[i][0] = t;
            A[i][1] = a;
            A[i][2] = h;
        }
    }
    
    static void pro() {
        
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
