import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        List<People> people = new ArrayList<>();
        for(int i = 0; i < N; i++){
            people.add(new People(Integer.valueOf(str1.nextToken()), Integer.valueOf(str2.nextToken())));
        }

        Collections.sort(people);

        int[][] dp = new int[N][100];

        for(int i = 0; i < 100; i++){
            dp[0][i] = i >= people.get(0).hp ? people.get(0).joy : 0;
        }


        for(int i = 1; i < N; i++){
            People target = people.get(i);
            for(int j = 1; j < 100; j++){
                if(target.hp <= j) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - target.hp] + target.joy);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N - 1][99]);
    }

    public static class People implements Comparable<People>{
        int joy;
        int hp;
        public People(int hp, int joy){
            this.joy = joy;
            this.hp = hp;
        }

        @Override
        public int compareTo(People o) {
            return hp - o.hp;
        }
    }
}
