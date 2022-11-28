import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int[] check;
    static int count = 0;
    static int num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.valueOf(br.readLine());
        check = new int[num];

        for(int i = 0 ; i < num; i++){
            check[0] = i;
            dfs(1);
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

    static boolean checkLine(int x, int y){
        //세로
        for(int i = 0; i < x; i++){
            if(check[i] == y)
                return true;
        }

        //우상향 대각선
        int sum = x + y;
        for(int i =0; i < x; i++){
            if(sum == i + check[i])
                return true;
        }

        //우하향 대각선
        int minus = x - y;
        for(int i = 0; i < x; i++){
            if(minus == i - check[i])
                return true;
        }

        return false;
    }

    static void dfs(int depth){
        if(depth == num){
            count++;
            return;
        }

        for(int i = 0; i < num; i++){
            if(checkLine(depth, i))
                continue;
            check[depth] = i;
            dfs(depth + 1);
            check[depth] = 0;
        }
    }
}
