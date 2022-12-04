import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < count; i++){
            int num = Integer.valueOf(br.readLine());
            if(num == 0){
                if(pq.isEmpty())
                    System.out.println(0);
                else{
                    System.out.println(pq.poll());
                }
            }
            else
                pq.add(num);
        }
    }
}
