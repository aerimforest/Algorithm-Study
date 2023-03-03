import java.io.*;
import java.util.*;

class Node{
    int x,y,count;
    Node (int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {

    static int N,M,result;
    static int[][] arr;
    static int[] dx = {-1,0,1,0,-1,-1,1,1};
    static int[] dy = {0,1,0,-1,-1,1,-1,1};
    static boolean[][] visited;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 0){
                    visited = new boolean[N][M];
                    BFS(i,j);
                }
            }
        }
        System.out.println(result);

    }

    public static void BFS(int i, int j){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j,0));
        visited[i][j] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count + 1;
            for(int k=0;k<8;k++){
                int xx = x+dx[k];
                int yy = y+dy[k];
                if(xx<0 || xx>=N || yy<0 || yy>=M || visited[xx][yy] ) continue;
                visited[xx][yy] = true;
                if(arr[xx][yy] == 1){
                    result = Math.max(result, count);
                    return;
                }
                q.add(new Node(xx, yy, count));
            }
        }

    }


}

