import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] x = new long[N+1];
        long [] y = new long[N+1];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];
        long sum_a = 0 ;
        long sum_b = 0 ;
        for(int i=0;i<N;i++){
            sum_a += (x[i]*y[i+1]);
            sum_b += (y[i]*x[i+1]);
        }
        System.out.printf("%.1f", 1d*Math.abs(sum_a - sum_b)/2);
    }
}
