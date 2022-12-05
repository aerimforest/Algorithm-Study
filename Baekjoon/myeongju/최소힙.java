import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(N-->0) {

            int n = Integer.parseInt(br.readLine());

            if(n==0) {
                if(queue.isEmpty()) sb.append("0\n");
                else sb.append(queue.poll()+"\n");
            }

            else queue.add(n);
        }

        System.out.println(sb);
    }
}