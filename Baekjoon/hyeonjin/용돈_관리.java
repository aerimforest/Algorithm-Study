import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] amount;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        amount = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++){
            amount[i] = Integer.valueOf(br.readLine());
            max = Math.max(amount[i], max);
        }

        binarySearch(1, max * N);
        System.out.println(result);
    }

    private static void binarySearch(int left, int right) {
        while(left <= right){
            int mid = (left + right) / 2;
            boolean check = checkDivide(mid);
            if(check) right = mid - 1;
            else left = mid + 1;
        }
    }

    private static boolean checkDivide(int mid) {
        int fullCount = 0;
        int value = 0;
        for(int i = 0; i < N; i++){
            if(fullCount >= M) return false;

            if(value + amount[i] > mid){
                i--;
                value = 0;
                fullCount++;
            }
            else value += amount[i];
        }

        result = mid;
        return true;
    }
}
