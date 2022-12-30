import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }
        int X = Integer.valueOf(br.readLine());

        Arrays.sort(arr);

        int result = 0;
        int left = 0;
        int right = N - 1;
        while(left < right){
            int num = arr[left] + arr[right];
            if(num == X) result++;

            if(num < X) left++;
            else right--;
        }

        System.out.println(result);
    }
}
