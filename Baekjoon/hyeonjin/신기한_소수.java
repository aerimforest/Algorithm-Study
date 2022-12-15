import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.valueOf(br.readLine());
        dfs(0,0,num);

    }

    private static void dfs(int value, int depth, int max) {
        if(max == depth){
            System.out.println(value);
            return;
        }

        for(int i = 1; i < 10; i++){
            int num = value * 10 + i;
            if(isPrime(num)) dfs(num, depth + 1, max);
        }
    }

    private static boolean isPrime(int num) {
        if(num < 2) return false;

        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
