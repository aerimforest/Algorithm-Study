package SolveAc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa2186 {
    /*
    위의 문제는 간단하게 생각했을 때는 dfs를 사용해볼까 했지만...
    갈수있는 경로의 수가 20개다보니까 매번 20개를 확인해야한다.
    20개를 확인하는데 마지막의 문자열이 최대 80자까지 나오므로 경우의수는 20^80이여서 dfs를 사용하면 안될 것이다.
    그래서 지난 경로들을 dp로 저장을 해서 풀어야할것같은데 구현이 잘안되어 실패...
    dp를 좀 더 공부하고 다시 풀어봐야겠다.
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(str.nextToken());
        int m = Integer.valueOf(str.nextToken());
        int k = Integer.valueOf(str.nextToken());

        char[][] array = new char[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                array[i][j] = s.charAt(j);
            }
        }

        String find = br.readLine();

        for(int i = 0; i < n; i++){
            for(int j =0 ; j < m; j++){
                if(array[i][j] == find.charAt(0)){

                }
            }
        }
    }
}
