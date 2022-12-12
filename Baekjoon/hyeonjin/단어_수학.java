import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(br.readLine());
        int[] alpha = new int[26];
        for(int i = 0; i < num; i++){
            String str = br.readLine();
            for(int j = 1; j <= str.length(); j++){
                alpha[str.charAt(j - 1) - 'A'] += Math.pow(10, str.length() - j);
            }
        }

        Arrays.sort(alpha);
        int sum = 0;
        int value = 9;

        for(int i = 25; i >= 0; i--){
            if(alpha[i] == 0) break;

            sum += (alpha[i] * value);
            value--;
        }

        System.out.println(sum);
    }
}
