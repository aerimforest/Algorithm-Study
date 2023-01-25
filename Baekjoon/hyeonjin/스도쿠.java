import java.io.*;
import java.util.*;

public class 스도쿠 {
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] cols = new boolean[9][10];
    static boolean[][] smallBoards = new boolean[9][10]; // 3x3
    static int[][] arr = new int[9][9];
    static boolean end = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 9; i++){
            String s = br.readLine();
            for(int j = 0; j < 9; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j));
                rows[i][arr[i][j]] = true;
                cols[j][arr[i][j]] = true;
                smallBoards[3 * (i / 3) + (j/3)][arr[i][j]] = true;
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if(end) return;

        if(depth == 81){
            output();
            end = true;
            return;
        }

        int r = depth / 9;
        int c = depth % 9;

        if(arr[r][c] != 0){
            dfs(depth + 1);
            return;
        }

        for(int i = 1; i < 10; i++){
            if(rows[r][i] || cols[c][i] || smallBoards[3 * (r/3) + (c/3)][i]) continue;

            rows[r][i] = true;
            cols[c][i] = true;
            smallBoards[3 * (r/3) + (c/3)][i] = true;
            arr[r][c] = i;

            dfs(depth + 1);

            rows[r][i] = false;
            cols[c][i] = false;
            smallBoards[3 * (r/3) + (c/3)][i] = false;
            arr[r][c] = 0;

        }
    }

    private static void output() {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
