import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] arr = new int[N];
        int minusCnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] <= 0) minusCnt++;
        }

        Arrays.sort(arr);

        int idx = -1;

        while(++idx < minusCnt) {
            if(idx + 1 < minusCnt) answer += arr[idx] * arr[++idx];
            else answer += arr[idx];
        }

        idx = N;

        while(--idx >= minusCnt) {
            if( idx -1 >= minusCnt && arr[idx-1] > 1)
                answer += arr[idx] * arr[--idx];
            else answer += arr[idx];
        }

        System.out.println(answer);
    }

}