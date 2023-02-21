import java.io.*;
import java.util.*;

public class 좋다 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;
        int N = Integer.valueOf(br.readLine());
        str = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int left = 0;
            int right = N - 1;

            while(true){
                if(left == i) left++;
                else if(right == i) right--;

                if(left >= right) break;

                int num = arr[left] + arr[right];
                if(num > arr[i]) right--;
                else if(num < arr[i]) left++;
                else{
                    cnt++;
                    break;
                }

            }
        }

        System.out.println(cnt);
    }
}
