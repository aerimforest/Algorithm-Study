import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int max;
    static boolean[] isNotPrime;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> numbers = new ArrayList<>();
        max = 0;
        while(true){
            int N = Integer.valueOf(br.readLine());
            if(N == 0) break;

            numbers.add(N);
            max = Math.max(max, N);
        }


        isNotPrime = new boolean[max + 1];
        checkPrime();
        //출력
        for(int i = 0; i < numbers.size(); i++){
            int num = numbers.get(i);
            for(int j = 2; j <= max; j++){
                if(!isNotPrime[j] && !isNotPrime[num - j]) {
                    bw.write(String.valueOf(num) + " = " + String.valueOf(j) + " + " + String.valueOf(num - j));
                    bw.newLine();
                    break;
                }
            }
        }
        bw.flush();
    }

    private static void checkPrime() {
        for(int i = 2; i <= Math.sqrt(max); i++){

            int num = i * 2;
            while(num <= max){
                isNotPrime[num] = true;
                num += i;
            }
        }
    }
}
