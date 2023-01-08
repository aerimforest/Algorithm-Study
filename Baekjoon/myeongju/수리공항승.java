import java.util.*;
import java.io.*;

public class Main {
    static int N,L;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int pre = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(pre<arr[i]) {
                cnt++;
                pre = arr[i] + L -1;
            }
        }
        System.out.print(cnt);
    }

}