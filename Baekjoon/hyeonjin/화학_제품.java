import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());


        int[] amount = new int[3];
        int[] price = new int[3];

        int testCase = Integer.valueOf(str.nextToken());
        for(int t = 0; t < testCase; t++){
            max = 0;
            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++){
                amount[i] = Integer.valueOf(str.nextToken());
            }

            str = new StringTokenizer(br.readLine());
            for(int i =0; i < 3; i++){
                price[i] = Integer.valueOf(str.nextToken());
            }

            for(int i = 0; i <= Math.min(amount[0],amount[1]); i++){
                for(int j = 0; j <= Math.min(amount[1] - i, amount[2]); j++){
                    int num = Math.min(amount[0] - i, amount[2] - j);
                    max = Math.max(max, price[0] * i + price[1] * j + price[2] * num);
                }
            }

            bw.write(String.valueOf(max));
            bw.newLine();
        }
        bw.flush();
    }

}
