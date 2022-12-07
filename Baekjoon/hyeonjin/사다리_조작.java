import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][] map;
    static int[] value;
    static boolean finish;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        H = Integer.valueOf(str.nextToken());

        map = new int[H + 1][N + 1];

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            map[x][y] = 1;
            map[x][y + 1] = 2;
        }

        int result = -1;
        for(int i = 0; i <= 3; i++){
            dfs(1,0,i);
            if(finish) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int x, int count, int depth) {
        if(finish) return;

        if(count == depth){
            for(int i = 1; i <= N; i++){
                int widthLine = 1;
                int verticalLine = i;

                for(int j = 0; j < H; j++){
                    if(map[widthLine][verticalLine] == 1) verticalLine++;
                    else if(map[widthLine][verticalLine] == 2) verticalLine--;

                    widthLine++;
                }

                if(verticalLine != i) return;
            }

            finish = true;
            return;
        }


        for(int i = x; i <= H; i++){
            for(int j = 1; j < N; j++){
                if(map[i][j] == 0 && map[i][j + 1] == 0){
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, count + 1, depth);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }
}
