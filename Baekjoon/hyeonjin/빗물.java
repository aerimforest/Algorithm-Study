import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int H = Integer.valueOf(str.nextToken());
        int W = Integer.valueOf(str.nextToken());
        int[] arr = new int[W];
        int result = 0;
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        for(int i = H; i >= 0; i--){
            int left = -1;
            int right = -1;
            for(int j = 0; j < W; j++){
                if(arr[j] >= i){
                    //좌측 값을 우측값에 넣는 방식이라서 우측값이 있으면 물이 차있는거임
                    left = right;
                    right = j;

                    if(left != -1) result += (right - left - 1);
                }
            }
        }
        System.out.println(result);
    }
}
