import java.io.*;
import java.util.*;

public class 좋은_친구 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());
        Queue<Integer>[] queue = new Queue[21];

        for(int i = 0; i < 21; i++){
            queue[i] = new LinkedList<>();
        }

        long count = 0;
        for(int i = 0; i < N; i++){
            int length = br.readLine().length();

            //해당하는 글자수가 비어있는 경우
            if(queue[length].isEmpty()){
                queue[length].add(i);
                continue;
            }

            //넣으려는 번호와 기존에 있는 번호가 K 값보다 클 때
            while(!queue[length].isEmpty() && i - queue[length].peek() > K){
                queue[length].poll();
            }

            //쌍을 이룰 때
            count += queue[length].size();
            queue[length].add(i);
        }

        System.out.println(count);
    }
}
