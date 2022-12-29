import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++)
            map.put(br.readLine(), i);

        int[] arr = new int[N]; // i : 나온 순서 arr[i] : 들어온 순서
        for (int i = 0; i < N; i++)
            arr[i] = map.get(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(arr[i] > arr[j]) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.print(cnt);
    }
}