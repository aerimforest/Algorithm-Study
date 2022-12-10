import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        int under1Count = 0;
        int same1Count = 0;
        int over1Count = 0;
        for(int i =0 ; i < N; i++){
            arr[i] = Integer.valueOf(br.readLine());
            if(arr[i] < 1) under1Count++;
            else if(arr[i] == 1) same1Count++;
            else over1Count++;
        }

        Arrays.sort(arr);

        //0이하 일땐 곱하는게 최고
        int sum = 0;
        if(under1Count % 2 == 1) sum += arr[under1Count - 1];
        for(int i = 0; i < under1Count / 2; i++){
            sum += arr[2 * i] * arr[2 * i + 1];
        }
        int index = under1Count;

        //1은 무조건 더하는게 최고
        for(int i = 0; i < same1Count; i++){
            sum++;
        }
        index += same1Count;

        //1이상도 짝수면 곱하기
        if(over1Count % 2 == 1) {
            sum += arr[index];
            index++;
        }

        for(int i = 0; i < over1Count / 2; i++){
            sum += arr[index + (2 * i)] * arr[index + (2 * i) + 1];
        }

        System.out.println(sum);
    }
}
