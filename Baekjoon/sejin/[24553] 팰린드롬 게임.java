import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<N;i++){
            long now = Long.parseLong(br.readLine()); 
            if(now%10 == 0) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb.toString());

    }


}
