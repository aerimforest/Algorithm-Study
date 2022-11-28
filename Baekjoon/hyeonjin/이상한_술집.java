import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int result = 0;

        if(K == 1){
            result = arr[0];
        }
        else {
            int min = 1;
            while (min <= max) {
                int mid = (min + max) / 2;
                int count = 0;
                for (int i = 0; i < N; i++) {
                    count += arr[i] / mid;
                }

                if (count >= K) {
                    result = mid;
                    min = mid + 1;
                } else if (count < K) {
                    max = mid - 1;
                }
            }
        }
        System.out.println(result);

    }
}
