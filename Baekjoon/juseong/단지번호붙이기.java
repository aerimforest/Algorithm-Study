import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static char[][] map;
    static boolean visit[][];
    static int[] di = {0 , 0, 1 , -1};
    static int[] dj = {1 , -1, 0 , 0};
    static int N;
    static int conut;

    static void dfs(int i, int j){
        visit[i][j] = true;
        conut++;
        for(int k = 0; k < 4; k++){
            int nextI = i + di[k];
            int nextJ = j + dj[k];
            if(nextI  >= 0 && nextI < N && nextJ >= 0 && nextJ < N
                    && map[nextI][nextJ] == '1' && !visit[nextI][nextJ]){
                dfs(nextI, nextJ);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];
        for(int k = 0; k < N; k++){
            String line = br.readLine();
            map[k] = line.toCharArray();
        }
        List<Integer> complex = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == '1' && !visit[i][j]){
                    conut = 0;
                    dfs(i, j);
                    complex.add(conut);
                }
            }
        }
        Collections.sort(complex);
        System.out.println(complex.size());
        for(int num : complex){
            System.out.println(num);
        }
    }
}
