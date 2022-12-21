import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] money;
    static int[] friend;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());

        money = new int[N + 1];
        friend = new int[N + 1];
        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            money[i] = Integer.valueOf(str.nextToken());
            friend[i] = i;
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int friend1 = find(Integer.valueOf(str.nextToken()));
            int friend2 = find(Integer.valueOf(str.nextToken()));

            if(money[friend1] > money[friend2]){
                money[friend1] = money[friend2];
                friend[friend1] = friend[friend2];
            }
            else{
                money[friend2] = money[friend1];
                friend[friend2] = friend[friend1];
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++){
            if(friend[i] == i) sum += money[i];
        }

        if(sum > K) System.out.println("Oh no");
        else System.out.println(sum);
    }

    public static int find(int x){
        if(friend[x] == x) return x;
        return friend[x] = find(friend[x]);
    }
}
