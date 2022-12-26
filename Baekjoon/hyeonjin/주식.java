import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.valueOf(br.readLine());
            int[] arr = new int[N];
            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.valueOf(str.nextToken());
            }

            long result = 0;
            long max = 0;
            for(int i = N - 1; i >=0; i--){
                if(arr[i] > max) max = arr[i];
                else result += max - arr[i];
            }

            System.out.println(result);
        }
    }
}
