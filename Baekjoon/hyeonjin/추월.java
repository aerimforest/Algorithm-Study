import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int[] check = new int[N];
        for(int i = 0; i < N; i++){
            map.put(br.readLine(), i);
        }

        for(int i = 0; i < N; i++){
            check[i] = map.get(br.readLine());
        }

        //추월 확인
        int result = 0;
        //각각의 i번째에 있는 차량이 추월을 했는지 확인
        for(int i = N - 2; i >= 0; i--){
            for(int j = i + 1; j < N; j++){
                if(check[i] > check[j]){
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
