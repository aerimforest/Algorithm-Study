import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int testCase = Integer.valueOf(str.nextToken());
        int numA;
        int numB;
        int count;

        for(int t = 0; t < testCase; t++){
            count = 0;
            str = new StringTokenizer(br.readLine());
            numA = Integer.valueOf(str.nextToken());
            numB = Integer.valueOf(str.nextToken());

            int[] arrA = new int[numA];
            int[] arrB = new int[numB];

            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < numA; i++){
                arrA[i] = Integer.valueOf(str.nextToken());
            }

            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < numB; i++){
                arrB[i] = Integer.valueOf(str.nextToken());
            }
            Arrays.sort(arrB);

            for(int i = 0; i < numA; i++){
                for(int j = 0; j < numB; j++){
                    if(arrA[i] <= arrB[j])
                        break;

                    count++;
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }
        bw.flush();

    }
}
