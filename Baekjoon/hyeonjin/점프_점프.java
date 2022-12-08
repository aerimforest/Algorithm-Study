import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int[] arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        if(N == 1){
            if(arr[0] == 0)
                System.out.println(0);
            else
                System.out.println(1);
            return;
        }

        boolean[] check = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= arr[0]; i++){
            queue.add(0 + i);
            check[0 + i] = true;
        }

        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int num = queue.poll();
                if(num == N - 1){
                    System.out.println(count);
                    return;
                }
                else if(num > N - 1)
                    continue;

                for(int j = 1; j <= arr[num]; j++){
                    if(num + j > N - 1)
                        continue;

                    if(!check[num + j]) {
                        queue.add(num + j);
                        check[num + j] = true;
                    }
                }
            }

            count++;
        }

        System.out.println(-1);
    }
}
