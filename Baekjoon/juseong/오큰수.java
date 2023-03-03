import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++)
            data[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i<N; i++){

            while(!s.isEmpty() && data[s.peek()] < data[i]){
                data[s.pop()] = data[i];
            }

            s.add(i);
        }

        while(!s.isEmpty())
            data[s.pop()] = -1;

        for(int i = 0; i<N; i++)
            sb.append(data[i]).append(" ");

        System.out.println(sb);
    }
}
