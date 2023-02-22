import java.io.*;
import java.util.*;

public class 여행_가자 {
    static int N;
    static int M;
    static int[][] arr;
    static int[] parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;
        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());
        arr = new int[N + 1][N + 1];
        parents = new int[N + 1];

        for(int i = 0; i <= N; i++){
            parents[i] = i;
        }

        for(int i = 1; i <= N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                if(arr[i][j] == 1) union_root(i, j);
            }
        }

        int[] city = new int[M];
        str = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < M; i++){
            city[i] = Integer.valueOf(str.nextToken());
            int num = find_root(city[i]);
            if(i == 0) root = num;
            else {
                if(root != num) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    private static void union_root(int i, int j) {
        int x = find_root(i);
        int y = find_root(j);

        if(x == y) return;

        parents[x] = y;
    }

    private static int find_root(int x){
        if(parents[x] == x) return x;
        return parents[x] = find_root(parents[x]);
    }
}
