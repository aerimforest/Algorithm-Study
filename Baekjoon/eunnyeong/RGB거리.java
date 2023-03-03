import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][3]; //dp 위해 1~n+1
        
        for (int i = 1; i <= n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++)
        		map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int[][] memo = new int[n + 1][3]; //dp위해 1~n+1
        for (int i = 1; i <= n; i++) {
        	memo[i][0] = map[i][0] + Math.min(memo[i - 1][1], memo[i - 1][2]); //R로 시작했을때 최솟값
        	memo[i][1] = map[i][1] + Math.min(memo[i - 1][0], memo[i - 1][2]); //G로 시작했을때 최솟값
        	memo[i][2] = map[i][2] + Math.min(memo[i - 1][0], memo[i - 1][1]); //B로 시작했을때 최솟값
        }
        
        System.out.println(Math.min(Math.min(memo[n][0], memo[n][1]),memo[n][2])); //RGB 최솟값 중 최솟값
    }
}
