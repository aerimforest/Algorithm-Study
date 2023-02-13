import java.io.*;
import java.util.*;

public class 용액 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int result1 = 0;
        int result2 = 0;
        int left = 0;
        int right = N - 1;
        while(left < right){
            int value = arr[left] + arr[right];

            if(Math.abs(value) < min){
                min = Math.abs(value);
                result1 = arr[left];
                result2 = arr[right];
            }

            if(value < 0) left++;
            else right--;
        }

        bw.write(result1 + " " + result2);
        bw.flush();
        bw.close();
    }
}
