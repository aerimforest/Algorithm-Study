import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int max = Integer.MIN_VALUE;
        int result = 0;
        int[] jewel = new int[M];

        for(int i = 0; i < M; i++){
            jewel[i] = Integer.valueOf(br.readLine());
            max = Math.max(max, jewel[i]);
        }


        int min = 1;
        while(min <= max){
            int mid = (max + min) / 2;
            int peopleNum = 0;
            for(int i = 0; i < M; i++){
                peopleNum += jewel[i] / mid;
                if(jewel[i] % mid != 0)
                    peopleNum++;
            }

            if(peopleNum > N){
                min = mid + 1;
            }
            else{
                max = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}
