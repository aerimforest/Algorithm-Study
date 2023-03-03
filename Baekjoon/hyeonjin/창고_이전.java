import java.io.*;
import java.util.*;

public class 창고_이전 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());

        int[] basic = new int[N + 1];
        int[] renewal = new int[M + 1];


        for(int i = 1; i <= N; i++){
            basic[i] = Integer.valueOf(br.readLine());
        }
        for(int i = 1; i <= M; i++){
            renewal[i] = Integer.valueOf(br.readLine());
        }

        int cnt = 0;
        long result = 0;
        int basicIndex = 1;
        int newIndex = 1;
        while(basicIndex <= N && newIndex <= M){
            //기존 층에 남아있는 짐이 0인 경우
            if(basic[basicIndex] == 0){
                basicIndex++;
                continue;
            }

            //새로운 층에 짐을 다 넣는 경우
            if(renewal[newIndex] == 0){
                newIndex++;
                continue;
            }

            cnt++;
            result += (long)basicIndex + newIndex;
            basic[basicIndex]--;
            renewal[newIndex]--;
        }

        System.out.println(cnt + " " + result);
    }
}
