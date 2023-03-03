import java.io.*;
import java.util.*;

public class 수리공_항승 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int L = Integer.valueOf(str.nextToken());

        int max = 0;
        int[] arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
            max = Math.max(arr[i], max);
        }
        Arrays.sort(arr);

        boolean[] check = new boolean[max + 1];

        int result = 0;
        for(int i = 0; i < N; i++){
            int num = arr[i];

            if(check[num]) continue;

            result++;
            for(int j = 0; j < L; j++){
                if(j + num > max) break;

                check[j + num] = true;
            }
        }

        System.out.println(result);
    }
}
