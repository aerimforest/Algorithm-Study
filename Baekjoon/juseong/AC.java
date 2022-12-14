import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testcase; t++){
            String commands = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String number = br.readLine();
            number = number.replace("[","");
            number = number.replace("]","");
            StringTokenizer st = new StringTokenizer(number, ",");
            Deque<Integer> queue = new ArrayDeque<>();
            while(st.hasMoreTokens()){
                queue.addLast(Integer.parseInt(st.nextToken()));
            }
            boolean isError = false;
            int reverse = 1;
            for(int cmd = 0; cmd < commands.length(); cmd++){
                if(commands.charAt(cmd) == 'D' && queue.isEmpty()){
                    System.out.println("error");
                    isError = true;
                    break;
                }
                if(commands.charAt(cmd) == 'R'){
                    reverse *= -1;
                }else if(commands.charAt(cmd) == 'D'){
                    if(reverse > 0){
                        queue.pollFirst();
                    }else{
                        queue.pollLast();
                    }
                }
            }
            if(!isError){
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                int n =  queue.size()-1;
                if(reverse > 0){
                    if(queue.size() > 1){
                        for(int i = 0; i < n; i++){
                            sb.append(queue.pollFirst()).append(",");
                        }
                    }
                }else{
                    if(queue.size() > 1){
                        for(int i = 0; i < n; i++){
                            sb.append(queue.pollLast()).append(",");
                        }
                    }
                }
                if(queue.size() > 0){
                    sb.append(queue.pollFirst()).append("]");
                }else{
                    sb.append("]");
                }
                System.out.println(sb);
            }
        }
    }
}
