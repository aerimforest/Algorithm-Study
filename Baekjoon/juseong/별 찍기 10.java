import java.io.*;
import java.util.*;

public class Main {

    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(map[i], ' ');

        rec(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void rec(int x, int y, int size){
        if(size == 3){ // 최소 단위 3
            for(int i = x; i < x+3; i++){
                for(int j = y; j < y+3; j++){
                    map[i][j] = '*';
                }
            }
            map[x+1][y+1] = ' ';
            return;
        }

        int ns = size/3;

        for(int i = x; i < x+size; i += ns){
            for(int j = y; j < y+size; j += ns){
                if((i == x + ns) && (j == y + ns)) continue; // 가운데 이면 반칸
                rec(i, j, size/3);
            }
        }
    }

}
