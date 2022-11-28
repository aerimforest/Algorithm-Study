import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, ans;
    static int[] size, value;

    static void input() throws IOException {
        size = new int[3];
        value = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) size[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) value[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        ans = 0;
        for(int i = 0; i <= Math.min(size[0],size[1]); i++){
            for(int j = 0; j <= Math.min(size[1] - i, size[2]); j++){
                int num = Math.min(size[0] - i, size[2] - j);
                ans = Math.max(ans, value[0] * i + value[1] * j + value[2] * num);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            input();
            pro();
        }
    }
}
