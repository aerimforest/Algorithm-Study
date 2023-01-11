import java.io.*;
import java.util.*;

public class Main {

    static int N , count ;
    static int[][] arr;
    static int[] dx = {-1,0,1,0}, dy={0,1,0,-1};
    static boolean[][] visited;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            String str =br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j) - 'A';
            }
        }

        FindRGB();
        System.out.println(count);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 17) arr[i][j] = 6;
            }
        }

        FindRGB();
       System.out.println(count);

        
	}

    public static void FindRGB(){
        visited = new boolean[N][N];
        count = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    DFS(i,j,arr[i][j]);
                    count += 1;
                }
            }
        }
    }

    public static void DFS(int x, int y,int color){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int xx= x+dx[i];
            int yy= y+dy[i];

            if(xx<0 || xx>=N || yy<0 || yy>=N || visited[xx][yy] ) continue;
            if(color == arr[xx][yy]) DFS(xx,yy, color);
        }
    }
}
