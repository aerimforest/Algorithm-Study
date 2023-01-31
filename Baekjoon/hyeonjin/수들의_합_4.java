import java.io.*;
import java.util.*;

public class 수들의_합_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());

        int[] arr = new int[N + 1];
        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
            arr[i] += arr[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        long count = 0;
        for(int i = 1; i <= N; i++){
            count += map.getOrDefault(arr[i] - K, 0);
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        System.out.println(count);
    }
}
