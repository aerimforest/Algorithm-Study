import java.io.*;
import java.util.*;

public class Main {

    static int N,K;
    static int[] arr;
    static int[] coinCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        coinCase = new int[K+1];
        coinCase[0] = 1;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            for(int j=arr[i];j<=K;j++){
                coinCase[j] += coinCase[j-arr[i]];
            }
        }
        System.out.println(coinCase[K]);
    }
}
