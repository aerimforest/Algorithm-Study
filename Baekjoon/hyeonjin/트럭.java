import java.io.*;
import java.util.*;

public class 트럭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int W = Integer.valueOf(str.nextToken());
        int L = Integer.valueOf(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < W; i++){
            queue.add(0);
        }
        int time = 0;
        int sum = 0;
        int index = 0;
        while(!queue.isEmpty()){
            time++;
            sum -= queue.poll();

            if(index < N){
                if(arr[index] + sum <= L){
                    sum += arr[index];
                    queue.add(arr[index++]);
                }
                else{
                    queue.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
