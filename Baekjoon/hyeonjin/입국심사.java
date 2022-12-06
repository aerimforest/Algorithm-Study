import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());

        int[] time = new int[N];
        long max = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            time[i] = Integer.valueOf(br.readLine());
            max = Math.max(max, time[i]);
        }

        long left = 0;
        long right = max * M;

        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;

            for(int t : time){
                sum += mid / t;
            }

            if(sum >= M){
                min = Math.min(min, mid);
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        System.out.println(min);
    }
}
