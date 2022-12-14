import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.valueOf(br.readLine());
        for(int i = 0; i < test_case; i++){
            boolean reverse = false;
            String str = br.readLine();
            int num = Integer.valueOf(br.readLine());
            String arrayStr = br.readLine();

            if(num == 0){
                if(str.contains("D")) bw.write("error");
                else bw.write("[]");
                bw.newLine();
                continue;
            }

            arrayStr = arrayStr.substring(1,arrayStr.length() - 1);
            int[] values = Arrays.stream(arrayStr.split(",")).mapToInt(Integer::parseInt).toArray();
            Deque<Integer> deque = new ArrayDeque<>();
            for(int j = 0; j < values.length; j++){
                deque.add(values[j]);
            }

            boolean error = false;

            for(int j = 0; j < str.length(); j++){
                if(deque.size() == 0){
                    error = true;
                    break;
                }

                char c = str.charAt(j);

                if(c == 'R') reverse = !reverse;
                else{
                    if(reverse) deque.pollLast();
                    else deque.pollFirst();
                }
            }

            if(error) bw.write("error");
            else {
                String[] result = new String[deque.size()];
                int size = deque.size();
                for(int j = 0; j < size; j++){
                    if(reverse) result[j] = String.valueOf(deque.pollLast());
                    else result[j] = String.valueOf(deque.pollFirst());
                }
                bw.write(Arrays.toString(result).replace(" ", ""));
            }
            bw.newLine();
        }
        bw.flush();
    }
}
