import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int num = Integer.valueOf(str.nextToken());
        int conti = Integer.valueOf(str.nextToken());
        ArrayList<Integer> doll = new ArrayList<>();

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            int n = Integer.valueOf(str.nextToken());
            if(n == 1)
                doll.add(i);
        }

        if(doll.size() < conti){
            System.out.println(-1);
            return;
        }
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= doll.size() - conti; i++){
            int sum = doll.get(conti - 1 + i) - doll.get(i) + 1;
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}
