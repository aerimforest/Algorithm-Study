import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(priorityQueue.isEmpty()){
                    sb.append("0").append("\n");
                }else{
                    sb.append(priorityQueue.poll()).append("\n");
                }
            }else{
                priorityQueue.add(num);
            }
        }
        System.out.println(sb);
    }
}
