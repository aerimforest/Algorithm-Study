import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int[] condition;
    static int[][] arr;
    static boolean[] check;

    static int min = Integer.MAX_VALUE;
    static String subResult = "";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        condition = new int[4];
        arr = new int[N][5];
        check = new boolean[N];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            condition[i] = Integer.valueOf(str.nextToken());
        }

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        dfs(0);
        if(subResult.isEmpty()) System.out.println(-1);
        else {
            System.out.println(min);
            System.out.println(subResult);
        }
    }

    private static void dfs(int depth) {
        if(depth == N){
            checkSatisfied();
            return;
        }

        check[depth] = true;
        dfs(depth + 1);

        check[depth] = false;
        dfs(depth + 1);
    }

    private static void checkSatisfied() {
        String select = "";
        int[] sum = new int[5];
        for(int i = 0; i < N; i++){
            if(!check[i]) continue;
            select += (i + 1) + " ";
            for(int j = 0; j < 5; j++){
                sum[j] += arr[i][j];
            }
        }

        for(int i = 0; i < 4; i++){
            if(sum[i] < condition[i]) return;
        }

        if(min > sum[4]){
            min = sum[4];
            subResult = select;
        }
    }
}
