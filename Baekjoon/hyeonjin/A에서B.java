import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        long A = Integer.valueOf(str.nextToken());
        long B = Integer.valueOf(str.nextToken());

        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        int count = 1;

        while(!queue.isEmpty()){
            count++;

            int size = queue.size();

            for(int i = 0; i < size; i++){
                long num = queue.poll();

                if(num * 2 == B || num * 10 + 1 == B) {
                    System.out.println(count);
                    return;
                }

                //숫자가 더 크게되면 계산을 할필요가 없음
                if(num * 2 < B) queue.add(num * 2);
                if(num * 10 + 1 < B) queue.add(num * 10 + 1);
            }
        }

        System.out.println(-1);

    }
}
