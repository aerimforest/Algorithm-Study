import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }
        int M = Integer.valueOf(br.readLine());

        if(N == 1){
            System.out.println(0);
            return;
        }

        int[] result = new int[100];
        int index;
        int cost = 0;
        int minIndex = findMinNum(0);

        //0일 경우 첫번째에 다른값을 넣어주기
        if(minIndex == 0){
            minIndex = findMinNum(1);
            if(arr[minIndex] > M){
                System.out.println(0);
                return;
            }
            result[0] = minIndex;
            cost += arr[minIndex];
            minIndex = 0;
        }
        else{
            result[1] = minIndex;
            cost += arr[minIndex];
        }

        index = (M - cost) / arr[minIndex];
        for(int i = 1; i <= index; i++){
            result[i] = minIndex;
            cost += arr[minIndex];
        }

        //자리수를 구했으면 앞자리부터 값 변경 해주기
        for(int i = 0; i <= index; i++){
            for(int j = N - 1; j >= 0; j--){
                if(cost + (arr[j] - arr[result[i]]) <= M){
                    cost = cost + (arr[j] - arr[result[i]]);
                    result[i] = j;
                    break;
                }
            }
        }

        String answer = "";
        for(int i =0; i <= index; i++){
            answer += result[i];
        }
        System.out.println(answer);
    }

    private static int findMinNum(int index) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = index; i < N; i++) {
            if (min > arr[i]) {
                min = arr[i];
                result = i;
            }
        }
        return result;
    }
}
