import java.io.*;
import java.util.*;

public class 회전_초밥 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int D = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());
        int C = Integer.valueOf(str.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }

        int min = 0;
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(); //초밥 번호, 개수
        for(int i = 0; i < K; i++){
            deque.add(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        min = Integer.max(min, map.containsKey(C) ? map.size() : map.size() + 1);

        int num = 0;
        for(int i = 1; i < N + K; i++){
            //제외 시키는 부분
            num = deque.pollFirst();
            if(map.get(num) > 1) map.put(num, map.get(num) - 1);
            else map.remove(num);

            //새로운 그릇 추가
            int index = i % N;
            deque.add(arr[index]);
            map.put(arr[index], map.getOrDefault(arr[index], 0) + 1);

            //초밥 최대값 체크
            min = Integer.max(min, map.containsKey(C) ? map.size() : map.size() + 1);
        }

        System.out.println(min);
    }
}
