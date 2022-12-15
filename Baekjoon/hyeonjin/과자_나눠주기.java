import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        M = Integer.valueOf(str.nextToken());
        N = Integer.valueOf(str.nextToken());
        arr = new int[N];
        int max = 0;
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
            max = Math.max(arr[i], max);
        }

        binarySearch(1, max);
        System.out.println(result);

    }

    private static void binarySearch(int left, int right) {
        while(left <= right){
            int mid = (left + right) / 2;
            boolean check = checkShare(mid);
            if(check) left = mid + 1;
            else right = mid - 1;
        }

    }

    private static boolean checkShare(int mid) {
        int divide = 0;
        for(int i = 0; i < N; i++){
            if(divide > M - 1) break;
            divide += arr[i] / mid;
        }

        if(divide > M - 1) {
            result = mid;
            return true;
        }

        return false;
    }
}
