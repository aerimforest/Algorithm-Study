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

        int num = Integer.valueOf(str.nextToken());
        int[] arr = new int[num];

        str = new StringTokenizer(br.readLine());
        for(int i =0 ; i < num; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        int start = 0;
        int end = num - 1;
        int min = Integer.MAX_VALUE;
        int value1 = 0;
        int value2 = 0;

        Arrays.sort(arr);


        while(start < end){
            int sum = arr[start] + arr[end];

            if(Math.abs(sum) < min){
                value1 = arr[start];
                value2 = arr[end];
                min = Math.abs(sum);
            }

            if(sum > 0)
                end--;
            else
                start++;
        }

        System.out.println(value1 + " " + value2);

    }
}
