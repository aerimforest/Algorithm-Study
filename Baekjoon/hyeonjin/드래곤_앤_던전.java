import java.io.*;
import java.util.*;

public class 드래곤_앤_던전 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        long M = Long.valueOf(str.nextToken());

        long max = 0;
        long hp = 0;
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            int t = Integer.valueOf(str.nextToken()); // 몬스터 or 회복
            long a = Long.valueOf(str.nextToken()); // 공격력
            long h = Long.valueOf(str.nextToken()); // 생명력

            //몬스터와 싸움
            if(t == 1){
                hp += a * (h / M);
                if(h % M == 0) hp -= a;
                max = Math.max(hp, max);
            }
            //회복
            else{
                M += a;
                hp = Math.max(hp - h, 0);
            }
        }

        System.out.println(max + 1);
    }
}
